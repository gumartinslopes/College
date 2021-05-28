public class Main{
  public static void main(String[] args){
    BinaryTree bt = new BinaryTree();
    bt.insert(78);
    bt.insert(12);
    bt.insert(696);
    bt.displayPreOrder();
    bt.balance();
    bt.displayPreOrder();
  }
}
