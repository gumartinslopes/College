public class Main{
	public static void main(String[] args){
		int n = (args.length < 1) ? 1000 : Integer.parseInt(args[0]);	//specification of the array size
		InternalSort algorithm;

		//algorithm = new SelectionSort(10);
		algorithm = new InsertionSort(10);

		
		algorithm.generateRandomArray();
		algorithm.displayArray();
		algorithm.sort();
		algorithm.benchmarkAlgorithm();
		algorithm.displayArray();
	}
}