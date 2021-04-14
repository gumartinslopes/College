public class CircleQueue{
	public int[] queue;
	private int first, last;
	public CircleQueue(){
			this(10);
	}
	public CircleQueue(int length){
		queue = new int[length + 1];
		first = last = 0;
	}
	
	public void insert(int value){
		if(((last + 1) % queue.length) == first)
			System.out.println("Sorry the queue is full");
		else{
			queue[last] = value;
			last = (last + 1)%queue.length;
			System.out.println(value + " entered on the queue");
		}
	}
	
	public void remove(){
		if(last == first)
			System.out.println("Empty queue no one, can't remove");
		else{
			System.out.println(queue[first] + " was removed");
			first = (first + 1) % queue.length;
		}
	}
	
	public void display(){
		int i = first;
		System.out.println("Your queue: ");
		while(i != last){
			System.out.print(queue[i] + " - ");
			i = (i + 1) % queue.length;
		}
		System.out.print("");
	}
}

	