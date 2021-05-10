public class Main{
  public static void main(String[] args){
    BinaryTree t = new BinaryTree();
    BinaryTree t2 = new BinaryTree();

    try{
      t.insert(5);
      t.insert(4);

      t.insert(11);
      t.displayPre();
      System.out.println("\n");
      t2.displayPre();
     /* 
      System.out.println(t.search(7));
      System.out.println(t.search(24));
      System.out.println("Sum -> "+ t.getSum());
      System.out.println("Number of even values in your tree -> " + t.countEven());
      System.out.println("Total number of odd values int your tree ->" + t.countOdds());
      */
      System.out.println(equalsTree(t, t2));
      System.out.println(t.hasDivisible(11));
      t.insert(11155);
      System.out.println(t.getBiggest());
      System.out.println(t.getSmallest());
      t.displayCentral();
      t.remove(11);
      t.remove(4);
      t.displayCentral();
    }catch(Exception ex){
      ex.printStackTrace();
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
