import java.io.RandomAccessFile;
/*
    implementação da main porém utilizando a classe randomAccessFile
*/ 
public class MainRAF{
    public static void main(String[] args){
        Book l1 = new Book(1, "Duna", "Frank Herbert", 44.9F);
        Book l2 = new Book(2, "Eu sou a lenda", "Richard Matheson", 21.99F);
        
        RandomAccessFile arq;
        
        byte[] ba;

        try{
            arq = new RandomAccessFile("data/books.db", "rw");
            long p1 = arq.getFilePointer();//ponteiros devem ser long

            //escrita
            ba = l1.toByteArray();
            arq.writeInt(ba.length);//tamanho do array de bytes como metadado
            arq.write(ba);          //escrevenos o array de bytes 
           long p2 = arq.getFilePointer();
            ba = l2.toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);
            
            
            //leitura
            Book l3 = new Book();
            Book l4 = new Book(); 
            
            arq.seek(p1);//retornamos o ponteiro para o inicio do arquivo
            int len = arq.readInt();
            ba = new byte[len];
            arq.read(ba);
            l3.fromByteArray(ba);

            arq.seek(p2);
            len = arq.readInt();
            ba = new byte[len];
            arq.read(ba);
            l4.fromByteArray(ba);

            System.out.println("Woohoo!");
            System.out.println(l3);
            System.out.println(l4);

            arq.close();//fechamento do arquivo
        }catch(Exception ex){
            System.out.println(ex.getMessage() + "\n");
            ex.printStackTrace();
        };
        
    }
}