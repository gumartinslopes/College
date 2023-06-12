#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <time.h>
 
void mm_paralelo(double* a, double* b, double* c, int width) 
{
  #pragma omp parallel for shared(a,b,c)
  for (int i = 0; i < width; i++) {
    for (int j = 0; j < width; j++) {
      double sum = 0;
      #pragma omp parallel for reduction(+:sum)
      for (int k = 0; k < width; k++) {
        double x = a[i * width + k];
        double y = b[k * width + j];
        sum += x * y;
      }
      c[i * width + j] = sum;
    }
  }
}

void mm(double* a, double* b, double* c, int width) 
{
 for (int i = 0; i < width; i++) {
    for (int j = 0; j < width; j++) {
      double sum = 0;
      for (int k = 0; k < width; k++) {
	    double x = a[i * width + k];
	    double y = b[k * width + j];
	    sum += x * y;
      }
      c[i * width + j] = sum;
    }
  }
}

int main()
{
  int width = 2000;
  double *a = (double*) malloc (width * width * sizeof(double));
  double *b = (double*) malloc (width * width * sizeof(double));
  double *c = (double*) malloc (width * width * sizeof(double));
 
  for(int i = 0; i < width; i++) {
    for(int j = 0; j < width; j++) {
      a[i*width+j] = i;
      b[i*width+j] = j;
      c[i*width+j] = 0;
    }
  }

  double start_time = omp_get_wtime();
  mm(a,b,c,width);
  double end_time = omp_get_wtime();

  double start_time_paralelo = omp_get_wtime();
//   clock_t begin = clock();
  mm_paralelo(a,b,c,width);
  double end_time_paralelo = omp_get_wtime();

  // for(int i = 0; i < width; i++) {
  //  for(int j = 0; j < width; j++) {
  //    printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
  //  }
  // }
//   double time_spent = 0.0;
//   time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
//   printf("Execution time = %f seconds\n", time_spent);
  printf("Tempo de execucao sequencial = %f seconds\n", end_time - start_time);
  printf("Tempo de execucao paralelo = %f seconds\n", end_time_paralelo - start_time_paralelo);

  free(a);
  free(b);
  free(c);

  return 0;
}