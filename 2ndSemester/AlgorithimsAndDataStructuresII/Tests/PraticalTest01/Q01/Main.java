/*
 Prova 01 Segundo semestre AedsII
Author: Gustavo Martins Lopes da Costa 
Matricula: 690773
*/

class Main{
  public static void main(String[] args){ 
    int inputQuantity = MyIO.readInt();
    standartInput(inputQuantity);
  } 

  public static void standartInput(int quantity){
    String input;
    for(int i = 0; i < quantity; i++){
      input = MyIO.readLine();
      operate(input);
    }
  }

  public static void operate(String input){
    String[] words = input.split(" ");
    sort(words);
    printArray(words);
  }

  public static void printArray(String[] words){
    for(int i = 0; i < words.length; i++)
      MyIO.print(words[i] + " ");
      MyIO.println("");
  }

  //ordenacao por insercao baseada no tamanho
  public static void sort(String[] words){
    int n = words.length;
    for(int i = 1; i < n; i++){
      int j = i - 1;
      String aux = words[i];
      while((j >= 0) && (words[j].length() < aux.length())){
        words[j + 1] = words[j];
        j--;
      }
      words[j + 1] = aux;
    }
  }
}
