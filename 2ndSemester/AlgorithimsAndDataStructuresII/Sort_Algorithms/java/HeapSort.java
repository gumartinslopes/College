import java.util.*;
public class HeapSort extends InternalSort{
	public HeapSort(){
		super();
	}

	public HeapSort(int arraySize){
		super(arraySize);
	}

	@Override
	public void sort(){
		beginTime = now();
		//building the heap
		for(int size = 2; size <= n - 1; size++){
			build(size);
		}

		//sorting
		int size = n - 1;
		while(size > 1){
			swap(1, size--);
			rebuild(size);
		}
		endTime = now();
	}

	private void build(int size){
		for(int i = size; (i > 1) && (array[i] > array[i/2]); i /= 2){
			swap(i, i/2);
		}
	}

	private void rebuild(int size){
		int i = 1;
		while(i <= (size/2)){
			int child = getBiggestChild(i, size);
			if(array[i] < array[child]){
				comparisons++;
				swap(i, child);
				i = child;
				internalArrayMoves += 3;
			}
			else{
				i = size;	//break
			}
		}
	}

	private int getBiggestChild(int i, int size){
		int child;
		comparisons++;
		if(2 * i == size || array[2 * i] > array[2 * i + 1])
			child = 2 * i;
		else
			child = 2 * i + 1;
		return child;
	}

	@Override
	public void displayArray(){
		System.out.print("[");
		for(int i = 1; i < n;i++){
			System.out.print(array[i]);
			if(i < n - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	@Override
	public void generateAscendingArray(){
		array[0] = 0;
		for(int i = 1; i < n; i++)
			array[i] = i;
	}

	@Override
	public void generateDescendingArray(){
		array[0] = 0;
		for(int i = 1; i < n; i++)
			array[i] = n - i - 1;
	}	
	
	@Override
	public void generateRandomArray(){
		Random rand = new Random();
		array[0] = 0;
		for(int i = 1; i < n; i++){
			array[i] = Math.abs(rand.nextInt() % 100);
		}
	}
}