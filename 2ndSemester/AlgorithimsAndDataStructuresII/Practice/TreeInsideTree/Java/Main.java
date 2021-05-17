/*
  Author: Gustavo Martins Lopes da Costa
  14/05/2021
  Version: 1.0.0
*/

public class Main{
  public static void main(String[] args){
    try{ 
      ExternalBinaryTree ebt = new ExternalBinaryTree();
      insertWords(ebt);
      ebt.removeWord("Belo Horizonte");
      ebt.display();
      System.out.println(ebt.searchLength(5));
    } catch(Exception ex){
        ex.printStackTrace();
    }
  }

  public static void insertWords(ExternalBinaryTree ebt)throws Exception{
     ebt.insertWord("Jones");
     ebt.insertWord("Logic");
     ebt.insertWord("America");
     ebt.insertWord("Malala");
     ebt.insertWord("Brasil");
     ebt.insertWord("Belo Horizonte");
     ebt.insertWord("Greg");
     ebt.insertWord("Pablito");
     ebt.insertWord("Alvin");
     ebt.insertWord("Carl Jhonson");
     ebt.insertWord("Jebediah Kermani");
     ebt.insertWord("Lito do aviões e músicas");
     ebt.insertWord("Lil  zé");
     ebt.insertWord("Mr Bruh");
     ebt.insertWord("Sylvester StillAlone");
     ebt.insertWord("Not This Guy");
     ebt.insertWord("Barry Brunno");
     ebt.insertWord("Kodak");
     ebt.insertWord("So far away");
     ebt.insertWord("Dire Straits");
     ebt.insertWord("Terry Jeffords");
     ebt.insertWord("Ronald Drump");
     ebt.insertWord("Invitation");
  }
}
