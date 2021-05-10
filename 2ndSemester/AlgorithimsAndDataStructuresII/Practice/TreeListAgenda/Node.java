public class Node{
  private char letter;
  public Node left, right;
  public Cell first, last;
  
  public Node(char letter){
    this(letter, null, null);
  }

  public Node(char letter, Node left, Node right){
    this.letter = letter;
    this.left = left;
    this.right = right;
    this.first = new Cell();
    last = first;
  }

  public char getLetter(){
    return this.letter;
  }
  
  public void insertCell(Contact c){
    last.next = new Cell(c);
    last = last.next;
  }
  
  public void removeCell(Contact c){
    //terminar
  }

  //lista os elementos inseridos
  public void displayNames(){
    for(Cell i = first.next; i != null; i = i.next)
      System.out.println("\t-" + i.contact.getName());
  }
}
