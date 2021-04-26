public class Queue{
	private Cell first, last;
	public Queue(){
		first = new Cell();
		last = first;
	}
	public void insert(int x){
		last.next = new Cell(x);
		last = last.next;
	}
	
	public int remove(){
		int element = 0;
		if(first == last)
			System.out.println("Fila vazia, impossível inserir");
		else{
			Cell aux = first;
			first = first.next;
			element = first.element;
			aux.next = null;
			aux = null;
		}
		return element;
	}
	
	public int physicalRemove(){
		int element = 0;
		if(first == last)
			System.out.println("Fila vazia, impossível inserir");
		else{
			Cell aux = first.next;
			first = first.next.next;
			element = first.element;
			aux.next = null;
			aux = null;
		}
		return element;
	}
	
	public void display(){
		int counter = 1;
		System.out.println("Your queue:");
		for(Cell i = first.next; i != null; i = i.next)
			System.out.println((counter++) + "- " + i.element);
	}
	
	public int getBiggest(){
		int biggest = 0;
		if(first == last)
			System.out.println("Fila vazia, impossível inserir");
		else{
			biggest = first.next.element;
			for(Cell i = first.next.next; i != null; i = i.next)
				if(biggest < i.element)
					biggest = i.element;
		}
		return biggest;
	}
	
	public int getSum(){
		int sum = 0;
		for(Cell i = first.next; i != null; i = i.next)
			sum += i.element;
		return sum;
	}
	
	public void reverse(){
		Cell end = last;
		while(first != end){
			Cell n = new Cell(first.next.element);
			n.next = end.next;
			end.next = n;
			Cell aux = first.next;
			first.next = aux.next;
			n = aux = aux.next = null;
			if(last == end)
				last = last.next;
			
		}
		end = null;
	}

	public int countEven(){
		return countEven(first.next);
	}

	public int countEven(Cell c){
		int counter = 0;
		if(c != null)
			counter = (c.element % 2 == 0 && c.element % 5 == 0) ? (1 + countEven(c.next)) : (countEven(c.next));  
		return counter;
	}

	public void metodoDoidao(){
		System.out.println("Doidao rodando...");
		System.out.println("fim -> ultimo[x,ultimo.prox]");
		Cell end = last;
			while(first != end){
				System.out.println("ultimo.prox -> [" + first.next.element + ", prox]");
				last.next = new Cell(first.next.element);
				System.out.println("tmp -> primeiro[" + first.element + ", primeiro.prox]");
				Cell aux = first;
				first = first.next;
				System.out.println("primeiro -> primeiro.prox[" +first.next.element + ", primeiro.prox.prox]");
				aux = aux.next = null;
				System.out.println("tmp -> *null*");
				last = last.next;
				System.out.println(" ");
			}
		end = null;
	}

	Cell toQueue(Cell top){
		Cell first  = new Cell();
		Cell last = first;
		last = toQueu(top, last);
		return first;
	}

	Cell toQueue(Cell i, Cell last){
		if(i != null){
			last = toQueue(i.next, last);
			last.next = new Cell(i.element);
			last = last.next;
		}
		return last;
	}
}