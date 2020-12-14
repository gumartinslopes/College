class Principal{
  public static BinaryTree bt = new BinaryTree();
  
  public static  void ex01()throws Exception{
    String entrada; 
    do{
      entrada = MyIO.readLine();
      if(!entrada.equals("FIM"))
        bt.insert(Integer.parseInt(entrada));
    }while(!entrada.equals("FIM"));
   
    bt.walkFirst(bt.root);
    bt.root = bt.rotateRight(bt.root);
    bt.walkFirst(bt.root);
   }

  public static void ex02() throws Exception{
    String entrada;
    do{
      entrada = MyIO.readLine();
      if(!entrada.equals("FIM"))
        bt.insert(Integer.parseInt(entrada));
    }while(!entrada.equals("FIM"));
    bt.walkFirst(bt.root);
    bt.root = bt.rotateLeft(bt.root);
    bt.walkFirst(bt.root);
  }

  public static void ex03() throws Exception{
    String entrada;
    do{
        entrada = MyIO.readline();
        if(!entrada.equals("FIM"))
          bt.insert(Integer.parseInt(entrada));
    }
    while(!entrada.equals("FIM"));
    
    bt.walkFirst();
    bt.balance();
  }
  
  public static void main(String[] args){
   try{
    //ex01();
    ex02();
   }
   catch(Exception ex){
      ex.printStackTrace();
   }
  }
}
