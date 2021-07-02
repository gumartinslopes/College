import java.util.Random;
class Main{
  public static Random generator;
  
  public static void main(String[] args){
   Fila f1 = new Fila(); 
   Fila f2 = new Fila(); 
   Fila f3 = new Fila();
   
   generator = new Random();
   
   insercoesAleatorias(f1);
   insercoesAleatorias(f2);
   insercoesAleatorias(f3); 
   
   System.out.print("Fila 1: ");
   display(f1);
   System.out.print("Fila 2: ");
   display(f2);
   System.out.print("Fila 3: ");
   display(f3);

   printSum(f1, f2, f3);
  }

  public static void insercoesAleatorias(Fila f){
    int bounds = Math.abs(generator.nextInt()%10);
    for(int i = 0; i < bounds; i++)
      f.inserir(Math.abs(generator.nextInt()%10));
  }
  
  public static void display(Fila fila){
    System.out.print("[");
    for(Celula i = fila.primeiro; i != null; i = i.prox){
      System.out.print(i.elemento + ((i.prox == null)? "]\n" :", "));
    }
  } 

  //metodo auxiliar
  public static void printSum(Fila f1, Fila f2, Fila f3){
    printSum(f1.primeiro, f2.primeiro, f3.primeiro);
  }

  public static void printSum(Celula c1, Celula c2, Celula c3){
    if(c1 != null || c2 != null || c3 != null){
      int sum = 0;
      sum += (c1 != null)? c1.elemento : 0;
      sum += (c2 != null)? c2.elemento : 0;
      sum += (c3 != null)? c3.elemento : 0; 
      System.out.println("soma: " + sum);
      printSum(validarProximo(c1), validarProximo(c2), validarProximo(c3));
    }
  } 

  //metodo que define se a proxima celula existe
  public static Celula validarProximo(Celula c){
    return ((c == null)? c : c.prox);
  } 
}
