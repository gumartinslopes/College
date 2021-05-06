/*
 Implementação da árvore binária de pesquisa
*/
public class BinaryTree{
  Node root;
  
  public BinaryTree(){
    root = null;
  }
  
  public void insert(int x)throws Exception{
    root = insert(x, root);
  }
  
  public Node insert(int x, Node n)throws Exception{
    if(n == null)
      n = new Node(x);
    else if(x < n.element)
      n.leftChild = insert(x, n.leftChild);
    else if(x > n.element)
      n.rightChild = insert(x, n.rightChild);
    else
      throw new Exception("Valor ja existente na arvore!");
    return n;
  }
  
  //metodo de insercao passando o pai como parametro
  public void insertByFather(int x)throws Exception{
    if(root  == null)
      root = new Node(x);
    else if(x < root.element)
      insertByFather(x, root.leftChild, root);
    else if(x > root.element)
      insertByFather(x, root.rightChild, root);
    else 
      throw new Exception("Valor ja existente na arvore!");
  }

  public void insertByFather(int x, Node n, Node father)throws Exception{
    if(n == null){
      if(x < father.element)
        father.leftChild = new Node(x);
      else
        father.rightChild = new Node(x);
    }
    else if(x < n.element)
      insertByFather(x, n.leftChild, n);
    else if(x > n.element)
      insertByFather(x, n.rightChild, n);
    else 
      throw new Exception("Valor ja existente na arvore");
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
  
  public void displayCentral(){
    System.out.println("Sua arvore:");
    displayCentral(root);
  }
  
  public void displayCentral(Node n){
    if(n != null){
      displayCentral(n.leftChild);
      System.out.println(n.element + " ");
      displayCentral(n.rightChild);
    }
  }
  
  public void displayPos(){
    System.out.println("Sua arvore");
    displayPos(root);
  }
  
  public void displayPos(Node n){
    if(n != null){
      displayPos(n.leftChild);
      displayPos(n.rightChild);
      System.out.println(n.element + " ");
    }
  }
  
  public void displayPre(){
    displayPre(root);
  }

  public void displayPre(Node n){
    if(n != null){
      System.out.println(n.element + " ");
      displayPre(n.leftChild);
      displayPre(n.rightChild);
    }
  }
}
