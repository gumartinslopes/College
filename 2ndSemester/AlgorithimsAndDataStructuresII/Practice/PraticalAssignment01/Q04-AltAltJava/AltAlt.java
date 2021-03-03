import java.util.Random;

class AltAlt{
  public static Random gerador = new Random();
  
  //metodo que resolve a questao
  public static String trocaLetras(String entrada){
    String saida = new String();
    
    char sorteado = (char)('a' + Math.abs(gerador.nextInt()) % 26);     //um inteiro eh sorteado e faz-se o parse para char
    char substituto = (char)('a' + Math.abs(gerador.nextInt()) % 26);     
    
    for(int i = 0; i < entrada.length(); i++){
      if(entrada.charAt(i) == sorteado){
        saida += substituto;
      }
      else{ 
        saida += entrada.charAt(i);  
      }
    }

    return saida;
  }
  
  //metodo que determina o fim do programa
  public static boolean checkFim(String entrada){
      return(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
  }
  
  //metodo main
  public static void main(String[] args){
    gerador.setSeed(4);
    String entrada;
    do{ 
      entrada = MyIO.readLine();
      if(checkFim(entrada) == false){
        MyIO.println(trocaLetras(entrada));
      }
    }while(checkFim(entrada) == false);
  }
}
