public class CountingSort extends InternalSort{
	public CountingSort(){
		super();
	}

	public CountingSort(int arrayLength){
		super(arrayLength);
	}

	@Override
	public void sort(){
		int[] count = new int[getBigger() + 1];
		int[] sorted = new int[n];
		//inicializing the counting array
		for(int i = 0; i < count.length; count[i] = 0, i++);
		//populating with the number of elements that are equals to i
		for(int i = 0; i < n; count[array[i]]++,i++);
		//populating with the number of elements that are smaller or equals then i
		for(int i = 1; i < count.length; count[i] += count[i - 1], i++);
		//sorting
		for(int i = (n - 1); i >= 0; sorted[count[array[i]] -1] = array[i], count[array[i]]--, i--);
		
		copyArray(sorted);
	}
}