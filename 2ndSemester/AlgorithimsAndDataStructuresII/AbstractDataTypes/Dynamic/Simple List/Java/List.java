public class List{
	private Cell first, last;
	public List(){
		first = new Cell();
		last = first;
	}

	public void insertFirst(int x){
		Cell aux = new Cell(x);
		aux.next = first.next;
		first.next = aux;
		if(first == last)
			last = aux;
		System.out.println(x + " entrou no inicio da lista");
		aux = null;
	}

	public int getLength(){
		int counter = 0;
		for(Cell i = first.next; i != null; i = i.next, counter++);
		return counter;
	}

	public void insertPos(int pos, int x){
		int length = getLength();
		if(first == last || pos < 0 || pos > length)
			System.out.println("Erro na insercao");
		else if(pos == 0)
			insertFirst(x);
		else if(pos == length)
			insertLast(x);
		else{
			Cell i = first;
			for(int j = 1; j < pos; j++,i = i.next);
			Cell aux = new Cell(x);
			aux.next = i.next;
			i.next = aux;
			aux = i = null;
			System.out.println(x + " foi inserido na posicao " + pos);
		}
	}

	public void insertLast(int x){
		last.next = new Cell(x);
		last = last.next;
		System.out.println(x + " entrou no fim da lista");
	}

	public void removeFirst(){
		if(first == last)
			System.out.println("Lista vazia, impossível remover");
		
		else{
			Cell aux = first;
			first = first.next;
			System.out.println(first.element + " foi removido do inicio da lista");
			aux.next = null;
			aux = null;
		}
	}	

	public void removePos(int pos){
		int length = getLength();
		if(first == last || pos < 0 || pos > length)
			System.out.println("Erro de remocao");
		else if(pos == 0)
			removeFirst();
		else if(pos == length - 1)
			removeLast();
		else{
			Cell i = first;
			int removed; 
			for(int j = 0; j < pos; j++, i = i.next);
			Cell aux = i.next;
			removed = aux.element;
			i.next = aux.next;
			aux.next = null;
			i = aux = null;
			System.out.println(removed + " foi removido da posicao " + pos);
		}
	}
	
	public void removeLast(){
		if(first == last)
			System.out.println("Lista vazia, impossível remover");
		else{
			Cell i;
			for(i = first; i.next != last; i = i.next);
			int removed = last.element;
			last = i;
			i = last.next = null;
			System.out.println(removed + " foi removido do final da sua lista");
		}
	}

	public void removeSecondPos(){
		Cell p = first.next;
		Cell q = first.next.next;
		p.next = q.next;
		first.next = p;
		System.out.println(q.element + " foi removido da segunda posicao");
		q = null;
	}
	
	public void display(){
		System.out.println("Sua lista:");
		for(Cell i = first.next; i != last.next; i = i.next)
			System.out.print(((i != last) ? i.element +  " , " : i.element));
		System.out.println();
	}
}

