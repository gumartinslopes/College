public class Node{
  public Node leftChild, rightChild;
  public int element;

  public Node(int x){
    this(x, null, null);
  }

  public Node(int element, Node rightChild, Node leftChild){
    this.element = element;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
}
