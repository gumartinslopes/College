class DoubleLinkedList{
	private DoubleCell first, last;
	public DoubleLinkedList(){
		this.first = new DoubleCell();
		last = first;
	}

	public void insertFirst(int x){
		DoubleCell = new DoubleCell(x);
		aux.previous = first;
		aux.next = first.next;
		first.next = aux;
		if(first == last)
			last = aux;
		else
			aux.next.previous = aux;
		aux = null;
	}

	public void insertLast(int x){
		last.next = new DoubleCell(x);
		last.next.previous = last;
		last = last.next;
	}

	public void insertPos(int x){
		//bla bla bla
	}

	public void removeFirst(){
		if(first == last)
			System.out.println("Lista vazia");
		else{
			DoubleCell aux = first;
			int removed = first.next.element;
			first = first.next;
			aux.next = first.previous = null;
			aux = null;
			System.out.println("O elemento " + removed +"saiu do inicio da lista");
		}
	}

	public void removePos(){
		//bla bla bla
	}

	public void removeLast(){
		if(first == last)
			System.out.println("Lista vazia");
		else{

			//bla bla bla
		}
	}

	public void display(){
		int counter = 0;
		System.out.println("Your list");
		for(DoubleCell i = first.next; i != null; i = i.next)
			System.out.println((counter++) + "- " + i.element);
	}
}