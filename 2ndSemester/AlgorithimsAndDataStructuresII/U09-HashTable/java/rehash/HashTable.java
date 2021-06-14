public class HashTable{
	private int maxLength;
	private int [] table;
	private final int NULL = -1;

	public HashTable(){
		this(13);
	}

	public HashTable(int maxLength){
		this.maxLength = maxLength;
		this.table = new int[maxLength];
		for(int i = 0; i < maxLength; i++)
			table[i] = NULL;
	}

	public int hash(int element){
		return element % maxLength;
	}

	public int rehash(int element){
		return ++element % maxLength;
	}

	public void insert(int element){
		if(element != NULL){
			int pos = hash(element);
			if(table[pos] == NULL){
				table[pos] = element;
			}
			else{
				pos = rehash(element);
				if(table[pos] == NULL)
					table[pos] = element;
				else
					System.out.println("Sorry we are out of rehashes for this value :(");
			}
		}
	}

	public boolean search(int element){
		boolean result = false;
		int pos = hash(element);

		if(table[pos] == element || table[rehash(element)] == element)
				result = true;
		else{
			for(int i = 0; i < maxLength; i++){
				if(table[i] == element){
					result = true;
					i = maxLength;	
				}

			}
		}
		return result;
	}

	public void remove(int element){
		boolean found = false;
		if(table[hash(element)] == element || table[rehash(element)] == element){
			found = true;
			table[hash(element)] = NULL;
		}
		else {
			for(int i = 0; i < maxLength; i++){
				if(table[i] == element){
					found = true;
					table[i] = NULL;
					i = maxLength;
				}
			}
		}

		System.out.println("The element " + element + ((found)?" was removed": "does not exist on your table"));
	}
	public void display(){
		System.out.print("[");
		for(int i = 0; i < maxLength; i++)
			System.out.print(((table[i] == NULL) ? "empty" : table[i]) + ((i < table.length - 1)?", ": "]"));
	}


}
