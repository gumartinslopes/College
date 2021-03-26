public class SelectionSort extends InternalSort{
	public SelectionSort(){
		super();
	}

	public SelectionSort(int arraySize){
		super(arraySize);
	}

	@Override
	public void sort(){
		beginTime = now();
		for(int i = 0; i < (n - 1); i++){
			int smaller = i;
			for(int j = (i + 1); j < n; j++){
				comparisons++;
				if(array[smaller] > array[j])
					smaller = j;
			}
			if(smaller != i){
				swap(smaller, i);
				internalArrayMoves++;
			}
		}
		endTime = now();
	}

	@Override
	public void partialSort(int k){
		for(int i = 0; i < k; i++){
			int smaller = i;
			for(int j = (i + 1); j < n; j++){
				if(array[smaller] > array[j])
					smaller = j;
			}
				swap(smaller, i);
		}
	}
}