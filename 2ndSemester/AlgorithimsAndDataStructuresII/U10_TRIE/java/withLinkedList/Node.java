public class Node{
	private char element;
	public boolean isLeaf;
	Node []children;
	public final int length = 255;
	
	public Node(){
		this(' ');
	}

	public Node(char element){
		this.element = element;
		isLeaf = false;
		children = new Node[length];
		for(int i = 0; i < length; i++)children[i] = null; //initializing table
	}

	public void setElement(char element){
		this.element = element;
	}
	
	public char getElement(){
		return this.element;
	}

	public static int hash(char x){
		return (int)x;			
	}
}
