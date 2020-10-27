class Main{
	public static void main(String[] args){
		try{
		//------Working With Stacks--------------
			System.out.println("-------Stack------");
			Stack s = new Stack(10);
			s.push(5);
			s.push(4);
			s.push(3);
			s.push(2);
			s.push(1);
			s.show();
			int removed = s.pop();
			s.show();
	
		//------Working With Lists--------------
			System.out.println("-------list-------");
			List l = new List(10);
			l.insertAtBeginning(1);
			l.insert(2,1);
			l.insertAtEnding(3);
			l.insertAtEnding(4);
			l.insertAtEnding(5);	
			l.insertAtEnding(6);
			l.insertAtEnding(7);
			l.insertAtEnding(8);
			l.show();
			int a = l.removeAtEnding();
			int b =l.removeAtBeginning();
			int c = l.remove(3);
			System.out.println(a + ","+ b + "and" + c + "were removed form the lis" );
			l.show();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
