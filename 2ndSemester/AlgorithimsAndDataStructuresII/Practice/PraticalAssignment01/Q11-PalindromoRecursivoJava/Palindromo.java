class Palindromo {
  public static boolean checkPalindromoRecursivo(String entrada, int i){
    boolean resultado = true;
    int tamanho = entrada.length();
    
    if(entrada.charAt(i) != entrada.charAt(tamanho - 1- i))
      resultado = false;
    else if(i < tamanho/2)
      resultado = checkPalindromoRecursivo(entrada, i + 1);

    return resultado;
  }
  //metodo base para a recursao
  public static boolean checkPalindromo(String entrada){
    return checkPalindromoRecursivo(entrada, 0);
  }

  public static boolean checkFim(String entrada){
    return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
  }
  //metodo principal
  public static void main(String[] args){
    String entrada;
    do{
      entrada = MyIO.readLine();
      if(checkFim(entrada) == false){
        if(checkPalindromo(entrada)){
          MyIO.println("SIM");
        }
        else{
          MyIO.println("NAO");
        }
      }
    }while(checkFim(entrada) == false);
  } 
}
