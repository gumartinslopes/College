public class Cell{
	public int element;
	public Cell next;
	
	public Cell(){
		this(0);
	}
	
	public Cell(int x){
		this.element = x;
		this.next = null;
	}
	
}