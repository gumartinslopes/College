public class AVLTree {
  private Node root;
 
  public AVLTree(){
    root = null;
  } 
  
  public boolean search(int key){
    return search(root, key);
  }

  public boolean search(Node n, int key){
    boolean foundKey = false;
    if(n == null)
      foundKey = false;
    else if(n.element == key)
      foundKey = true;
    else if(n.element > key)
      foundKey = search(n.left, key);
    else
      foundKey = search(n.right, key);
    return foundKey;
  }

  public void insert(int el)throws Exception{
    root = insert(root, el);
  }

  public Node insert(Node n, int el)throws Exception{
    if(n == null)
      n = new Node(el);
    else if(el < n.element)
      n.left = insert(n.left, el);
    else if(el > n.element)
      n.right = insert(n.right, el);
    else 
      System.out.println("The element " + el + " already exists inside your tree");
    return balance(n);
  }

  /*
  public Node remove(){
    
  }
  public Node getPredecessor(){

  }
  */
  public Node balance(Node n)throws Exception{
    if(n != null){
      int factor = n.getLevel(n.right) - n.getLevel(n.left);
      if(Math.abs(factor) <= 1)
        n.setLevel();
    
      else if(factor == 2){
        int rightChildFactor = n.getLevel(n.right.right) - n.getLevel(n.right.left);
        if(rightChildFactor == -1)
          n.right = rotateRight(n.right);
        n = rotateLeft(n);
      }
      
      else if(factor == -2){
        int leftChildFactor = n.getLevel(n.left.right) - n.getLevel(n.left.left);
        if(leftChildFactor == 1)
          n.left = rotateLeft(n.left);
        n = rotateRight(n);
      }
      
      else{
        throw new Exception("Error at node (" + n.element + ") with invalid balance factor of (" + factor + ")");
      }
    }
    return n;
  }
  
  private Node rotateRight(Node n){
    System.out.println("\nRight rotation on (" + n.element + ")");
    Node leftChild = n.left;
    Node leftRightChild = leftChild.right;
  
    leftChild.right = n;
    n.left = leftRightChild;
    
    n.setLevel();
    leftChild.setLevel();
    return leftChild;
  }
   
  private Node rotateLeft(Node n){
    System.out.println("\nLeft rotation on (" + n.element + ")");
    Node rightChild = n.right;
    Node rightLeftChild = rightChild.left;

    rightChild.left = n;
    n.right = rightLeftChild;

    n.setLevel();
    rightChild.setLevel();

    return rightChild;
  }
  
  public void displayInOrder(){
    System.out.println("Your tree");
    displayInOrder(root);
    System.out.println("\n");
  }

  private void displayInOrder(Node n){
    if(n != null){
      displayInOrder(n.left);
      System.out.println(n.element);
      displayInOrder(n.right);
    }
  }

  public void displayPostOrder(){
    System.out.println("Your tree:");
    displayPostOrder(root);
    System.out.println("\n");
  }

  private void displayPostOrder(Node n){
    if(n != null){
      displayPostOrder(n.left);
      displayPostOrder(n.right);
      System.out.println(n.element);
    }
  }
  
  public void displayPreOrder(){
    System.out.println("Your tree: ");
    displayPreOrder(root);
    System.out.println("\n");
  }
  
  private void displayPreOrder(Node n){
    if(n != null){
      System.out.println(n.element);
      displayPreOrder(n.left);
      displayPreOrder(n.right);
    }
  }
}
