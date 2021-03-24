public class BubbleSort extends InternalSort{
	public BubbleSort(){
		super();
	}

	public BubbleSort(int arrayLenght){
		super(arrayLenght);
	}

	@Override
	public void sort(){
		beginTime = now();
		for(int rep = 0; rep < n - 1; rep ++){
			for(int b = 0; b < n - 1; b ++){
				if(array[b] > array[b + 1]){
					int aux = array[b];
					array[b] = array[b + 1];
					array[b + 1] = aux;
					internalArrayMoves += 3;
				}
				comparisons++;
			}
		}
		endTime = now();
	}
}