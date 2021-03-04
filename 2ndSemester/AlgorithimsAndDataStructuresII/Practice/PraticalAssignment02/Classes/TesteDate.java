class TesteDate{
  public static void main(String[] args){
    SimpleDate a = new SimpleDate();
    System.out.println(a.getSimpleDateFormat());
    a = new SimpleDate(2020, 6, 12);
    System.out.println(a.getSimpleDateFormat());
    a = new SimpleDate(1999);
    
    System.out.println(a.getSimpleDateFormat());
  }
}
