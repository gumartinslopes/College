package entidades.usuarios;


import java.io.File;

import estruturas.CRUD;
import estruturas.HashExtensivel;

public class CrudUsuario extends CRUD<Usuario> {

  HashExtensivel<ParEmailID> hashIndireta;

  public CrudUsuario(String nomeArquivo) throws Exception {
    super(nomeArquivo, Usuario.class.getConstructor());

    File pasta = new File("dados");
    if (!pasta.exists()) {
      pasta.mkdir();
    }

    pasta = new File("dados/" + nomeArquivo);
    if (!pasta.exists()) 
      pasta.mkdir();
    
    hashIndireta = new HashExtensivel<>(ParEmailID.class.getConstructor(), 4, "dados/" + nomeArquivo + ".hash_q.db",
        "dados/" + nomeArquivo + ".hash_w.db");

  }

  public int create(Usuario user) throws Exception {
    int idUser = super.create(user);
    hashIndireta.create(new ParEmailID(user.getEmail(), idUser));
    return idUser;
  }

  public Usuario read(int ID) throws Exception {
    return super.read(ID);
  }
  
  public Usuario read(String email) throws Exception{
    ParEmailID par = pesquisaPorEmail(email);
    return (par == null)? null: super.read(par.getID());
  }

  public boolean update(Usuario user) throws Exception {
    boolean userUpdated =  super.update(user);
    boolean hashUpdated = hashIndireta.update(new ParEmailID(user.getEmail(), user.getID()));
    return userUpdated && hashUpdated;
  }

  public boolean delete(Usuario user) throws Exception {
    super.delete(user.getID());
    boolean deleted = hashIndireta.delete(user.getEmail().hashCode());
    return deleted;
  }
  
  public ParEmailID pesquisaPorEmail(String email)throws Exception{
    return hashIndireta.read(new ParEmailID(email, 0).hashCode());//retornar o resultado da pesquisa por email
  }
  public void log(){
    hashIndireta.print();
  } 
}
