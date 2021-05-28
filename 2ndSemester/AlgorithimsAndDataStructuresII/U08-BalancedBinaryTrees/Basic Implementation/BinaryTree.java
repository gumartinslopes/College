public class BinaryTree{
  public Node root;
  public BinaryTree(){
    this.root = null;
  }
  
  public void insert(int el){
    root = insert(root, el);
  }

  private Node insert(Node n, int el){
    if(n == null)
      n = new Node(el);
    else if(el < n.element)
      n.left = insert(n.left, el);
    else if(el > n.element)
      n.right = insert(n.right, el);
    else
      System.out.println("The element " + el + " already exists inside your tree");
    return n;
  }

  public boolean search(int key){
    return search(root, key);
  }
  
  private boolean search(Node n, int key){
    boolean foundKey;
    if(n == null)
      foundKey = false;
    else if(n.element == key)
      foundKey = true;
    else if(key < n.element)
      foundKey = search(n.left, key);
    else
      foundKey = search(n.right, key);
    return foundKey;
  }

  public void displayInOrder(){
    System.out.println("Your tree:\n");
    displayInOrder(root);
    System.out.println("\n");
  }

  public void displayInOrder(Node n){
    if(n != null){  
      displayInOrder(n.left);
      System.out.println(n.element);
      displayInOrder(n.right);  
    }
  }

  public void displayPreOrder(){
    System.out.println("Your tree:\n");
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

  public void displayPostOrder(){
    System.out.println("Your tree: \n");
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

  public Node rotateRight(Node n){
    Node leftSon = n.left;
    n.left = leftSon.right;
    leftSon.right = n;
    return leftSon;
  }

  public Node rotateLeft(Node n){
    Node rightSon = n.right;
    n.right = rightSon.left;
    rightSon.left = n;
    return rightSon;
  }

  public void balance(){

  }
  
  public Node rotateRightLeft(Node n){
    n.right = rotateRight(n.right);
    return rotateLeft(n);
  }

  public Node rotateLeftRight(Node n){
    n.left = rotateLeft(n.left);
    return rotateRight(n);
  }
}
