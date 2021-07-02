/*
 Implementação da árvore binária de pesquisa
*/
public class BinaryTree{
  public Node root;
  
  public BinaryTree(){
    root = null;
  }
  
  public void insert(char x)throws Exception{
    root = insert(x, root);
  }
  
  public Node insert(char x, Node n){
    if(n == null)
      n = new Node(x);
    else if(x <= n.element)
      n.leftChild = insert(x, n.leftChild);
    else 
      n.rightChild = insert(x, n.rightChild);
    return n;
  }
  
  public void remove(char key)throws Exception{
    root = remove(key, root);
  }

  public Node remove(char key, Node n)throws Exception{
    if(n == null)
      throw new Exception("Elemento nao encontrado, impossivel remover");
    else if(key < n.element)
      n.leftChild = remove(key, n.leftChild);
    else if(key > n.element)
      n.rightChild = remove(key, n.rightChild);  
    else if(n.leftChild == null)
      n = n.rightChild;
    else if(n.rightChild == null)
      n = n.leftChild;
    else 
      n.leftChild = getBiggestLeftChild(n, n.leftChild);
    return n;
  }

  public Node getBiggestLeftChild(Node i, Node j){
    if(j.rightChild == null){
      i.element = j.element;
      j = j.leftChild;
    }
    else
      j.rightChild = getBiggestLeftChild(i, j.rightChild);
    return j;
  }

  public Node getSmallestRightChild(Node i, Node j){
    if(j.leftChild == null){
      i.element = j.element;
      j = j.rightChild;
    }
    else 
      j = getSmallestRightChild(i, j.leftChild);
    return j;
  }

  public boolean search(int value){
    return search(value,root);
  }

  public boolean search(int key, Node n){
   boolean result;
   if(n == null)
    result = false;
   else if(key == n.element)
    result = true;
   else if(key < n.element)
    result = search(key, n.leftChild);
   else 
    result = search(key, n.rightChild);
   return result;
  }
  
  public void displayInOrder(){
    System.out.println("Sua arvore:");
    displayInOrder(root);
  }
  
  public void displayInOrder(Node n){
    if(n != null){
      displayInOrder(n.leftChild);
      System.out.println(n.element + " ");
      displayInOrder(n.rightChild);
    }
  }
}
