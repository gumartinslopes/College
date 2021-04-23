class DoubleCell{
	public int element;
	public DoubleCell previous, next;
	public DoubleCell(){
		this(0);
	}	

	public DoubleCell(int x){
		this.element = x;
		this.next = this.previous = null;
	}
}