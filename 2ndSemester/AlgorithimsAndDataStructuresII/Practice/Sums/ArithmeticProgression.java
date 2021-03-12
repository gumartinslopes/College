public class ArithmeticProgression{
	/*
	  a -> termo inicial
	  b-> razao
	  n->limite superior
	*/
	
	public static double sumAP(double a, double b, int n){
		double sum = 0;
		for(int i = 0; i <= n; i++){
			sum += a + (b * i);
			System.out.println("Current value  = " +  (a +(b * i)));
		}

		return sum;
	}
	public static void main(String[] args){
		System.out.println("Sum = " + sumAP(1, 3, 4));
	}
}