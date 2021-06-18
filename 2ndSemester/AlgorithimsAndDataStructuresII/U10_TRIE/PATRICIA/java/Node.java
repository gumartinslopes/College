public class Node{
	public int pos, start, end;
	public int length = 255;
	public Node []children;
	public boolean isLeaf;
	public Node(){
		this(-1, -1, -1, false);	
	}

	public Node (int pos, int start, int end){
		this.pos = pos;
		this.start = start;
		this.end = end;	
		this.leaf = leaf;

		children = new Node[size];
		for(int l = 0; l < length; l++)
			children[l] = null;
	}
}
