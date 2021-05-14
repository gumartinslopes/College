public class ExternalBinaryTree{
  private Node root;
  
  public ExternalBinaryTree() throws Exception{
    this.root = null;
    treeInit();
  }
  
  public void treeInit()throws Exception{
    insertNode('M');
    
    insertNode('G');
    insertNode('T');

    insertNode('A');
    insertNode('I');
    insertNode('H');
    insertNode('J');
    
    insertNode('N');
    insertNode('V');
  }
  
  public void insertNode(char l)throws Exception{
    root  = insertNode(l, root);
  }

  private Node insertNode(char l, Node n)throws Exception{
    if(n == null)
      n = new Node(l);
    else if(l < n.letter)
      n.left = insertNode(l, n.left);
    else if(l > n.letter)
      n.right = insertNode(l, n.right);
    else 
      throw new Exception("The letter " + l + " already exists on your tree");
    return n;
  }
  
  public boolean search(char l){
    return ((getNode(l) == null) ? false : true);
  }

  public Node getNode(char l){
    return getNode(l, root);
  }
  
  private Node getNode(char l, Node n){
    Node result;
    if(n == null)
      result = null;
    else if(l == n.letter)
      result = n;
    else if(l < n.letter)
      result = getNode(l, n.left);
    else 
      result = getNode(l, n.right); 
    return result;
  }
  
  public void insertWord(String word)throws Exception{
    if(Character.isLetter(word.charAt(0))){
      Node insertionNode = getNode(Character.toUpperCase(word.charAt(0)));
      if(insertionNode == null){
        insertNode(word.charAt(0));
        insertWord(word);
      }
      else
        insertionNode.insertOnSubtree(word);
    }
    else 
      throw new Exception("Invalid insertion");
  }

  public void removeWord(String word)throws Exception{
    Node removalNode = getNode(word.charAt(0));
    if(removalNode != null){
      removalNode.removeSubNode(word);
    }
    else 
      throw new Exception("This word is not on your tree!");
  }


  public void display(){
    sortedDisplay(root);
  }

  public void sortedDisplay(Node n){
    if(n != null){
      sortedDisplay(n.left);
      System.out.println(n.letter);
      n.displaySubTree();
      sortedDisplay(n.right);
    } 
  }
}
