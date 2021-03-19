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
		int comp = 0, mov = 0;

		for(int i = 1; i < n; i++){
			int aux = array[i];
			int j = i - 1;
			while((j >= 0) && (array[j] > aux)){
				if(array[j] > aux){
					array[j + 1] = array[j];
					j--;
				}
			}
			array[j + 1] = aux;
		}


		endTime = now();
		comparisons = comp;
		internalArrayMoves = mov;
	}
}