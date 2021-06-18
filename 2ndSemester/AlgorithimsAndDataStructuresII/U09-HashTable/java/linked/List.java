public class List{
	public Cell first, last;
	
	public List(){
		first = new Cell( - 1);
		last = first;
	}

	//in this implementation all of the insertions will 
	//happen on the first position of the list which is 
	//first.next
	public void insert(int element){
		Cell aux = new Cell(element);
		aux.next = first.next;
		first.next = aux;
		if(first == last)
			last = aux;
		aux = null;		
	}

	public boolean search(int key){
		boolean result = false;
		for(Cell i = first.next; i != null; i = i.next){
			if(i.element == key){
				result = true;
				i = last;
			}
		}
		return result;
	}
	
	public void remove(int key){
		if(first == last)
			System.out.println("Your your is empty");
		else {
			Cell i = first;
			while(i.next != null && i.next.element != key) 
				i = i.next;
			if(i.next == null)
				System.out.println("Element not found on the list");
			else {
				Cell aux = i.next;
				i.next = i.next.next;
				aux = aux.next = null;
				System.out.println("The element " + key + " was removed");
			}
		}
	}
	
	public void display(){
		System.out.print("\t[");
		for(Cell i = first.next; i != null; i = i.next){
			System.out.print(i.element +  ((i.next == null) ? "]\n" : ", "));
		}

	}
}
