public class RecursiveSelectionSort extends InternalSort{
	public RecursiveSelectionSort(){
		super();
	}

	public RecursiveSelectionSort(int arraySize){
		super(arraySize);
	}

	@Override
	public void sort(){
		beginTime = now();
		recursiveSelection(0);
		endTime = now();
	}

	private void recursiveSelection(int i){
		if(i < n - 1){
			int smaller = i;
			for(int j = (i + 1); j < n; j++){
				comparisons++;
				if(array[smaller] > array[j])
					smaller = j;
			}
			comparisons++;
			swap(smaller, i);
			internalArrayMoves += 3;
			recursiveSelection(i + 1);
		}
	}
}