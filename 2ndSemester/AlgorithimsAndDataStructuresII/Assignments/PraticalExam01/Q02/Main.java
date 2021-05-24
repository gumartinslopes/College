/*
  Prova Pratica 01
  Author: Gustavo Martins Lopes da Costa
  Questao 02 Justificador em java
*/

class Main{
  public static void main(String[] args){
    int quantity = MyIO.readInt();
     while(quantity > 0){
      standartInput(quantity);
      quantity = MyIO.readInt();
    }
  }
  
  public static void standartInput(int quantity){
    String[] inputs = new String[quantity];
    for(int i = 0; i < quantity; i++){
      inputs[i] = MyIO.readLine();
    }
    operate(inputs);
  }
  
  public static void operate(String[] words){
    justifyToRight(words);
    printArray(words);
  }
  
  public static void justifyToRight(String[] words){
   removeLeftSpaces(words);
   
   int longestLength = getLongestLength(words);
   for(int i = 0; i < words.length; i++){
    String aux = new String();
    int j = 0;
    int k = 0;
    while(j < (longestLength - words[i].length())){     
      aux += ' ';
      j++;
    }

    while(k < words[i].length()){
      aux += words[i].charAt(k);
      k++;
    }
    words[i] = aux;
   }
  }
  
  public static int getLongestLength(String[] words){
    int longest = 0;
    for(int i = 0; i < words.length; i++){
      if(words[i].length() > longest)
        longest = words[i].length();
    }
    return longest;
  } 
  
  public static void removeLeftSpaces(String[] words){
    for(int i = 0; i < words.length; i++){
      int j = 0;
      String aux = new String();
      
      while(j < words[i].length() - 1){
        if(!(words[i].charAt(j) == ' ' && words[i].charAt(j + 1) == ' '))
          aux += words[i].charAt(j);
        j++;
      }
      aux += words[i].charAt(j);  //pegamos o ultimo valori nao contabilizado pelo while
      words[i] = aux;
    }
  }

  public static void printArray(String[] words){
    for(int i = 0; i < words.length; i++)
      MyIO.println(words[i]);
    
    MyIO.println("");
  }
}
