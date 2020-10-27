class List{
	int list[];
	int size;
	
	//constructors
	List(){
		this(6);
	}
	List(int maxSize){
		list = new int[maxSize];
		size = 0;
	}

	//insertion methods
	public void insertAtBeginning(int x) throws Exception{
		if(size >= list.length){
			throw new Exception("List overflow");
		}

		for(int i = size; i > 0; i--){
			list[i] = list[i - 1];
		}

		list[0] = x;
		size++;
	}
	//we move every element after the position
	public void insert(int x, int position)throws Exception{
		if(size >= list.length || position < 0 || position > size){
			throw new Exception("Error at insertion");
		}

		for(int i = size; i > position; i--){
			list[i] = list[i - 1];	
		}

		list[position] = x;
		size++;
	}
	//eazy peasy lemon squeezy
	public void insertAtEnding(int x)throws Exception{
		if(size >= list.length){
			throw new Exception("List overflow");
		}
		list[size] = x;
		size++;
	}

	//removal methods
	public int removeAtBeginning()throws Exception{
		int removed;
		if(size == 0){
			throw new Exception("Empty list");
		}
		removed = list[0];
		size--;

		for(int i = 0; i < size; i++){
			list[i] = list[i + 1];
		}
		
		return removed;
	}
	public int remove(int pos)throws Exception{
		int removed;
		if(size == 0 || pos > size || pos < 0){
			throw new Exception("Error at removal");
		}

		removed = list[pos];
		size--;

		for(int i = pos; i < size; i++){
			list[i] = list[i + 1];
		}
		return removed;
	}
	//eazy peazy lemoneazy squeazy
	public int removeAtEnding()throws Exception{
		if(size == 0){
			throw new Exception("Empty list");
		}
		return list[--size];
	}
	//other methods
	public void show(){
		System.out.println("\tYour list");
		for(int i = 0;i < size; i++){
			System.out.println(i + ". " + list[i]);
		}
	}

}
