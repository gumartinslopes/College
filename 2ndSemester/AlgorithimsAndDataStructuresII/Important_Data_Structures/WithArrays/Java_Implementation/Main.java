class Main{
	public static void main(String[] args){
		try{
		//------Working With Stacks--------------
			Stack s = new Stack(10);
			s.push(5);
			s.push(4);
			s.push(3);
			s.push(2);
			s.push(1);
			s.show();
			int removed = s.pop();
			s.show();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
