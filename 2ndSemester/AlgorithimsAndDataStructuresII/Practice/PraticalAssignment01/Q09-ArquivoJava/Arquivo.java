import java.io.*;
class Arquivo{
  
   /*
    tamanho Double = 8
   */

   //metodo principal 
  public static void main(String[] args){
    int quantidade = MyIO.readInt();
    String filePath = "arquivo.txt";

    escreveDouble(quantidade, filePath);
    leDeTrasPraFrente(quantidade, filePath);
  }

  //metodo que escreve no arquivo
  public static void escreveDouble(int quantidade, String filePath){
    try
    {
      RandomAccessFile raff = new RandomAccessFile(filePath, "rw");
      
      //armazenamento de todos os valores da questao
      for(int i = 0; i < quantidade; i++){
       double valor = MyIO.readDouble();
        raff.writeDouble(valor);
      }
      raff.close();
    }
    catch(Exception ex){
      MyIO.println("Erro de "  + ex.getMessage());
    }
  }
  
  //metodo que usa o seek do cabecote para acertar posicoes
  public static void leDeTrasPraFrente(int quantidade, String filePath){
     try
    {

      RandomAccessFile raff = new RandomAccessFile(filePath, "r");
      int pos = quantidade * 8;
      while(pos > 0){
        pos -= 8;
        raff.seek(pos);
        MyIO.println(raff.readDouble());
      }
      raff.close();
    }
    catch(Exception ex){
      MyIO.println("Erro de " + ex.getMessage());
    }
  }

 
}
