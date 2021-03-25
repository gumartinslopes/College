public class Main{
	public static void main(String[] args){
		int n = (args.length < 1) ? 1000 : Integer.parseInt(args[0]);	//specification of the array size
		InternalSort algorithm;

		//algorithm = new SelectionSort(100000);
		//algorithm = new RecursiveSelectionSort(10);
		//algorithm = new InsertionSort(100000);
		//algorithm = new ShellSort(100000);
		//algorithm = new MergeSort(100000);
		//algorithm = new QuickSort(10);
		//algorithm = new BubbleSort(100000);
		//algorithm = new BufferedBubbleSort(100000);
		//algorithm = new CountingSort(100);
		algorithm = new HeapSort(100);

		algorithm.generateRandomArray();
		//algorithm.displayArray();
		algorithm.sort();
		algorithm.isSorted();
		algorithm.benchmarkAlgorithm();
		//algorithm.displayArray();
	}
}