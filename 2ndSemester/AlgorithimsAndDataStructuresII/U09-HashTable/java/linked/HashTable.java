public class HashTable{
	private List[]table;
	private final int NULL = - 1;
	int maxLength;
	
	public HashTable(){
		this(7);
	}

	public HashTable(int maxLength){
		this.maxLength = maxLength;
		table = new List[maxLength];
		for(int i = 0; i < maxLength; i++)
			table[i] = new List();
	}
	
	public int hash(int x){
		return (x % maxLength);
	}

	public boolean search(int key){
		int pos = hash(key);
		return table[pos].search(key);
	}

	public void insert(int element){
		int pos = hash(element);
		table[pos].insert(element);
	}

	public void display(){
		for(int i = 0; i < maxLength; i++){
			System.out.printf("-> %d", i);
			if(table[i].first.next == null)
				System.out.println(" empty ");	
			else
				table[i].display();
		}
	}
	public void remove(int element){
		int pos = hash(element);
		table[pos].remove(element);
	}
}
