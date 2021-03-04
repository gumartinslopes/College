import java.util.Arrays;
public class Teste{
  public static void mostraArray(String[] array){
    for(int i = 0; i < array.length; i++)
      System.out.println(array[i]);
  }

  public static void main(String[] args){
    Music m = new Music();
    String path = "teste.csv";
    String id = "4BJqT0PrAfrxzMOxytFOIz";
    m.registrar(m.ler(id, path));
    m.testPrint();
  }
}
