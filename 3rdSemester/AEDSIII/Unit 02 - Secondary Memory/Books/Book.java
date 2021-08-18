import java.text.DecimalFormat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Book implements Register{
    protected int idBook;
    protected String title;
    protected String author;
    protected float price;
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    public Book(int idBook, String title, String author, float price){
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(){
        this.idBook = -1;
        this.title = "";
        this.author = "";
        this.price = 0;
    }

    public String toString(){
        return "\nId: " + this.idBook + 
                "\nTitle: " + this.title + 
                "\nPrice: " + df.format(this.price) + 
                "\nAuthor: " + this.author;
    }

    public byte[] toByteArray()throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(idBook);
        dos.writeUTF(title);
        dos.writeUTF(author);
        dos.writeFloat(price);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] ba)throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        idBook = dis.readInt();
        title = dis.readUTF(); 
        author = dis.readUTF();
        price = dis.readFloat();
    }
}