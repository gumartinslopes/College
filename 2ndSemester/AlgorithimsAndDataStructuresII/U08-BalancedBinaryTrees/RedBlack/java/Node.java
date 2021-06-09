public class Node {
  public boolean color;
  public int element;
  public Node left, right;
  
  public Node(){
    this(-1);
  }
  
  public Node(int element){
    this(element, false, null, null);
  }
  public Node(int element, boolean color){
    this(element, color, null, null);
  }

  public Node(int element, boolean color, Node left, Node right){
    this.color =  color;
    this.element = element;
    this.left = left;
    this.right = right;
  }
}
