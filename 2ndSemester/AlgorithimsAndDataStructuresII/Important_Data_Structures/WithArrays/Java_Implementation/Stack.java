class Stack{
	int[] arrayStack;
	public Stack(int size){
		arrayStack = new int[size];
	}
	int top = 0;

	public void push(int x) throws Exception{
		if(top >= arrayStack.length)
			throw new Exception("Stack overflow");
		arrayStack[top] = x;
		top++;
	}
	
	public int pop() throws Exception{
		if(top == 0)
			throw new Exception("Empty stack");
		
		arrayStack[top] = 0;
		return arrayStack[--top];
	}
	public void show(){
		for(int i = top - 1; i >= 0; i--){
			System.out.println("= " + arrayStack[i] + " =");
		}
		System.out.println("=====");
	}

}
