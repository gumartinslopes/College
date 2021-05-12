public class Cell{
	public int element;
	public Cell next;
	
	public Cell(){
		this(0);
	}
	
	public Cell(int element){
		this.element = element;
		this.next = null;
	}
}