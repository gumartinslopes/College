package UDP;
import java.net.*;
import java.io.*;
public class UDPServer{
    public static void main(String args[]) throws InterruptedException{ 
    	DatagramSocket aSocket = null;
		try{
			int port = 6789;
	    	aSocket = new DatagramSocket(port);
					// create socket at agreed port
			byte[] buffer = new byte[1000];
			System.out.println("Servidor executando na porta: " + port);
 			while(true){
 				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);   

    			DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), 
    				request.getAddress(), request.getPort());
					Thread.sleep(1000);
    			aSocket.send(reply);
    		}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
    }
}