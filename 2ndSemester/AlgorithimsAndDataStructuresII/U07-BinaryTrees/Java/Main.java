import java.util.Random;
public class Main{
  public static Random generator = new Random();
  public static void main(String[] args){
    BinaryTree t = new BinaryTree();
    try{
      insertValues(t, 100000);
      //t.displayInOrder();
      int height = t.getHeight();
      int total = t.getNumberOfNodes();
      System.out.println("\nAltura atual: " + height);
      System.out.println("\nLog na base 2 do total de nodes atual:" + ((int)(Math.log(total) / Math.log(2))));
      System.out.println("\nTotal de nodes: " + total);
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
  
  public static void insertValues(BinaryTree bt, int quant)throws Exception{
    for(int i = 0; i < quant; i++){  
      bt.insert(Math.abs(generator.nextInt())%quant);
    }
  }

  public static boolean equalsTree(BinaryTree a,BinaryTree b){
    return equalsTree(a.root, b.root);
  }

  public static boolean equalsTree(Node na, Node nb){
    boolean result;
    if(na == null && nb == null)
      result = true;
    else if(na != null && nb!= null)
      result = (na.element == nb.element) && equalsTree(na.leftChild, nb.leftChild) && equalsTree(na.rightChild, nb.rightChild);
    else 
      result = false;
    return result;
  }
}
