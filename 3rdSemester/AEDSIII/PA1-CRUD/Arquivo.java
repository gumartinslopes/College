import java.io.RandomAccessFile;
import java.io.File;
import java.lang.reflect.Constructor;

public class Arquivo<T extends Registro> {
  RandomAccessFile arquivo;
  Constructor<T> construtor;
  String diretorio = "dados";

  final int TAMANHO_CABECALHO = 4;

  public Arquivo(String nomeArquivo, Constructor<T> constr) throws Exception {
    File f = new File(diretorio);
    if (!f.exists()) {
      f.mkdir();
    }

    f = new File(diretorio + "/" + nomeArquivo);
    
    if (!f.exists()) {
      f.mkdir();
    }
    
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
    arquivo.seek(0);
    arquivo.writeInt(proximoID);

    obj.setID(proximoID);
    byte[] ba = obj.toByteArray();
    gravar(arquivo.length(), (byte)' ', ba.length, ba);

    return proximoID;
  }

  public void gravar(long pos, byte lapide, int len, byte[] ba)throws Exception{
    arquivo.seek(pos);
    arquivo.writeByte(lapide);
    arquivo.writeInt(len);
    arquivo.write(ba);
  }

  //leitura
  public T read(int id) throws Exception{
    arquivo.seek(TAMANHO_CABECALHO); 
    byte lapide;
    int tam;
    T obj = construtor.newInstance();
    byte[] ba;
    while (arquivo.getFilePointer() < arquivo.length()) {
      lapide = arquivo.readByte();
      tam = arquivo.readInt();
      if (lapide == ' ') {
        ba = new byte[tam];
        arquivo.read(ba);
        obj.fromByteArray(ba);
        
        if (obj.getID() == id){
          //voltamos para a posição do registro pesquisado
          arquivo.seek(arquivo.getFilePointer() - 4 - 1 - ba.length);
          return obj;
        }
      } 
      else
        arquivo.skipBytes(tam);
    }
    return null;
  }

  //atualização
  public boolean update(T novoObj)throws Exception{
    T obj = read(novoObj.getID());
    boolean sucesso = false;
    if (obj != null){
      byte[] baAntigo = obj.toByteArray(); 
      byte[] baNovo = novoObj.toByteArray();

      if(baAntigo.length <= baNovo.length)
        gravar(arquivo.getFilePointer(), (byte)' ', baNovo.length, baNovo);

      else {
        delete(obj.getID());
        gravar(arquivo.length(), (byte)' ', baNovo.length, baNovo);
      }
      sucesso = true;
    }
    return sucesso;
  }

  //remoção
  public boolean delete(int idRemovido)throws Exception{
    T obj = read(idRemovido);
    boolean sucesso = false;
    if (obj != null){
        arquivo.writeByte('*');
        sucesso = true;
    }
    return sucesso;
  }
}
