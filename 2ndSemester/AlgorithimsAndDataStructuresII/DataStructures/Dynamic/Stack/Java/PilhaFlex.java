public class PilhaFlex{
	//método de inserção
	private Cell top;
	public PilhaFlex(){
		top = null;
	}
	
	public void push(int x){
		Cell aux = new Cell(x);	
		aux.next = top;				//o próximo da auxiliar recebe o elemento inserido anteriormente ao topo
		top = aux;					//passamos o endereço de memória de aux para o topo
		aux = null;					//descartamos aux pois não precisamos mais
		System.out.println(x + " entered into the stack");
	}
	
	//método de remoção
	public int pop()throws Exception{
		if(top == null)
			throw new Exception("Pilha vazia");
		int removed = top.element;
		Cell aux = top;
		top = top.next;
		aux.next = aux = null;
		System.out.println(removed + " was removed from the stack");
		return removed; 
	}
	
	public void display(){
		System.out.println("Your stack:");
		for(Cell i = top; i != null; i = i.next)
			System.out.println("| " + i.element + " |");
	}
	
	
	public void displayRecursive(){
		System.out.println("Your stack:");
		displayRecursive();
		System.out.println("\n");
	}
	
	public void displayRecursive(Cell c){
		if(c.next != null){
			System.out.println(c.element);
			displayRecursive(c.next);
		}
	}
	
	public void displayBackwards(){
		System.out.println("Your stack backwards:");
		displayBackwards(top);
	}
		
	public void displayBackwards(Cell c){
		
		if(c.next != null)
			displayBackwards(c.next);
		System.out.println("| " + c.element + " |");
		
	}
	
	public int getSum(){
		int sum = 0;
		for(Cell i = top; i != null; i = i.next)
			sum += i.element;
		return sum;
	}
	
	public void count(){
		int n = 0;
		for(Cell i = top; i != null; i = i.next)
			n++;
		System.out.println("The number of elements on your stack is " + n);
	}
	//chamada inicial da soma por recursão
	public int getRecursiveSum(){
		return getRecursiveSum(top);
	}

	public int getRecursiveSum(Cell c){
		int sum = 0;
		if(c != null)
			 sum = c.element + getRecursiveSum(c.next);  
		return sum;
	}
	
	public int getBiggestElement(){
		int biggest = 0;
		for(Cell i = top; i != null; i = i.next)
			if(biggest < i.element)
				biggest = i.element;
		return biggest;
	}
}