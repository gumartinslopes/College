class Main{
  public static void main(String[] args){
    RedBlack rb = new RedBlack();
    try{
     rb.insert(17);
     rb.insert(58);
     rb.insert(69);
     rb.insert(45);
     rb.insert(14);
     rb.insert(6);
     rb.displayPreOrder();
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}
