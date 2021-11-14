package entidades.usuarios;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import estruturas.Registro;

public class Usuario implements Registro{

  protected int idPessoa;
  protected String nome; 
  protected String email;
  protected String senha;
  
  public Usuario(int id, String n, String e, String s) {
    this.idPessoa = id;
    this.nome = n;
    this.email = e;
    this.senha = s;
  }

  public Usuario(String n, String e, String s) {
    this.idPessoa = -1;
    this.nome = n;
    this.email = e;
    this.senha = s;
  }

  public Usuario() {
    this.idPessoa = -1;
    this.nome = "";
    this.email = "";
    this.senha = "";
  }

  //getters e setters
  public int getID() {return idPessoa;}
  public void setID(int id) {this.idPessoa = id;}

  public String getNome() {return nome;}
  public void setNome(String n) {this.nome = n;}

  public String getEmail() {return email;}
  public void setEmail(String e) {this.email = e;}

  public String getSenha() {return this.senha;}
  public void setSenha(String s) {this.senha = s;}
  

  public String toString() {
    return "\nID: " + idPessoa +
    "\nNome: "+ nome + 
    "\nE-mail: "+ email +
    "\nSenha: "+ senha;
  }

  public byte[] toByteArray() throws IOException{
    // escreve para memoria
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.writeInt(idPessoa);
    dos.writeUTF(nome);
    dos.writeUTF(email);
    dos.writeUTF(senha);

    return baos.toByteArray(); // Representacao no vetor de bytes
  }
  
  public void fromByteArray(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);
    idPessoa = dis.readInt();
    nome = dis.readUTF();
    email = dis.readUTF();
    senha = dis.readUTF();
  }
}
