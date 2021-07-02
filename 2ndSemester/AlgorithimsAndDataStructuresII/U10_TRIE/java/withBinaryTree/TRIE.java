public class TRIE{
	private Node root;
	
	public TRIE(){
		root = new Node();
	}
	
	public boolean search(String s){
		return search(s, root, 0);
	}
	
	public boolean search (String s, Node n, int i){
		boolean result;
		if(n.children[s.charAt(i)] == null)
			result = false;
		else if(i == s.length() - 1)
			result = (n.children[s.charAt(i)].isLeaf == true);
		else
			result = search(s, n.children[s.charAt(i)],i + 1);
		return result;
	}
	public void insert(String s)throws Exception{
		insert(s, root, 0);
	}
	public void insert(String s, Node n, int i)throws Exception{
		
		if(n.children[s.charAt(i)] == null){
			n.children[s.charAt(i)] = new Node(s.charAt(i));
			
			if(i == s.length() - 1)
				n.children[s.charAt(i)].isLeaf = true;
			else 
				insert(s, n.children[s.charAt(i)], i + 1);
		}
		else if(n.children[s.charAt(i)].isLeaf == false && i < s.length() - 1)
			insert(s, n.children[s.charAt(i)], i + 1);

		else
			throw new Exception("Insertion error"); 
	}

	public void display(){
		display("", root);
	}

	public void display(String s, Node n){
		if(n.isLeaf == true)
			System.out.println(s + n.getElement());
		else{
			for(int i = 0; i < n.children.length; i++)
				if(n.children[i] != null){
					display((s + n.getElement()), n.children[i]);
				}
		}
	}
}
