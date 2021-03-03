class IsRecursivo{
  //metodos auxiliares que evitam repeticao de codigo
  public static String getResposta(boolean entrada){
    String resp;
    if(entrada)
      resp = "SIM";
    else 
      resp = "NAO";
    return resp;
  }
  
  //metodo da checagem de vogal
  public static boolean isVogal(char entrada){
      boolean resp = false;
      char []vogais = {'a','e','i','o','u'};

      for(int i = 0; i < vogais.length; i++){
        if(entrada == vogais[i]){
          resp = true;
          i = vogais.length;
        } 
      }
      return resp;
  }
  
  //metodo auxiliar para a checagem de consoantes
  public static boolean isConsoante(char entrada){
    boolean resp = false;
      if(isVogal(entrada) == false && (entrada > 65 && entrada <= 90 || entrada > 97 && entrada <= 122)){
        resp = true;
      }
      return resp;
  }
  
  //metodo que checa a presenca exclusiva de algarismos
  public static boolean isNumero(char entrada){
    boolean resp = false;
    if ((entrada >= 48 && entrada <= 57)){
      resp = true;
    }
    return resp;
  }

  //quatro metodos da questao 
  //metodo base para checar o primeiro topico
  public static boolean checkApenasVogal(String entrada){
    return checkApenasVogalRecursiva(entrada, 0);
  } 

  public static boolean checkApenasVogalRecursiva(String entrada, int i){
    boolean resp = true;
    if(isVogal(entrada.charAt(i)) == false && entrada.charAt(i) != ' '){ //caso base
      resp = false;
    }
    else if(i < entrada.length() - 1){
      resp = checkApenasVogalRecursiva(entrada,i + 1);  //caso recursivo
    }
    return resp;
  }
  
  //metodo base para a checagem do segundo item
  public static boolean checkApenasConsoante(String entrada){
    return checkApenasConsoanteRecursivo(entrada,0);
  }
  
  public static boolean checkApenasConsoanteRecursivo(String entrada,int i){
    boolean resp = true;
    if(isConsoante(entrada.charAt(i)) == false && entrada.charAt(i) != ' '){//caso recursivo
      resp = false;
    }
    else if(i < entrada.length() - 1){//caso base
      resp = checkApenasConsoanteRecursivo(entrada, i + 1);
    }
    return resp;
  }
  
  public static boolean checkInteiro(String entrada){
    return checkInteiroRecursivo(entrada, 0);
  }

  public static boolean checkInteiroRecursivo(String entrada, int i){
    boolean resp = true;
    if(!isNumero(entrada.charAt(i)) && entrada.charAt(0) != '-'){
      resp = false;
    }
    else if(i < entrada.length() - 1){
      resp = checkInteiroRecursivo(entrada, i + 1);
    }
    return resp;
  }

  //metodo base para a recursividade
  public static boolean checkReal(String entrada){
    return checkRealRecursivo(entrada, 0, 0, 0);
  }

  //metodo que faz a ultima checagem recursivamente 
  public static boolean checkRealRecursivo(String entrada, int i, int contadorVirgula,int contadorPonto){
    boolean resp = true;
    if(checkInteiro(entrada) == false){
      if(!(isNumero(entrada.charAt(i))) && (entrada.charAt(i) != '.') && (entrada.charAt(i) != ',')){
        resp = false;
      }
      else if(entrada.charAt(i) ==',' && contadorVirgula > 0){
        resp = false;
      }
      else if(entrada.charAt(i) == '.' && contadorPonto > 0){
          resp = false;
      }
      else if(i < entrada.length() - 1){
        if(entrada.charAt(i) == ',')
          resp = checkRealRecursivo(entrada, i + 1,contadorVirgula + 1, contadorPonto);
        else if(entrada.charAt(i) == '.')
          resp = checkRealRecursivo(entrada, i + 1, contadorVirgula, contadorPonto + 1);
        else
          resp = checkRealRecursivo(entrada, i + 1, contadorVirgula, contadorPonto);
      } 
    }
    return resp;
  }

  //metodo que checa o fim do programa baseando se na string 
  public static boolean checkFim(String entrada){
    return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
  }
  
  //metodo principal
  public static void main(String[] args){
    String entrada;
    do{
      entrada = MyIO.readLine();
      if(checkFim(entrada) == false){
          boolean apenasVogais = checkApenasVogal(entrada),
                  apenasConsoantes = checkApenasConsoante(entrada),
                  valorInteiro = checkInteiro(entrada),
                  valorReal = checkReal(entrada);

          MyIO.println(getResposta(apenasVogais) + " " + getResposta(apenasConsoantes) + " " + getResposta(valorInteiro) + " " + getResposta(valorReal));
      }
    }while(checkFim(entrada) == false);
  } 
}
