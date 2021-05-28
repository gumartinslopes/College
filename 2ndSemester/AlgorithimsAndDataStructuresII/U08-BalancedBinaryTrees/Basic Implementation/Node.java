public class Node{
  public int element;
  public Node left, right;

  public Node(){
    this(-1);
  }

  public Node(int el){
    this.element = el;
    this.left = this.right = null;
  }
}
