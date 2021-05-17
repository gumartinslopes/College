/*
 Implementação da árvore binária de pesquisa
*/
public class BinaryTree{
  public Node root;
  
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
  
  public void remove(int key)throws Exception{
    root = remove(key, root);
  }

  public Node remove(int key, Node n)throws Exception{
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
  
  public void inorderDisplay(){
    System.out.println("Sua arvore:");
    inorderDisplay(root);
  }
  
  public void inorderDisplay(Node n){
    if(n != null){
      inorderDisplay(n.leftChild);
      System.out.println(n.element + " ");
      inorderDisplay(n.rightChild);
    }
  }
  
  public void postorderDisplay(){
    System.out.println("Sua arvore");
    postorderDisplay(root);
  }
  
  public void postorderDisplay(Node n){
    if(n != null){
      postorderDisplay(n.leftChild);
      postorderDisplay(n.rightChild);
      System.out.println(n.element + " ");
    }
  }
  
  public void preorderDisplay(){
    preorderDisplay(root);
  }
  
  public void preorderDisplay(Node n){
    if(n != null){
      System.out.println(n.element + " ");
      preorderDisplay(n.leftChild);
      preorderDisplay(n.rightChild);
    }
  }
  
  public int getBiggest(){
    return getBiggest(root);
  }

  public int getBiggest(Node n){
    int biggest = 0;
    biggest = (n.rightChild != null) ? getBiggest(n.rightChild) : n.element;
    return biggest;
  }

  public int getSmallest(){
   return getSmallest(root);
  }

  public int getSmallest(Node n){
    int smallest = 0;
    smallest = (n.leftChild != null) ? getSmallest(n.leftChild) : n.element;
    return smallest;
  }

  public int getSum(){
    return getSum(root);
  }
   
  public int getSum(Node n){
    int sum = 0;
    if(n != null)
      sum = (n.element + getSum(n.leftChild) + getSum(n.rightChild));
    return sum;
  }

  public int countEven(){
    return countEven(root);
  }

  public int countEven(Node n){
    int counter = 0;
    if(n != null)
      counter = ((n.element % 2 == 0) ? 1: 0) + countEven(n.leftChild) + countEven(n.rightChild);
    return counter;
  }
  
  public int countOdds(){
    return countOdds(root);
  }

  public int countOdds(Node n){
    int counter = 0;
    if(n != null)
      counter = ((n.element % 2 != 0) ? 1 : 0) + countOdds(n.leftChild) + countOdds(n.rightChild);
    return counter;
  }
  
  public boolean hasDivisible(int key){
    return hasDivisible(key, root);
  }
  
  public boolean hasDivisible(int key, Node n){
    boolean result; 

    if(n != null)
        result = (n.element % key == 0) || hasDivisible(key, n.leftChild) || hasDivisible(key ,n.rightChild);
    else 
      result = false;
    return result;
  }
}
