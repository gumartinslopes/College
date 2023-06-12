#include <stdio.h>
#include <stdlib.h>

/*
  Tempo Sequencial:  1 min e 59 segundos
  Tempo Paralelo CPU: 56 segundos
  Tempo Paralelo GPU: 18 segundos
  Output gerado:
      ==16579== NVPROF is profiling process 16579, command: ./mm_paralelo_gpu
      ==16579== Some kernel(s) will be replayed on device 0 in order to collect all events/metrics.
      ==16579== Replaying kernel "mm$_omp_fn$0" (done)
      ==16579== Profiling application: ./mm_paralelo_gpu
      ==16579== Profiling result:
      ==16579== Event result:
      Invocations                                Event Name         Min         Max         Avg       Total
      Device "GeForce GT 1030 (0)"
          Kernel: mm$_omp_fn$0
                1                            warps_launched          72          72          72          72

      ==16579== Metric result:
      Invocations                               Metric Name                        Metric Description         Min         Max         Avg
      Device "GeForce GT 1030 (0)"
          Kernel: mm$_omp_fn$0
                1                 warp_execution_efficiency                 Warp Execution Efficiency     100.00%     100.00%     100.00%
*/

void mm(double* a, double* b, double* c, int width) 
{
    #pragma omp target map(tofrom:a,b,c, width) 
    #pragma omp teams distribute parallel for simd //reduction(+:sum)	
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

  mm(a,b,c,width);
  //  for(int i = 0; i < width; i++) {
  //  for(int j = 0; j < width; j++) {
  //    printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
  //  }
  // }

}

