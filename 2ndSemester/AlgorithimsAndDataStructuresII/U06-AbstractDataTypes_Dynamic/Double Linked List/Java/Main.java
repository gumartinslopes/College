public class Main{
  public static void main(String[] args){
   try{
    DoubleLinkedList dll = new DoubleLinkedList();
    dll.insertFirst(1);
    dll.insertFirst(1);
    dll.insertFirst(1);
    for(int i = 0; i < 30; i++)
      dll.insertPos(1, i);
    dll.removeFirst();
    dll.removeLast();
    dll.removePos(7);
    dll.display();
   }catch(Exception ex) {
    ex.printStackTrace();
   }
  }
}
