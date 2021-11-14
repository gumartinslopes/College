package operacoes;
import java.util.Scanner;
public class Utils {
    private static Scanner input = new Scanner(System.in);  

    public static void pulaLinha(int linhas){
        for(int i = 0; i < linhas; i++)
          System.out.println();
    }

    /* --- Métodos de leitura --- */

    public static boolean lerConfirmacao() {
        char entrada;
        boolean confirmacao = false;
        boolean validacao = false;
        do {
          entrada = input.next().charAt(0);
          if (Character.toLowerCase(entrada) == 's' || Character.toLowerCase(entrada) == 'n') {
            validacao = true;
            if (entrada == 'S' || entrada == 's')
              confirmacao = true;
          } else
            System.out.print("entrada invalida, por favor confirme novamente: ");
        } while (validacao != true);
        return confirmacao;
      }

      public static String leString(String palavra, String artigo){
        String leitura;
        do{
            System.out.print("Insira "+ artigo + " " + palavra + ": ");
            leitura = input.nextLine();
            if(leitura.isEmpty())
                System.out.println("Entrada invalida, por favor insira novamente!");
        }while(leitura.isEmpty());
        return leitura;
    }
}
