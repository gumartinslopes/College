public class MergeSort extends InternalSort{
	public MergeSort(){
		super();
	}

	public MergeSort(int arraySize){
		super(arraySize);
	}

	@Override
	public void sort(){
		beginTime = now();
		mergesort(0, n - 1);
		endTime = now();
	}

	private void mergesort(int left, int right){
		if(left < right){
			int mid = (left + right)/ 2;
			mergesort(left,mid);
			mergesort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private void merge(int left, int mid, int right){
		//subarray length definition
		int nLeft = (mid + 1) - left;
		int nRight = right - mid;

		int[] arrayLeft = new int[nLeft + 1];
		int[] arrayRight = new int[nRight + 1];

		//final sentinel 
		arrayLeft[nLeft] = arrayRight[nRight] = 0x7FFFFFFF;

		int leftIndex, rightIndex, index;
		
		//inicializing first subarray
		for(leftIndex = 0; leftIndex < nLeft; leftIndex++){
			arrayLeft[leftIndex] = array[left + leftIndex]; 
			comparisons++;
		}

		//inicializing second subarray
		for(rightIndex = 0; rightIndex < nRight; rightIndex++){
			arrayRight[rightIndex] = array[(mid + 1) + rightIndex]; 
			comparisons++;
		}

		for(rightIndex = leftIndex = 0, index = left; index <= right; index++){
			array[index] = (arrayLeft[leftIndex] <= arrayRight[rightIndex]) ? arrayLeft[leftIndex++] : arrayRight[rightIndex++];
			comparisons++;
			internalArrayMoves++;
		}
	}
}