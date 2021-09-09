import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Livro implements Registro {
  protected int idLivro;
  protected String titulo;
  protected String autor;
  protected String isbn;
  protected float preco;

  public Livro(String titulo, String autor, String isbn, float preco) throws Exception {
    this.idLivro = -1;
    this.titulo = titulo;
    this.autor = autor;
    if (isbn.getBytes().length != 13)
      throw new Exception("Tamanho do ISBN inválido!");
    this.isbn = isbn;
    this.preco = preco;
  }

  public Livro() {
    this.idLivro = -1;
    this.titulo = "";
    this.autor = "";
    this.isbn = "";
    this.preco = 0F;
  }

  public void setID(int id) {
    this.idLivro = id;
  }

  public int getID() {
    return this.idLivro;
  }

  public String toString() {
    DecimalFormat df = new DecimalFormat("#,##0.00");
    return "\nID....: " + this.idLivro + 
           "\nTítulo: " + this.titulo + 
           "\nAutor.: " + this.autor + 
           "\nISBN..: " + this.isbn + 
           "\nPreço.: R$ " + df.format(this.preco);
  }

  public byte[] toByteArray() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    
    dos.writeInt(this.idLivro);
    dos.writeUTF(this.titulo);
    dos.writeUTF(this.autor);
    dos.write(this.isbn.getBytes());
    dos.writeFloat(this.preco);
    
    return baos.toByteArray();
  }

  public void fromByteArray(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);
    byte[] isbnAux = new byte[13];//13 => tamanho máximo do isbn
    this.idLivro = dis.readInt();
    this.titulo = dis.readUTF();
    this.autor = dis.readUTF();
    dis.read(isbnAux);
    this.isbn = new String(isbnAux);
    this.preco = dis.readFloat();
  }
}