public class Node{
	private char element;
	public boolean isLeaf;
	public BinaryTree children;
	
	public Node(){
		this(' ');
	}

	public Node(char element){
		this.element = element;
		isLeaf = false;
		children = new BinaryTree();
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
