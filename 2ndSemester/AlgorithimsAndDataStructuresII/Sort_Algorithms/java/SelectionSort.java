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
		int comp = 0, mov = 0;
		for(int i = 0; i < (n - 1); i++){
			int smaller = i;
			for(int j = (i + 1); j < n; j++){
				comp++;
				if(array[smaller] > array[j])
					smaller = j;
			}
			if(smaller != i){
				swap(smaller, i);
				mov++;
			}
		}
		endTime = now();
		comparisons = comp;
		internalArrayMoves = mov;
	}
}