public class List{
  private int[] array_list;
  private int list_length;

  public List(){
    this.array_list = new int[10];
    this.list_length = 0;
  }

  public List(int size){
    this.array_list = new int[size];
    this.list_length = 0;
  }
  public void printList(){
    for(int i = 0; i < list_length; i++)
      System.out.println((i + 1) + "-> " + array_list[i]);
   
    System.out.println("");
  }

  //insercao 
  public void insertFirst(int x){
    if(list_length >= array_list.length){
      System.out.println("Lista cheia");
    }
    else{
      for(int i = list_length; i > 0; i--)
        array_list[i] = array_list[i - 1];
      
      array_list[0] = x;
      list_length++;
      System.out.println(x + " foi inserido no inicio da lista");
    }
  }
  
  public void insertAt(int x, int pos){
    if(list_length >= array_list.length || pos < 0 || pos > list_length)
      System.out.println("Posicao invalida");
    else{
      for(int i = list_length; i > pos; i--)
        array_list[i] = array_list[i - 1];  
      array_list[pos] = x;
      list_length++;
      System.out.println(x + " foi inserido na posicao " + pos);
    }
  }

  public void insertLast(int x){
    if(list_length >= array_list.length)
      System.out.println("Lista cheia");
    else{  
      System.out.println(x + " foi inserido no final da lista");
      array_list[list_length++] = x;
    }
  }

  //remocao
  public void removeFirst(){
    if(list_length == 0)
      System.out.println("Lista vazia");
    else{  
      list_length--;
      for(int i = 0; i < list_length; i++)
        array_list[i] = array_list[i + 1];
    }  
  }
  
  public void removeAt(int pos){
    if(list_length == 0)
      System.out.println("Lista vazia");
    else if(pos > list_length || pos < 0)
      System.out.println("Posicao invalida");
    else{
      list_length--;
      for(int i = pos; i < list_length; i++)
        array_list[i] = array_list[i+1];
    }
  }

  public void removeLast(){
    if(list_length == 0) 
      System.out.println("Lista vazia");
    else{
      list_length--;
    }
  }
}