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
			System.out.println("\n\n\n");
	
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
			System.out.println("\n" + a + ", "+ b + " and " + c + " were removed form the list" );
			l.show();

			System.out.println("\n\n\n");

		//------Working With Queues--------------
		
			System.out.println("-------Queue-------");
			Queue q= new Queue(10);
			q.insert(1);
			q.insert(2);
			q.insert(3);
			q.insert(4);
			q.insert(5);
			q.insert(6);
			q.insert(7);
			q.insert(8);
			q.insert(9);
			q.insert(10);
			q.show();
			int d = q.remove();
			int e = q.remove();
			int f = q.remove();
			System.out.println(d +", " + e + ", " + f +" were removed");
			q.show();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
