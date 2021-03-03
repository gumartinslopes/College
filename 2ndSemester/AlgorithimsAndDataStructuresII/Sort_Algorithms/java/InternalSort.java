import java.util.*;

public class InternalSort{
	protected int[] array;
	protected int n;	// array size
	protected int comparisons, internalArrayMoves;
	protected double beginTime, endTime;

	//constructors
	public InternalSort(){
		array = new int[100];
		n = array.length;
	}

	public InternalSort(int arraySize){
		array = new int[arraySize];
		n = array.length;
	}

	public void swap(int i,int j){
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public void displayArray(){
		System.out.print("[");
		for(int i = 0; i < n;i++){
			System.out.print(array[i]);
			if(i < n - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	//display the first k values
	public void displayArray(int k){
		System.out.print("[");
		for(int i = 0; i < k;i++){
			System.out.print(array[i] + ", ");
		}
		System.out.println("]");
	}

	public boolean isSorted(){
		boolean resp = true;
		for(int i = 0; i < n; i++){
			if(array[i] < array[i -1]){
				i = n;		//finishes the loop
				resp = false;
			}
		}
		return resp;
	}

	public void generateAscendingArray(){
		for(int i = 0; i < n; i++)
			array[i] = i;
	}

	public void generateDescendingArray(){
		for(int i = 0; i < n; i++)
			array[i] = n - i - 1;
	}	
	
	public void generateRandomArray(){
		Random rand = new Random();
		for(int i = 0; i < n; i++){
			array[i] = rand.nextInt()%100;
		}
	}

	//returns current timestamp
	public long now(){
		return new Date().getTime();
	}

	public void sort(){

	}

	public void benchmarkAlgorithm(){
		System.out.println("Total comparisons :" + comparisons);
		System.out.println("Total internal movements: " + internalArrayMoves);
		System.out.println("Sort time: " + (endTime + beginTime) + " milliseconds");
	}
}