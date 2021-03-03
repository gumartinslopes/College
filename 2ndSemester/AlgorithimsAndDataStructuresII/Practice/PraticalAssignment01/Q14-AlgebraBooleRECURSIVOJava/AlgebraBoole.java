class AlgebraBoole{
 public static int[] operandos = new int[3];
 public static int posicaoInterpretador;

  public static String retiraEspacos(String entrada){
    String saida = new String();
    for(int  i = 0; i < entrada.length(); i++){
      if(entrada.charAt(i) != ' ')
        saida += entrada.charAt(i);
    }
    return saida;
  }
  
  public static String retornaIntervalo(String entrada, int inicio, int fim){
    String saida = new String();
    for(int i = inicio; i < fim; i++)
      saida += entrada.charAt(i);
    return saida;
  }

  public static int transformAlgarismo(char c){
    int saida = 0;
    for(int i = 48; i < 58; i++){
      if(c != i)
        saida++;
      else
        i = 59;
    }
    return saida;
  }

  public static boolean transformBooleano(int valor){
    boolean resp;
    if(valor == 1)
      resp = true;
    else 
      resp = false;
    return resp;
  }

  public static boolean resolveExpressao(String expressao){
    boolean resultado = false, aux;
    if(expressao.charAt(posicaoInterpretador) == 'A')
      resultado = transformBooleano(operandos[0]);
    
    else if(expressao.charAt(posicaoInterpretador) == 'B')
      resultado = transformBooleano(operandos[1]);

    else if(expressao.charAt(posicaoInterpretador) == 'C')
      resultado = transformBooleano(operandos[2]);
    
    else if(expressao.charAt(posicaoInterpretador) == 'n'){ //
      posicaoInterpretador += 4;
      resultado = !(resolveExpressao(expressao));
      posicaoInterpretador++;
    }
    else if(expressao.charAt(posicaoInterpretador) == 'a'){//and
      posicaoInterpretador += 4;
      resultado = resolveExpressao(expressao);
      posicaoInterpretador += 1;
      while(expressao.charAt(posicaoInterpretador) == ','){
        posicaoInterpretador++;
        aux = resolveExpressao(expressao);
        resultado = resultado && aux;
        posicaoInterpretador++;
      }
    }
    else if(expressao.charAt(posicaoInterpretador) == 'o'){ //or
      posicaoInterpretador += 3;
  
      resultado = resolveExpressao(expressao);
      posicaoInterpretador++;
      while(expressao.charAt(posicaoInterpretador) == ','){
        posicaoInterpretador++;
        aux = resolveExpressao(expressao);
        resultado = resultado || aux;
        posicaoInterpretador++;
      }
    }
    return resultado;
  }

  
  public static int leValores(String entrada){
     int quantVariaveis = transformAlgarismo(entrada.charAt(0));
      for(int i = 1; i <= quantVariaveis;i++)
        operandos[i -1] = transformAlgarismo(entrada.charAt(i));
    return quantVariaveis;
  }

  public static void mostraResultado(boolean resultado){
    if(resultado == true)
      MyIO.println(1);
    else
      MyIO.println(0);
  }

  public static void main(String[] args){
    String entrada;
    int quantVariaveis = 0;

    do{
      entrada = retiraEspacos(MyIO.readLine());
      quantVariaveis = leValores(entrada);
      if(quantVariaveis != 0){
        entrada = retornaIntervalo(entrada, quantVariaveis + 1, entrada.length());
        posicaoInterpretador = 0;
        mostraResultado(resolveExpressao(entrada));
      }
    }while(quantVariaveis != 0);
  }
}
