public class BufferedBubbleSort extends InternalSort{
	public BufferedBubbleSort(){
		super();
	}

	public BufferedBubbleSort(int arrayLength){
		super(arrayLength);
	}

	@Override
	public void sort(){
		beginTime = now();
		boolean swapped = true;//sorted array flag
		for(int rep = n - 1; rep > 1; rep--){
			for(int b = 0; b < rep && swapped; b++){
				if(array[b] > array[b +1]){
					int aux = array[b];
					array[b] = array[b + 1];
					array[b + 1] = aux;
					swapped = true;
					internalArrayMoves += 3;
				}
				comparisons++;
			}
			endTime = now();
		}
	}
}