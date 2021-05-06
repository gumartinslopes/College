public class Stack{
	int[] stack;
	int maxHeigth;
	int height;
	public Stack(){
		this(10);
	}

	public Stack(int maxHeigth){
		this.maxHeigth = maxHeigth;
		this.stack = new int[maxHeigth];
		this.height = 0;
	}

	public void push(int element){
		stack[height++] = element;
	}

	public void pop(){
		if(height > 0)
			stack[height--] = 0;
	}

	public void display(){
		System.out.println("Your stack dude:");
		for(int i = 0; i < height; i++)
			System.out.println(" - " + stack[i]);
	}
}