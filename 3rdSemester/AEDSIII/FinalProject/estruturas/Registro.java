package estruturas;
import java.io.IOException;


public interface Registro {
  public String getNome();
  public String getEmail();
  public void setEmail(String mail);
  public void setID(int n);
  public int getID();
  public byte[] toByteArray() throws IOException;
  public void fromByteArray(byte[] ba) throws IOException;
}