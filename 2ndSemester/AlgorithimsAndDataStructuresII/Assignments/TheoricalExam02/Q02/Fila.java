public class Fila{
  public Celula primeiro, ultimo;
  public Fila(){
    primeiro = new Celula();
    ultimo = primeiro;
  }
  
  public void inserir(int el){
    ultimo.prox = new Celula(el);
    ultimo = ultimo.prox;
  }
}
