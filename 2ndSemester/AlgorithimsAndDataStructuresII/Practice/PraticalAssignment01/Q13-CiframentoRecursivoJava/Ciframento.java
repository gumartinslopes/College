class Ciframento{
  public static String criptografaRecursivo(String entrada, int chave, int i){
    String saida = new String();
    if(i < entrada.length()){
      saida += (char)((int) entrada.charAt(i) + chave);
      saida += criptografaRecursivo(entrada, chave, i+1);
    }
    return saida;
  }
  //metodo base para a recursao 
  public static String criptografa(String entrada, int chave){
    return criptografaRecursivo(entrada, chave, 0);
  }

  public static boolean checkFim(String entrada){
    return(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
  }
  public static void main(String[] args){
      int chave = 3;
      String entrada;
      do{
        entrada = MyIO.readLine();
        if(checkFim(entrada) == false){
          MyIO.println(criptografa(entrada, chave));
        }
      }while(checkFim(entrada) == false);
  }
}
