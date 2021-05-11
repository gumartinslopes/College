public class DoubleCell{
  public int element;
  public DoubleCell next, prev;  
  public DoubleCell(){
    this(0);
  }
  
  public DoubleCell(int x){
    this.element = x;
    this.next = this.prev = null;
  }
}
