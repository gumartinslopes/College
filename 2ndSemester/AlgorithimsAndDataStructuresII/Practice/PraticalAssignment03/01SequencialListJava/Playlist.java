class Playlist{
  private int length;
  private Music[] list;

  public Playlist(){
    this(500);
  }

  public Playlist(int maxLength){
    this.length = 0;
    this.list = new Music[maxLength];
  }

  public void display(){
    for(int i = 0; i < length; i++)
      System.out.println("[" + i + "] " + list[i].toString());
  }

  public void insertFirst(Music m){
    if(length == list.length)
      System.out.println("Número máximo de músicas na playlist alcançado.");
    else{
      for(int i = length; i > 0; i--)
        list[i] = list[i - 1].clone();
      list[0] = m.clone();
      length++;
    }
  } 

  public void insertPos(int pos, Music m){
    if(length == list.length)
      System.out.println("Número máximo de músicas na playlist alcançado.");
    else if(pos > list.length || pos < 0)
      System.out.println("Posição de inserção inválida");
    else{
      for(int i = length; i > pos; i--)
        list[i] = list[i - 1].clone();
      list[pos] = m.clone();
      length++;
    }
  }
  
  public void insertLast(Music m){
    if(length == list.length)
      System.out.println("Número máximo de músicas na playlist alcançado.");
    else
      list[length++] = m.clone();
  }
  
  //métodos de remoção
  public void removeFirst(){
    if(length == 0)
      System.out.println("A playlist está vazia, não há itens para remover");
    else{
      Music removed = list[0].clone();
      length--;
      for(int i = 0; i < length; i++)
        list[i] = list[i +1];
      System.out.println("(R) " + removed.getName());
    } 
  }
  
  public void removePos(int pos){
    if(length == 0) 
      System.out.println("A playlist está vazia, não há itens para remover");
    else if(pos < 0 || pos >= length)
      System.out.println("Posição de remoção inválida");
    else{
      Music removed = list[pos].clone();
      length--;
      for(int i = pos; i < length; i++)
        list[i] = list[i + 1];
      System.out.println("(R) " + removed.getName());
    }
  }
  
  public void removeLast(){
    if(length == 0)
      System.out.println("A playlist está vazia, não há itens para remover");
    else{
      Music removed = list[--length];
      System.out.println("(R) " + removed.getName());
    }
  }
}
