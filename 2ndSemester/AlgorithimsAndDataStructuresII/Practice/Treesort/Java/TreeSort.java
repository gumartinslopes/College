public class TreeSort{
  private Node root;
  private int rearrangePos;

  public TreeSort(){
    root = null;
    rearrangePos = 0;
  };
  
  public TreeSort(int []array){
    sort(array);
  }

  public void sort(int []array){
    for(int i = 0; i < array.length; i++)
      insert(array[i]);
    rearrange(array);
  }

  //insertion on the binary tree 
  public void insert(int x){
    root = insert(x, root);
  }

  public Node insert(int x, Node n){
    if(n == null)
      n = new Node(x);
    else if(x < n.element)
      n.left = insert(x, n.left);
    else 
      n.right = insert(x, n.right);
    return n;
  }

  //return of the sorted values
  public void rearrange(int []array){
    rearrange(array, root);
  }

  public void rearrange(int []array, Node n){
    if(n != null){
      rearrange(array, n.left);
      array[rearrangePos++] = n.element;
      rearrange(array, n.right);
    }
  }
}
