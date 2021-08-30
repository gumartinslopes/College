import java.io.File;

public class Main {
  public static void main(String[] args) {
    File f = new File("dados/livros/arquivo.db");
    f.delete();
    Arquivo<Livro> arqLivros;
    try {
      arqLivros = new Arquivo<>("livros", Livro.class.getConstructor());

      testCreate(arqLivros);
      //testUpdate(arqLivros); //descomente para testar
      testDelete(arqLivros);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  public static void testCreate(Arquivo<Livro> arqLivros)throws Exception{
      System.out.println("-- C R E A T E --");

      Livro l1 = new Livro("Eu, Robô", "Isaac Asimov", "9788576572008", 14.90F);
      Livro l2 = new Livro("Eu Sou a Lenda", "Richard Matheson", "9788576572718", 21.99F);
      Livro l3 = new Livro("Duna", "Frank Herbert", "9788576571018", 56.00F);

      System.out.println("Livro com id: " + arqLivros.create(l1) + " criado");
      System.out.println("Livro com id: " + arqLivros.create(l2) + " criado");
      System.out.println("Livro com id: " + arqLivros.create(l3) + " criado");
      System.out.println("\n");

  }

  public static void testRead(Arquivo<Livro> arqLivros)throws Exception{
      System.out.println("-- R E A D --");

      Livro []livrosLidos = new Livro[3];
      livrosLidos[0] = arqLivros.read(1);
      livrosLidos[1] = arqLivros.read(2);
      livrosLidos[2] = arqLivros.read(3);
      for(Livro livro : livrosLidos)
        System.out.println(((livro != null)?livro:"\nLivro removido ou não existente"));
      System.out.println("\n");
  }

  public static void testUpdate(Arquivo<Livro> arqLivros)throws Exception{
    System.out.println("-- U P D A T E --");
    System.out.println("Antes da operação");
    testRead(arqLivros);
    
    
    Livro l3Update = new Livro("Duna", "Frank Herbert", "9788576571018", 20.00F);
    l3Update.setID(3);
    boolean atualizacao = arqLivros.update(l3Update);

    if(atualizacao == false)
        throw new Exception("Id " + l3Update.getID() +  " nao existente");
      System.out.println("Id " + l3Update.getID() + " foi atualizado " + "com " + "exito\n");
    
    System.out.println("Após a operação");
    testRead(arqLivros);
  }

  public static void testDelete(Arquivo<Livro> arqLivros)throws Exception{
    System.out.println("-- D E L E T E --");
      System.out.println("Antes da operação");
      testRead(arqLivros);
      
      int removido = 2;
      boolean remocao = (arqLivros.delete(removido));
      if(remocao == false)
        throw new Exception("Id " + removido +  " nao existente ou ja foi removido");
      System.out.println(removido + " foi removido " + "com " + "exito\n");
      
      System.out.println("Após a operação");
      testRead(arqLivros);
  }
}