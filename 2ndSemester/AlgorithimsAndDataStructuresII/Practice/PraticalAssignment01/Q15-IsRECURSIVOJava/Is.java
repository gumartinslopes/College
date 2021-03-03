class Is{
  //metodos auxiliares que evitam repeticao de codigo
  public static String getResposta(boolean entrada){
    String resp;
    if(entrada)
      resp = "SIM";
    else 
      resp = "NAO";
    return resp;
  }
  
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

  public static boolean isConsoante(char entrada){
    boolean resp = false;
      if(isVogal(entrada) == false && (entrada > 65 && entrada <= 90 || entrada > 97 && entrada <= 122)){
        resp = true;
      }
      return resp;
  }

  public static boolean isNumero(char entrada){
    boolean resp = false;
    if ((entrada >= 48 && entrada <= 57)){
      resp = true;
    }
    return resp;
  }

  //quatro metodos da questao
  public static boolean checkApenasVogal(String entrada){
    boolean resp = true;
    for(int i = 0; i < entrada.length(); i++){
      if(isVogal(entrada.charAt(i)) == false && entrada.charAt(i) !=' '){
        resp = false;
        i = entrada.length();
      }
    }  
    return resp;
  }

  public static boolean checkApenasConsoante(String entrada){
    boolean resp = true;
    for(int i = 0; i < entrada.length(); i++){
      if(isConsoante(entrada.charAt(i)) == false && entrada.charAt(i) != ' '){
        resp = false;
        i = entrada.length();
      }
    }
    return resp;
  }
  
  public static boolean checkInteiro(String entrada){
    boolean resp = true;
    for(int i = 0; i < entrada.length(); i++){                 //checagem de algarismo ou sinal de -
      if(!isNumero(entrada.charAt(i)) && entrada.charAt(0) != '-'){
        resp = false;
        i = entrada.length();
      }
    }
    return resp;
  }
 
  public static boolean checkReal(String entrada){
    boolean resp = true;
    int contadorVirgula = 0, contadorPonto = 0;

    if(checkInteiro(entrada) == false){
      for(int i = 0; i < entrada.length();i++){               //checagem de algarismo ou sinais - ou .
        if(!(isNumero(entrada.charAt(i))) && (entrada.charAt(i) != '.') && (entrada.charAt(i) != ',')){
          resp = false;
          i = entrada.length();
        }
        else if(entrada.charAt(i) ==','){
           if(contadorVirgula > 0){ 
             resp = false;
             i = entrada.length();
           }
           else {
            contadorVirgula++;
           }
        }
        else if(entrada.charAt(i) == '.'){
          if(contadorPonto > 0){
            resp = false;
            i = entrada.length();
          }
          else {
            contadorPonto++;
          }
        }
      }
    }
    return resp;   
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
          boolean apenasVogais = checkApenasVogal(entrada),
                  apenasConsoantes = checkApenasConsoante(entrada),
                  valorInteiro = checkInteiro(entrada),
                  valorReal = checkReal(entrada);

          MyIO.println(getResposta(apenasVogais) + " " + getResposta(apenasConsoantes) + " " + getResposta(valorInteiro) + " " + getResposta(valorReal));
      }
    }while(checkFim(entrada) == false);
  } 
}
