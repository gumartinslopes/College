public class RedBlack{
  private Node root;

  public RedBlack(){
    root = null;
  }

  public boolean search(int key){
    return search(key, root);
  }

  public boolean search(int key, Node n){
    boolean result;
    if(n == null)
      result = false;
    else if(n.element == key) 
      result = true;
    else if(n.element > key)
      result = search(key, n.left);
    else
      result = search(key, n.right);
    return result;
  }
  
  //display methods
  public void displayInOrder(){
    displayInOrder(root);
  }
  
  public void displayInOrder(Node n){
    if(n != null){
      displayInOrder(n.left);
      System.out.println("->" + n.element);
      displayInOrder(n.right);
  
    }
  }
  public void displayPreOrder(){
    displayPreOrder(root);
  }

  public void displayPreOrder(Node n){
    if(n != null){
      System.out.println("->" + n.element);
      displayPreOrder(n.left);
      displayPreOrder(n.right); 
    }
  }
  public void displayPostOrder(){
    displayPostOrder(root);
  }

  public void displayPostOrder(Node n){
    if(n != null){
      displayPostOrder(n.left);
      displayPostOrder(n.right);
      System.out.println("->" + n.element);  
    }
  }

  public void insert(int element)throws Exception{
    if(root == null) {
      root = new Node(element, false);
      System.out.println("The root was created with the element " + element);
    } 
    else if(root.left == null && root.right == null) {
      if(root.element > element){
        root.left = new Node(element, true);
        System.out.println("The element (" + element + ") was inserted as left child of the root (" + root.element + ")");
      } 
      else {
        root.right = new Node(element, true);
        System.out.println("The element (" + element + ") was inserted as right child of the root (" + root.element + ")");
      
      }
    }
    else if(root.left == null){
     if(root.element > element){
        root.left = new Node(element);
        System.out.println("Case A: Root ->(" + root.element + ")\nroot's left child-> " + root.left.element + ")\nroot's right child + (" + root.right.element+ ")");
     } 
     else if(root.right.element > element){
        root.left = new Node(root.element);
        root.element = element;
        System.out.println("Case B: Root ->(" + root.element + ")\nroot's left child-> " + root.left.element + ")\nroot's right child + (" + root.right.element+ ")");
     }
     else{
        root.left = new Node(root.element);
        root.element = root.right.element;
        root.right.element = element;
        System.out.println("Case C: Root ->(" + root.element + ")\nroot's left child-> " + root.left.element + ")\nroot's right child + (" + root.right.element+ ")");
     }
    }
    else if(root.right == null){
      if(root.element < element){
        root.right = new Node(element);
        System.out.println("Case D: The element +(" + element + ") entered as the right child of the root " + root.element);
      }
      else if(root.left.element < element){
        root.right = new Node(root.element);
        root.element = element;
        System.out.println("Case E: The element (" + element + " ) entered as the right child of the root " + root.element);
      }
      else {
          root.right = new Node(root.element);
          root.element = root.left.element;
          root.left.element = element;
        System.out.println("Case F: The element (" + element + ") entered as the right child of the root " + root.element);
      }
    }
    else{
      System.out.println("The tree has three or more elements...\n");
      insert(element, null, null, null, root);
    }
    root.color = false;
  }

  private void insert(int element, Node greatGrandFather, Node grandFather, Node father, Node i)throws Exception{
    if(i == null){
      if(element < father.element){
        i = father.left = new Node(element, true);  //insercao na folha da esquerda
      }
      else{
        i = father.right = new Node(element, true); //insercao na folha da direita    
      }
      if(father.color == true)
        balance(greatGrandFather,grandFather, father, i);
    }
    else {
      if(i.left != null && i.right!= null && i.left.color == true && i.right.color == true){
        i.color = true;
        i.left.color = i.right.color = false;
        if(i == root){
          i.color = false;
        }
        else if(father.color == true){
          balance(greatGrandFather,grandFather, father, i);
        }
      }
      if(element < i.element){
        insert(element, grandFather, father, i, i.left);
      }
      else if(element > i.element){
        insert(element, grandFather, father, i, i.right);
      }
      else {
        throw new Exception("The element (" + element + ") already exists on your tree");
      }
    }
  }

  private void balance(Node greatGrandFather, Node grandFather, Node father, Node i){
    if(father.color == true){
      if(father.element > grandFather.element){
          if(i.element > father.element)
            grandFather = rotateLeft(grandFather);
          else
            grandFather = rotateRightLeft(grandFather);
      }
      else {//rotacao para a direita
        if(i.element < father.element)
          grandFather = rotateRight(grandFather);
        else
          grandFather = rotateLeftRight(grandFather);
      }

      if(greatGrandFather == null){
        root = grandFather;
      }
      else if(grandFather.element < greatGrandFather.element){
        greatGrandFather.left = grandFather;
      }
      else{
        greatGrandFather.right = grandFather;
      }
      //reestabelecimento das cores apos o balanceamento
      grandFather.color = false;
      grandFather.left.color = grandFather.right.color = true;
    }
  }

  private Node rotateLeft(Node n){
    System.out.println("Left rotation on " + n.element);
    Node rightChild = n.left;
    n.right = rightChild.right;
    rightChild.left = n;
    return rightChild;
  }
  
  private Node rotateRight(Node n){
    System.out.println("Right rotation on " + n.element);
    Node leftChild = n.right;
    n.left = leftChild.right;
    leftChild.left = n;
    return leftChild;
  }
  
  private Node rotateLeftRight(Node n){
    n.left = rotateLeft(n.left);
    return rotateRight(n);
  }

  private Node rotateRightLeft(Node n){
    n.right = rotateRight(n.right);
    return rotateLeft(n);
  }
}
