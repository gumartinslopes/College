public class Stack{
  private int[] array_stack;
  private int element_quantity;

  public Stack(){
    this.array_stack = new int[10];
    this.element_quantity = 0;
  }

  public Stack(int size){
    this.array_stack = new int[size];
    this.element_quantity = 0;
  }
  
  public void printStack(){
    for(int i = element_quantity - 1; i >= 0; i--){
      System.out.print("|");
      System.out.print(array_stack[i]);
      System.out.println("|");
    }
    System.out.println("---");
  }

  public void push(int input){
    if(element_quantity == array_stack.length)
      System.out.println("Stack overflow");
    else{
      array_stack[element_quantity++] = input;
      System.out.println(input + " foi inserido");
    }  
  }
  
  public void pop(){
    if(element_quantity > 0){
      System.out.println(array_stack[element_quantity - 1] + " foi removido");
      element_quantity--;
    }
    else 
      System.out.println("Impossivel remover uma pilha vazia");
  }
}
