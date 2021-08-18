import java.io.IOException;

public interface Register{
	public byte[] toByteArray()throws IOException;
	 public void fromByteArray(byte[] ba)throws IOException;
}