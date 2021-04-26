class Main{
	public static void main(String[] args){
		try{
			BinaryTree bt = new BinaryTree();
			bt.insert(5);
			bt.insert(6);
			bt.walkFirst(bt.raiz);
			//System.out.println(bt.search(5));
			//System.out.println(bt.search(6));
			System.out.println(bt.raiz.elemento);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}