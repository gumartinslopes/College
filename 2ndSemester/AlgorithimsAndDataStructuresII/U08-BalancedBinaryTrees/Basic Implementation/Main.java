public class Main{
  public static void main(String[] args){
    BinaryTree bt = new BinaryTree();
    bt.insert(1);
    bt.insert(2);
    bt.insert(3);
    bt.displayPreOrder();
    bt.root = bt.rotateLeft(bt.root);
    bt.displayPreOrder();
  }
}
