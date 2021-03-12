#include <stdio.h>
/*
	a-> Termo inicial
	b-> razao
	n-> limite superior
*/
double sumPA(double a, double b, int n){
	double sum = 0;
	for(int i = 0; i <= n; i++){
		sum += a + (b * i);
		printf("\nCurrent value = %g",a + (b * i));
	}
	return sum;
}

int main(){
	printf("Sum = %g\n", sumPA(1,3,4));
	return 0;
}
