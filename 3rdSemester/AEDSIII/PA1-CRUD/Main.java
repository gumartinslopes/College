import java.io.File;

public class Main {
  public static void main(String[] args) {
    File f = new File("dados/livros/arquivo.db");
    f.delete();

    Arquivo<Livro> arqLivros;

    try {
      arqLivros = new Arquivo<>("livros", Livro.class.getConstructor());

      testCreate(arqLivros);
      testRead(arqLivros);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  public static void testCreate(Arquivo<Livro> arqLivros)throws Exception{
      System.out.println("***** C R E A T E *****");
      //cadastro 
      Livro l1 = new Livro("Eu, Robô", "Isaac Asimov", "9788576572008", 14.90F);
      Livro l2 = new Livro("Eu Sou a Lenda", "Richard Matheson", "9788576572718", 21.99F);
      Livro l3 = new Livro("Duna", "Frank Herbert", "9788576571018", 56.00F);

      System.out.println("Livro com id: " + arqLivros.create(l1) + " criado");
      System.out.println("Livro com id: " + arqLivros.create(l2) + " criado");
      System.out.println("Livro com id: " + arqLivros.create(l3) + " criado");
      System.out.println("\n*********************");
      System.out.println("\n\n");

  }

  public static void testRead(Arquivo<Livro> arqLivros)throws Exception{
      System.out.println("***** R E A D *****");
      // leitura
      Livro readL1 = arqLivros.read(1);
      Livro readL2 = arqLivros.read(2);
      Livro readL3 = arqLivros.read(3);

      System.out.println(readL1);
      System.out.println(readL2);
      System.out.println(readL3);
      System.out.println("\n*********************");
      System.out.println("\n\n");
  }
}