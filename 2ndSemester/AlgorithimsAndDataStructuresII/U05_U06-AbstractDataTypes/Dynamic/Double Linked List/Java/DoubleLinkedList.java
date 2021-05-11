public class DoubleLinkedList{
  private DoubleCell first, last;
  
  public DoubleLinkedList(){
    first = new DoubleCell();
    last = first;
  }
  
  public void insertFirst(int x){
    DoubleCell aux = new DoubleCell(x); 
    aux.prev = first;
    aux.next = first.next;
    first.next = aux;

    if(first == last)
      last = aux;
    else
      aux.next.prev = aux;
  }
  
  public void display(){
    for(DoubleCell i = first.next; i != null; i = i.next)
      System.out.println(" - " + i.element);
  }
  
  public void insertLast(int x){
    last.next = new DoubleCell(x);
    last.next.prev = last;
    last = last.next;
  }

  public void insertPos(int pos, int x)throws Exception{
    int length = getLength();
    if(pos < 0 || pos >= length)
      throw new Exception("Invalid insertion position!");
    else if(pos == 0)
      insertFirst(x);
    else if(pos == length)
      insertLast(x);
    else{
      DoubleCell i = first.next;
      for(int j = 0; j < pos; j++, i = i.next);
      DoubleCell aux = new DoubleCell(x);
      aux.next = i.next;
      i.next.prev = aux;
      aux.prev = i;
      i.next = aux;
    }
  }
  
  public int removeFirst()throws Exception{
    if(first == last)
      throw new Exception("Impossible to remove on an empty list");
    DoubleCell aux = first.next;
    first.next = first.next.next;
    first.next.prev = first;
    aux.next = aux.prev = null;
    return aux.element;
  }

  public int removeLast()throws Exception{
    if(first == last)
      throw new Exception("Impossible to remove on an empty list");
    int removed = last.element;
    last = last.prev;
    last.next.next = null;
    last.next = null;
    return removed;
  }

  public int removePos(int pos)throws Exception{
    int length = getLength();
    int removed;
    if(first == last)
      throw new Exception("Impossible to remove on an empty list");
    else if(pos < 0 || pos > length)
      throw new Exception("Invalid removal position");
    else if(pos == 0)
      removed = removeFirst();
    else if(pos == length - 1)
      removed = removeLast();
    else {
      DoubleCell i = first.next;
      for(int j = 0; j < pos; j++, i = i.next);
      DoubleCell aux = i.next;
      removed = aux.element;
      aux.prev = null;
      i.next = i.next.next;
      i.next.prev = i;
      aux.next = null;
    }
    return removed;
  }

  public int getLength(){
    int counter = 0;
    for(DoubleCell i = first.next; i != null; i = i.next, counter++);
    return counter;
  }
}
