import java.util.Scanner;

import entidades.usuarios.CrudUsuario;
import operacoes.*;//import todas as operações

class Main {
  public static Scanner input;
  public static CrudUsuario crudUsuario;
  public static void main(String[] args) {
    boolean usuarioLogado;
    input = new Scanner(System.in);
    try{
      do{
        usuarioLogado = Acesso.acesso();
        if(usuarioLogado){
          System.out.println("**** O USUARIO ENTROU NO SISTEMA****");
        }
      }while(usuarioLogado);
      System.out.println("Obrigado por usar nosso sistema");
    } catch(Exception ex){
      ex.printStackTrace();
    }
  }
}