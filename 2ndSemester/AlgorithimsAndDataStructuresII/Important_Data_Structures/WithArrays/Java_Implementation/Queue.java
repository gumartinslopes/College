class Queue{
	int[] queue;
	int first, last;
	Queue(){
		this(7);
	}
	Queue(int size){
		queue = new int[size + 1];
		first = last = 0;
	}
	void insert(int x) throws Exception{
		if(last + 1 % queue.length == 0){
			throw new Exception("Full queue");
		}
		queue[last] = x;
		last = (last + 1) % queue.length;
	}
	
	int remove()  throws Exception{
		int removed;
		if(first == last){
			throw new Exception("Empty list");
		}
		removed = queue[first];
		first = (first + 1) % queue.length;
		return removed;
	}
	void show(){
		int i = first;
		System.out.print("[");
		while(i != last){
			System.out.print(queue[i] + ",");
			i = (i  + 1) % queue.length;
		}
		System.out.println("]");
	}
}
