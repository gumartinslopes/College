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

  public T read(int idProcurado) throws Exception {
    arquivo.seek(TAMANHO_CABECALHO); // pular o cabeçalho e se posicionar no primeiro registro
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
        
        if (obj.getID() == idProcurado)
          return obj;
      } 
      else
        arquivo.skipBytes(tam);
    }
    return null;
  }

  public void update(){
    //construir
  }

  public boolean delete(int idRemovido)throws Exception{
    arquivo.seek(TAMANHO_CABECALHO); 
    byte lapide;
    int tam;
    boolean sucesso = false;
    T obj = construtor.newInstance();
    byte[] ba;
    while (arquivo.getFilePointer() < arquivo.length()) {
      lapide = arquivo.readByte();
      tam = arquivo.readInt();
      if (lapide == ' ') {
        ba = new byte[tam];
        arquivo.read(ba);
        obj.fromByteArray(ba);
        
        if (obj.getID() == idRemovido){
          arquivo.seek(arquivo.getFilePointer() - 4 - 1 - ba.length);//pos atual - sizeof(int) - sizeof(byte)
          arquivo.writeByte('*');
          sucesso = true;
        }
      } 
      else
        arquivo.skipBytes(tam);
    }
    return sucesso;
  }
}
