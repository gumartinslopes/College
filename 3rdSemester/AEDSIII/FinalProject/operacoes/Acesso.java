package operacoes;

import java.util.Scanner;
import entidades.usuarios.*;//todos as classes do pacote de usuarios
public class Acesso {
	private static Scanner input = new Scanner(System.in);  
  public static CrudUsuario crudUsuario;
  
  public static boolean acesso()throws Exception{
    int opcao;
    boolean result;
    do{
      opcao = menu();
      switch (opcao){
        case 0:
          result = false;
        break;
        case 1:
          result = login();
        break;
        case 2:
          result = cadastro();
        break;
        case 3:
          result = novaSenha();
        break;
        default:
          result = false;
        break;
      }
    }while(opcao > 0 && result == false);
    return result;
  }

	public static int menu()throws Exception{
    crudUsuario = new CrudUsuario("usuarios");
    int opcao;
    boolean validado = false;
    do {
      System.out.println("\n\n\t*** ACESSO ***");
      System.out.println("1) Login ao sistema");
      System.out.println("2) Novo usuário (primeiro acesso)");
      System.out.println("3) Esqueci minha senha ");
      System.out.println("0) Sair");
      Utils.pulaLinha(2);
      System.out.print("Opcao: ");

      opcao = input.nextInt();
      input.nextLine();// consumimos o resto da linha
      if (opcao>= 0 && opcao <= 3)
        validado = true;
      else
        System.out.println("Valor inválido por favor insira novamente");
    } while (validado == false);
    return opcao;
  }

	public static boolean cadastro()throws Exception{
    Utils.pulaLinha(2);
    System.out.println("**** CADASTRO ****");
    String email, nome, senha;
    boolean cadastroConfimado;
    email = novoEmail();
    nome = Utils.leString("nome","o");
    senha = Utils.leString("senha", "a");
    Utils.pulaLinha(5);

    System.out.println("**** DADOS CADASTRAIS ***");
    System.out.println("-> Nome: " + nome + "\n-> e-mail: " + email + "\n-> senha: " + senha);
    System.out.print("Voce gostaria de confirmar o cadastro? (S/N)");
    cadastroConfimado = Utils.lerConfirmacao();
    Utils.pulaLinha(5);

    if (cadastroConfimado) {
      System.out.println("Cadastro confirmado!");
      crudUsuario.create(new Usuario(nome, email, senha));
      crudUsuario.log();

    } else
      System.out.println("Cadastro cancelado");
    return cadastroConfimado;
  }
  
  public static String novoEmail()throws Exception{
    String email;
    boolean emailValidado = false;
    do{
      email = Utils.leString("email","o");
      emailValidado = (buscaEmail(email) == false);
      if(!emailValidado){
        System.out.println("Email ja existente em nosso banco de dados!");
        System.out.println("Por favor, insira novamente");
        Utils.pulaLinha(5);
      }
    }while(!emailValidado);
    return email;
  }

  public static boolean novaSenha()throws Exception{
    Utils.pulaLinha(2);
    System.out.println("**** TROCA DE SENHA ****");
    String email,senhaNova;
    boolean senhaTrocada = false;
    email = Utils.leString("email", "o");
    if(buscaEmail(email)){
      System.out.println("Um email de redefinicao de senha foi enviado para " + email + " (Nao enviamos de verdade)...");
      senhaNova = Utils.leString("senha","a");
      Usuario atualizado = crudUsuario.read(email);
      atualizado.setSenha(senhaNova);
      crudUsuario.update(atualizado);
      
      System.out.println(crudUsuario.read(atualizado.getEmail()));
      Utils.pulaLinha(2);
      System.out.println("Senha trcada com sucesso");
      Utils.pulaLinha(1);
      senhaTrocada = true;
    
    }
    else{
      Utils.pulaLinha(2);
      System.out.println("e-mail invalido");
    }
    return senhaTrocada;
  }

	public static boolean login()throws Exception{
    Utils.pulaLinha(2);
    System.out.println("**** Login ****");
    boolean logado = false;
    String email, senha;
    email = Utils.leString("email", "o");

    if(!buscaEmail(email)){
      System.out.println("O email " + email + " nao existe em nosso sistema");
      Utils.pulaLinha(2);
    }
    else{
      senha = Utils.leString("senha", "a");
      if(senha.equals(crudUsuario.read(email).getSenha()))
        logado = true;
      else 
        System.out.println("Senha ou o email incorretos");
    }
    return logado;
	}

  public static boolean buscaEmail(String email)throws Exception{
    ParEmailID par =  crudUsuario.pesquisaPorEmail(email);
    return (par != null);
  }
}
