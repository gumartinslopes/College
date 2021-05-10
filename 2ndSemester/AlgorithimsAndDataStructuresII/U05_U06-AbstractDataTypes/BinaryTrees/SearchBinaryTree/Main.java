public class Main{
  public static void main(String[] args){
    BinaryTree t = new BinaryTree();
    try{
      t.insert(7);
      t.insert(8);
      t.insert(3);
      t.insert(5);
      t.displayPre();
      System.out.println(t.search(7));
      System.out.println(t.search(24));
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}
