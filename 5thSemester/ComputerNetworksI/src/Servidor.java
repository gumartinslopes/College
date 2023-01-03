import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Servidor {
	public static void main(String[] args) throws IOException {
		// inicia o servidor
		new Servidor(11111).executa();
	}

	private int porta;
	private int portaUdp = 8100;
	public Map<Integer, ClienteServidor> clientes;
	private int idCliente = 0; 

	public Servidor (int porta) {
		this.porta = porta;
		//this.clientes = new ArrayList<PrintStream>();
		this.clientes = new HashMap<Integer,ClienteServidor>();  
	}
	
	public void executaServidorTcp ()throws IOException{
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Porta 11111 aberta!");

		while (true) {
			// aceita um cliente
			Socket cliente = servidor.accept();
			System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());

			// adiciona saida do cliente lista
			PrintStream ps = new PrintStream(cliente.getOutputStream());			
			ClienteServidor cs = new ClienteServidor();
			cs.setLoginPS(ps);
			this.idCliente++;
			cs.setLoginId(this.idCliente);
			this.clientes.put(this.idCliente, cs);

			// cria tratador de cliente numa nova thread
			TrataCliente tc = new TrataCliente(cliente.getInputStream(), this, cs);
			Thread t = new Thread(tc);
			t.start();
		}
	}
	
	public void executaServidorUdp(){
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		try (DatagramSocket socket = new DatagramSocket(this.portaUdp)) {
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

				System.out.println("Aguardando datagrama do cliente....");
				socket.receive(receivePacket);
				InetAddress ipCliente = receivePacket.getAddress();
				int portaCliente = receivePacket.getPort();
				sendData = Integer.toString(this.idCliente).getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipCliente, portaCliente);
				socket.send(sendPacket);
				System.out.println("Enviado...");
			}
		  } catch (Exception exception) {
			exception.printStackTrace();
		  }
	}

	public void executa() throws IOException {
		new Thread(() -> executaServidorUdp()).start();
        new Thread(() -> {
			try {
				executaServidorTcp();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		
	}

	public void distribuiMensagem(PrintStream cliente, String msg) {
		System.out.println(msg);
		cliente.println(msg);		
	}
}