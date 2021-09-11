import java.util.Scanner;
public class Main {
  public static Scanner console = new Scanner(System.in); 

  public static void main(String[] args) {
    int opcao;
    Arquivo<Livro> arqLivros;
    try {
      arqLivros = new Arquivo<>("livros", Livro.class.getConstructor());
      do{
        opcao = menu();
      
        switch (opcao) {
          case 1: {
            inclusao(arqLivros);
          }
           break;
          case 2: {
            System.out.println("\nBuscar");
            busca(arqLivros);
          }
          break;
          case 3: {
            System.out.println("\nExcluir");
            remocao(arqLivros);
          }
          break;
          case 4: {
            System.out.println("\nAlterar");
            alteracao(arqLivros);
          }
          break;
          case 5: {
            System.out.println("\nInspecionar");
            arqLivros.inspecionar();
          }
          break;
          case 0:
          break;
          default:
            System.out.println("Opção inválida");
        }
      }while(opcao!= 0);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      ex.printStackTrace();
    }
  }
  public static int menu(){
    int opcao;
    System.out.println("\n\n-------------------------------");
    System.out.println("              MENU");
    System.out.println("-------------------------------");
    System.out.println("1 - Inserir");
    System.out.println("2 - Buscar");
    System.out.println("3 - Excluir");
    System.out.println("4 - Alterar");
    System.out.println("5 - Inspecionar IDs");
    System.out.println("0 - Sair");
    System.out.print("\n-> ");
    try {
      opcao = Integer.valueOf(console.nextLine());
    } catch (NumberFormatException e) {
      opcao = -1;
    }
    return opcao;
  }
  public static Livro getLivro()throws Exception{
    String nome, autor, isbn;
    float preco;
    System.out.print("\nInsira o nome do livro: ");
    nome = console.nextLine();
    System.out.print("Insira o nome do autor: ");
    autor = console.nextLine();
    isbn = validaTamanho("Insira codigo isbn:", 13);
    preco = leFloat("Insira o preco do livro: ");
    return new Livro(nome, autor, isbn, preco);
  }
  public static void inclusao(Arquivo<Livro> arqLivros)throws Exception{
    Livro novo;
    System.out.println("\nIncluir");
    novo = getLivro();
    arqLivros.create(novo);
    System.out.println(novo);
  }
  public static void busca(Arquivo<Livro> arqLivros)throws Exception{
    int id = leInt("\nInsira id do livro a ser buscado: ");
    Livro lido = arqLivros.read(id);
    System.out.println(((lido != null)?lido:"\nLivro removido ou não existente"));
  }
  

  public static void remocao(Arquivo<Livro> arqLivros)throws Exception{
    int id = leInt("Insira o id a ser removido: ");
    boolean remocao = (arqLivros.delete(id));
    if(remocao == false)
      System.out.println("Id " + id +  " nao existente ou ja foi removido");
    else
      System.out.println(id + " foi removido " + "com " + "exito");
  }

  public static void alteracao(Arquivo<Livro> arqLivros)throws Exception{
    int id = leInt("\nInsira o id do livro a ser alterado: ");
    Livro l = getLivro();
    l.setID(id);
    if(arqLivros.update(l))
      System.out.println("Alteracao bem sucedida");
    else 
      System.out.println("Falha na alteracao");
  }

  public static int leInt(String mensagem){
    int input = 0;
    boolean inputValido = false;
    System.out.print(mensagem);
    do{
      try {
        input = Integer.valueOf(console.nextLine());
        inputValido = true;
      } catch (NumberFormatException e) {
        System.out.print("\nEntrada invalida! Por favor insira novamente: ");
      }
    }while(!inputValido);
    return input;
  }

  public static float leFloat(String mensagem){
    float input = 0;
    boolean inputValido = false;
    System.out.print(mensagem);
    do{
      try {
        input = Float.valueOf(console.nextLine());
        inputValido = true;
      } catch (NumberFormatException e) {
        System.out.print("\nEntrada invalido! Por favor insira novamente: ");
      }
    }while(!inputValido);
    return input;
  }

  public static String validaTamanho(String mensagem, int len){
    String input;
    boolean inputValido = false;
    System.out.print(mensagem);
    do{
      input = console.nextLine();
      if(input.length() == len)
        inputValido = true;
      else      
        System.out.print("\nEntrada invalida! Por favor insira novamente(com tamanho " +len+ "): ");
    }while(!inputValido);
    return input;
  }
}
