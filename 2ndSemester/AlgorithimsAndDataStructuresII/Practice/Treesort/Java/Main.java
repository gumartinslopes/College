import java.util.Random;

public class Main{
  
  public static void main(String[] args){
    TreeSort ts = new TreeSort();  
    int []array = new int[10];
    populate(10, array);
    display(array);
    ts.sort(array);
    display(array);
  }

  public static void display(int []array){
    System.out.print("[");
    for(int i = 0; i < array.length; i++)
      System.out.print(array[i] + ((i < array.length - 1)? ", " : ""));
    System.out.println("]");
  }

  public static void populate(int maxLen, int []array){
    Random generator = new Random(); 
    for(int i = 0; i < maxLen; i++)
      array[i] = Math.abs(generator.nextInt() % 100);
  }
}
