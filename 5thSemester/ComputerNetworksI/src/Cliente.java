
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

	private String host;
	private String id;
	private String idOponente;
	private String login;
	private int porta;
	private Socket socketCliente;
	
	PrintStream saida;

	private static Cliente cliente;


	public Cliente (String host, int porta, String login) {
		this.host = host;
		this.porta = porta;
		this.login = login;
		cliente = this;
	}

	public void executa() throws UnknownHostException, IOException {
		this.socketCliente = new Socket(this.host, this.porta);
		System.out.println("Conexão com servidor efetuada!");
		InputStream is = this.socketCliente.getInputStream();
		Recebedor rec = new Recebedor(is);
		Thread t = new Thread(rec);
		t.start();
	}
	
	public void enviaDados(String msg) throws IOException {
		// le msgs do teclado e manda pro servidor
		this.saida = new PrintStream(this.socketCliente.getOutputStream());
		this.saida.println(msg);
	}
	
	public void fechaConexao() throws IOException{
		this.saida.close();
		this.socketCliente.close();
	}
	
	// --- getters ---
	public String getId() {	return id; }
	public String getIdOponente() { return idOponente; }
	public String getLogin() { return login; }

	// --- setters ---
	public void setId(String id) {
		this.id = id;
	}

	public void setIdOponente(String idOponente){
		this.idOponente = idOponente;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public static synchronized Cliente getInstance(){
		if (cliente == null) {
			cliente = new Cliente("127.0.0.1", 11111, "Login");
		}
		return cliente;
	}
}
