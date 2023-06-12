#include <stdio.h>
#include <stdlib.h>
#include <time.h>  

double sum(double* a, int width) {
    double sum = 0;
    for(int i = 0; i < width; i ++)
        sum += a[i];
    return sum;
}

void init(double *a, int width){
  for(int i = 0; i < width; i ++)
        a[i] = i;
}

int main()
{
  int width = 40000000;
  int size = width * sizeof(double);
  double *a = (double*) malloc (size);
  init(a, width);
  printf("\nSum = %f\n",sum(a,width));
}