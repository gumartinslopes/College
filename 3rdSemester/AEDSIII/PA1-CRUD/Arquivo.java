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

    arquivo.seek(arquivo.length());

    obj.setID(proximoID);
    byte[] ba = obj.toByteArray();
    arquivo.writeByte(' ');//lapide
    arquivo.writeInt(ba.length);//tamanho do registro
    arquivo.write(ba);

    return proximoID;
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

  public void delete(){
    //construir
  }
}
