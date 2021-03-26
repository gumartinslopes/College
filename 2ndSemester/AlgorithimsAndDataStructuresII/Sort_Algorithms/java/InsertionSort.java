public class InsertionSort extends InternalSort{
	public InsertionSort(){
		super();
	}

	public InsertionSort(int arraySize){
		super(arraySize);
	}

	@Override
	public void sort(){
		beginTime = now();
		for(int i = 1; i < n; i++){
			int aux = array[i];
			int j = i - 1;
			while((j >= 0) && (array[j] > aux)){
					array[j + 1] = array[j];
					j--;
					internalArrayMoves++;
					comparisons++;
			}
			array[j + 1] = aux;
			internalArrayMoves++;
		}
		endTime = now();	
	}

	@Override
	public void partialSort(int k){
		beginTime = now();
		for(int i = 1; i < n; i++){
			int aux = array[i];
			int j = (i < k) ? i - 1 : k - 1;
			while(j >= 0 && array[j] > aux){
				array[j + 1] = array[j];
				j--;
				internalArrayMoves++;
				comparisons++;
			}
			array[j + 1] = aux;
			internalArrayMoves++;
		}
		endTime = now();	
	}
}