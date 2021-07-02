public class Celula{
  public int elemento;
  public Celula prox;

  public Celula(){
    this(0);
  }

  public Celula(int el){
    this.elemento = el;
    this.prox = null;
  }
}
