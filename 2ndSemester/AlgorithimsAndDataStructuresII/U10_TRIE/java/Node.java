public class Node{
	private char element;
	public boolean isLeaf;
	char []childrenTable;
	public int final length;
	
	public Node(char element, int sigma){
		this.element = element;
		isLeaf = true;
		length = 255;//ascii table size
		childrenTable = new char[sigma];
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
