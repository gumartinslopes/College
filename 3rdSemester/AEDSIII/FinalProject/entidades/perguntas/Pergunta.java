package entidades.perguntas;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Pergunta {
    protected int idPergunta;
    protected int idUsuario;
    protected long criacao;
    protected short nota;
    protected String pergunta;
    protected String palavrasChave;
    protected boolean ativa;

    public Pergunta(int idp, int idu, String p, String pc, long c, short n, boolean f) {
        this.idPergunta = idp;
        this.idUsuario = idu;
        this.criacao = c;
        this.nota = n;
        this.pergunta = p;
        this.palavrasChave = pc;
        this.ativa = f;
    }

    public Pergunta(String p, String pc, long c, short n, boolean f) {
        this.idPergunta = -1;
        this.idUsuario = -1;
        this.criacao = c;
        this.nota = n;
        this.pergunta = p;
        this.palavrasChave = pc;
        this.ativa = f;
    }

    public Pergunta(){
        this.idPergunta = -1;
        this.idUsuario = -1;
        this.criacao = -1;
        this.nota = -1;
        this.pergunta = "";
        this.palavrasChave = "";
        this.ativa = false;
    }

    public int getIDPergunta(){
        return idPergunta;
    }
    public void setIDPergunta(int idp){
        this.idPergunta = idp;
    }

    public int getIDUsuario(){
        return idUsuario;
    }
    public void setIDUsuario(int idu){
        this.idUsuario = idu;
    }

    public long getCriacao(){
        return criacao;
    }
    public void setCriacao(long c){
        this.criacao = c;
    }

    public boolean getAtiva(){
        return ativa;
    }
    public void setAtiva(boolean f){
        this.ativa = f;
    }

    public String getPergunta(){
        return pergunta;
    }
    public void setPergunta(String p){
        this.pergunta = p;
    }

    public String getPalavrasChave(){
        return palavrasChave;
    }
    public void setPalavrasChave(String pc){
        this.palavrasChave = pc;
    }
  
    public byte[] toByteArray() throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(this.idPergunta);
        dos.writeInt(this.idUsuario);
        dos.writeLong(this.criacao);
        dos.writeShort(this.nota);
        dos.writeUTF(this.pergunta);
        dos.writeUTF(this.palavrasChave);
        dos.writeBoolean(this.ativa);

        return baos.toByteArray();
    }

    public void fromByteArray(byte[] ba) throws Exception{
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
      
        idPergunta = dis.readInt();
        idUsuario = dis.readInt();
        criacao = dis.readLong();
        nota = dis.readShort();
        pergunta  = dis.readUTF();
        palavrasChave   = dis.readUTF();
        ativa = dis.readBoolean();

    }
}