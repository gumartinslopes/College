public class Cell{
	public int element;
	public Cell next;

	public Cell(){
		this(-1, null);
	}

	public Cell(int element){
		this(element, null);
	}

	public Cell(int element,Cell next){
		this.element = element;
		this.next = next;
	}

}
