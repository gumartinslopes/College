import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    try{
      AVLTree avl = new AVLTree();
      getInsertions(avl);
      avl.displayPreOrder();
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
  
  public static void getInsertions(AVLTree avl)throws Exception{
    String input = new String();
    Scanner sc = new Scanner(System.in);
    boolean continueInsertion;
    do{
      System.out.println("Type a value to insert in the tree.\nIf you want to quit the insertions type END: ");
      input = sc.nextLine();
      continueInsertion = (input.equals("END")) ? false: true;
      if(continueInsertion)
        avl.insert(Integer.parseInt(input));
    } while(continueInsertion);
  }
}
