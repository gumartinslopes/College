public class Node{
  public int element;
  public Node left, right;
  public int level;

  public Node(int element){
    this(element, null, null, 1);
  }

  public Node(int element, Node right, Node left, int level){
    this.element = element;
    this.right = right;
    this.left = left;
    this.level = level;
  } 

  public void setLevel(){
    this.level = 1 + Math.max(getLevel(left), getLevel(right));
  }

  public static int getLevel(Node n){
    return(n == null)? 0 : n.level;
  }
}
