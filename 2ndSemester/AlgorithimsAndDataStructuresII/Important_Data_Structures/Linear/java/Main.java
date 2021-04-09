public class Main{
  public static void main(String[] args){
   // testStack();
    testList();
  }

  public static void testStack(){
   Stack s = new Stack(10);
    s.printStack();
    for(int i = 0; i < 10; i++){
      s.push(i);
    }
    s.printStack();
    for(int i = 0; i < 5; i++){
      s.pop();
    }
    s.printStack();
  }
  
  public static void testList(){
    List l = new List(10);
    for(int i = 10; i > 0; i--)
      l.insertFirst(i);
    l.printList();

    for(int i = 10;i > 0; i--)
      l.removeFirst();
    
    for(int i = 0; i < 10; i++)
      l.insertLast(i);

    l.printList();
    
    for(int i = 0; i < 10; i++)
      l.removeLast();

    for(int i = 0; i < 10; i++){
      l.insertAt(i + 10,i);
    }

    l.printList();

    for(int i = 10; i > 0; i--)
      l.removeAt(i);
  }
}
