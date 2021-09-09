import java.io.RandomAccessFile;
import java.io.File;
import java.lang.reflect.Constructor;

public class Arquivo<T extends Registro> {
  RandomAccessFile arquivo;
  Constructor<T> construtor;
  String diretorio = "dados";
  protected HashExtensivel<ParIDEndereco> indiceDireto;

  final int TAMANHO_CABECALHO = 4;

  public Arquivo(String nomeArquivo, Constructor<T> constr) throws Exception {
    File f = new File(diretorio);
    if (!f.exists()) {
      f.mkdir();
    }

    f = new File(diretorio + "/" + nomeArquivo);
    
    if (!f.exists())
      f.mkdir();

    indiceDireto = new HashExtensivel<>(
      ParIDEndereco.class.getConstructor(),
      4,
      "dados/" + nomeArquivo + ".hash_d.db",
      "dados/" + nomeArquivo + ".hash_c.db"
    );
    
    arquivo = new RandomAccessFile(diretorio + "/" + nomeArquivo + "/arquivo.db", "rw");
    construtor = constr;
    if (arquivo.length() == 0) {
      arquivo.writeInt(0);//id inicial
    }
  }
  
  //--- Operações do Crud ---
  //criação
  public int create(T obj) throws Exception {
    arquivo.seek(0);
    int ultimoID = arquivo.readInt();
    int proximoID = ultimoID + 1;
    long pos = arquivo.length();
    arquivo.seek(0);
    arquivo.writeInt(proximoID);

    obj.setID(proximoID);
    byte[] ba = obj.toByteArray();
    gravar(pos, (byte)' ', ba.length, ba);
    indiceDireto.create(new ParIDEndereco(obj.getID(), pos));
    return proximoID;
  }

  public void gravar(long pos, byte lapide, int len, byte[] ba)throws Exception{
    arquivo.seek(pos);
    arquivo.writeByte(lapide);
    arquivo.writeInt(len);
    arquivo.write(ba);
  }

  public long procuraEndereco(int id)throws Exception{
    System.out.println("Id Procurado -> " + id);
    ParIDEndereco par = indiceDireto.read(id);
    long endereco = (par == null)?-1:par.getEndereco();
    return endereco;
  }

  //leitura
  public T read(int id) throws Exception{
    long endereco = procuraEndereco(id);
    if(endereco > 0){
      arquivo.seek(endereco);
      byte lapide = arquivo.readByte();
      int tam = arquivo.readInt();
      T obj = construtor.newInstance();
      byte[] ba;
      if (lapide == ' ') {
        ba = new byte[tam];
        arquivo.read(ba);
        obj.fromByteArray(ba);//extraimos o objeto
        if (obj.getID() == id)
          return obj;
      } 
    }
    return null;
  }
  //atualização
  public boolean update(T novoObj)throws Exception{
    T obj = read(novoObj.getID());
    boolean sucesso = false;

    if (obj != null){
      long endereco = procuraEndereco(novoObj.getID());
      byte[] baAntigo = obj.toByteArray(); 
      byte[] baNovo = novoObj.toByteArray();

      if(baAntigo.length <= baNovo.length)
        gravar(endereco, (byte)' ', baNovo.length, baNovo);

      else {
        arquivo.seek(endereco);//voltamos a posicao do lapide
        arquivo.writeByte('*');
        gravar(arquivo.length(), (byte)' ', baNovo.length, baNovo);
      }
      indiceDireto.update(new ParIDEndereco(novoObj.getID(), endereco));
      sucesso = true;
    }
    return sucesso;
  }

  //remoção
  public boolean delete(int idRemovido)throws Exception{
    T obj = read(idRemovido);
    boolean sucesso = false;
    if (obj != null){
        arquivo.seek(procuraEndereco(idRemovido));//voltamos a posicao do lapide
        arquivo.writeByte('*');
        indiceDireto.delete(idRemovido);
        sucesso = true;
    }
    return sucesso;
  }
}
