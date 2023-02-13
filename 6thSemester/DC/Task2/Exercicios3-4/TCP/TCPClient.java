import java.net.*;
import java.util.Scanner;
import java.io.*;
public class TCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
		Socket s = null;
		try{
			int serverPort = 7896;
			String serverIp = "192.168.100.12";
			s = new Socket(serverIp, serverPort); 
			conecta(s, serverPort, serverIp);
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }

	 public static void conecta(Socket s, int serverPort, String serverIp)throws UnknownHostException, EOFException,IOException{
		Scanner sc = new Scanner(System.in);
		DataInputStream in = new DataInputStream( s.getInputStream());
		DataOutputStream out = new DataOutputStream( s.getOutputStream());
		String entrada;
		boolean acabou = false;
		while(!acabou){
			System.out.print("-> ");
			entrada = sc.nextLine();
			acabou = entrada.equals("");
			out.writeUTF(entrada);      	// UTF is a string encoding see Sn. 4.4
			if(!acabou){
				String data = in.readUTF();	    // read a line of data from the stream
				System.out.println("Received: "+ data + "\n"); 
			}
		}
	 }
}