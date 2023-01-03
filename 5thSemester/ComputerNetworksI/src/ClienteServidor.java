import java.io.PrintStream;

public class ClienteServidor {
	String login;
	int loginId;
	PrintStream loginPS;
	String oponente;
	int oponenteId;
	PrintStream oponentePS;
	int ativo;		
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public PrintStream getLoginPS() {
		return loginPS;
	}

	public void setLoginPS(PrintStream loginPS) {
		this.loginPS = loginPS;
	}

	public String getOponente() {
		return oponente;
	}

	public void setOponente(String oponente) {
		this.oponente = oponente;
	}

	public int getOponenteId() {
		return oponenteId;
	}

	public void setOponenteId(int oponenteId) {
		this.oponenteId = oponenteId;
	}

	public PrintStream getOponentePS() {
		return oponentePS;
	}

	public void setOponentePS(PrintStream oponentePS) {
		this.oponentePS = oponentePS;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}	
}
