public class Node{
	private char element;
	public boolean isLeaf;
	char []children;
	public int final length;
	
	public Node(){
		this(' ');
	}

	public Node(char element){
		this.element = element;
		isLeaf = true;
		length = 255;//ascii table size
		children = new char[sigma];
	}

	public void setElement(char element){
		this.element = element;
	}
	
	public char getElement(){
		return this.element;
	}

	public void insertTable(){
			
	}

	public void hash(){
		return(int)x			
	}
}