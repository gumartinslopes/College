class Ciframento{

  //chave para criptografia = 3
  public static String criptografa(String entrada, int chave){
    String saida = new String();
    for(int i  = 0; i < entrada.length();i++){
        saida += (char)((int)entrada.charAt(i) + chave);
    }
    return saida;
  }

  //metodo que define o fim do programa
  public static boolean checkFim(String entrada){
    return(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
  }

  //metodo principal
  public static void main(String[] args){
    int chave = 3;
    String entrada;

    do{
      entrada = MyIO.readLine();
      
      if(checkFim(entrada) == false)
        MyIO.println(criptografa(entrada, chave));

    }while(checkFim(entrada) == false);
  }
}
