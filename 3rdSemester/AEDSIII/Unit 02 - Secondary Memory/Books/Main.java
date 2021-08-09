import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class Main{
    public static void main(String[] args){
        Book l1 = new Book(1, "Eu Robô", "Isaac Asimov", 14.9F);
        Book l2 = new Book(2, "Eu sou a lenda", "Richard Matheson", 21.99F);
        
        FileOutputStream arq;
        DataOutputStream dos;
        FileInputStream arq2;
        DataInputStream dis;
        byte[] ba;

        try{
            arq = new FileOutputStream("data/books.db");
            arq2 = new FileInputStream("data/books.db");
            dos = new DataOutputStream(arq);
            dis = new DataInputStream(arq2);
            
            
            //escrita
            ba = l1.toByteArray();
            dos.writeInt(ba.length);//tamanho do array de bytes como metadado
            dos.write(ba);          //escrevenos o array de bytes 
           
            ba = l2.toByteArray();
            dos.writeInt(ba.length);
            dos.write(ba);
            
            //leitura
            Book l3 = new Book();
            Book l4 = new Book(); 
            
            int len = dis.readInt();
            ba = new byte[len];
            dis.read(ba);
            l3.fromByteArray(ba);

            len = dis.readInt();
            ba = new byte[len];
            dis.read(ba);
            l4.fromByteArray(ba);

            System.out.println("Yataaa!");
            System.out.println(l3);
            System.out.println(l4);

            //fechamento do arquivo
            arq.close();
            dos.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        };
        
    }
}