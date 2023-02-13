package UDP;
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class UDPClient{
	public static String ip = "192.168.100.12";
    public static void main(String args[]) { 
		// args give message contents and destination hostname
		DatagramSocket aSocket = null;
		try {
			Scanner entrada = new Scanner(System.in);
			String mensagem;
			boolean acabou = false;
			do{
				//le a mensagem do usuario
				mensagem = entrada.nextLine();
				//envia a mensagem para o servidor
				acabou = mensagem.equals("");
				if(!acabou)
					enviaMensagemUdp(mensagem, aSocket);
			}while(!acabou);
			entrada.close();
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	

	public static void enviaMensagemUdp(String mensagem, DatagramSocket aSocket)throws IOException, SocketException{
		aSocket = new DatagramSocket();    
		byte [] m = mensagem.getBytes();
		InetAddress aHost = InetAddress.getByName(ip);
		int serverPort = 6789;		                                                 
		DatagramPacket request =
		new DatagramPacket(m,  mensagem.length(), aHost, serverPort);
		aSocket.send(request);			                        
		byte[] buffer = new byte[1000];
		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
		int limitTime = 500;
		aSocket.setSoTimeout(limitTime);
		aSocket.receive(reply);
		
		System.out.println("  - Reply: " + new String(reply.getData()).toUpperCase());
		aSocket.close();	
	}
}