public class Agenda{
 public Node root;
 
 public Agenda()throws Exception{
  root = null;
  for(int l = 65; l <= 90; l++)
    insertNode((char)l);
 }

 public void insertContact(Contact c)throws Exception{
  insertContact(c, root);   
 }
 
 public void insertContact(Contact c, Node n)throws Exception{
  char firstLetter = c.getName().charAt(0);
  if(firstLetter == n.getLetter())
    n.insertCell(c);

  else if(firstLetter < n.getLetter())
    insertContact(c, n.left);
  else if(firstLetter > n.getLetter())
    insertContact(c, n.right);
  else 
    throw new Exception("Invalid contact insertion");
 }
 
 public void removeContact(String name){
    
 }
 
 public void search(String name){

 }

 public void search(int cpf){
  
 }
 
 private void insertNode(char l) throws Exception{ 
   root  = insertNode(l, root); 
 }

 private Node insertNode(char l, Node n) throws Exception{
    if(n == null)
      n = new Node(l);
    else if(l < n.getLetter())
      n.left = insertNode(l, n.left);
    else if(l > n.getLetter())
      n.right = insertNode(l, n.right);
    else 
      throw new Exception("A node with the letter " + l + " already exists on your agenda");
    return n;
 }
 
 public void removeNode(){
    
 }
 
 public void display(){
    display(root);
 }
 
 public void display(Node n){
   if(n != null){
    display(n.left);
    System.out.println(n.getLetter());
    n.displayNames();
    System.out.println("\n");
    display(n.right);
  }
 }
}
