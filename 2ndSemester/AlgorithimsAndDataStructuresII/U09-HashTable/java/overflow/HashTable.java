public class HashTable{
	private int []table;
	private int tableLength, overflowLength;
	private int overflowNum;
	private final int NILL = -1;
	
	public HashTable(){
		this(7);
	}	
	public HashTable(int maxLength){
		this.tableLength = maxLength;
		this.overflowNum = 0;
		this.overflowLength = (int)Math.ceil(maxLength * 30 / 100);
		this.table = new int[tableLength + overflowLength];//the overflow area is set to 3 in this implementation
		for(int i = 0; i < table.length; i++){
			table[i] = NILL;
		}
	}

	public void insert(int x) throws Exception{
		int i = hash(x);
		if(x == NILL)
			throw new Exception("Error");
		else if(table[i] == NILL)
			table[i] = x;
		else if(overflowNum < overflowLength){
			table[tableLength + overflowNum] = x;
			overflowNum++;
		}
		else
			throw new Exception("Error");
	}

	public int hash(int element){
		return element % tableLength;			
	}

	public void display(){
		System.out.print("[");
		for(int i = 0; i < table.length; i++)
			System.out.print(((table[i] == NILL) ? "empty" : table[i]) + ((i < table.length - 1)?", ": "]"));
	}

	public boolean search(int element){
		boolean result = false;
		int pos = hash(element);

		if(table[pos] == element)
				result = true;
		else{
			for(int i = 0; i < overflowLength; i++){
				if(table[i] == element){
					result = true;
					i = overflowLength;	
				}

			}
		}
		return result;
	}

	public void remove(int element){
		boolean found = false;
		if(table[hash(element)] == element){
			found = true;
			table[hash(element)] = NILL;
		}	
		else {
			for(int i = 0; i < overflowLength; i++){
				if(table[i] == element){
					found = true;
					table[i] = NILL;
					i = overflowLength;
				}
			}
		}

		System.out.println("The element " + element + ((found)?" was removed": "does not exist on your table"));
	}

}
