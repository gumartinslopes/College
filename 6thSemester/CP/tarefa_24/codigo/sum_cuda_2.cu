#include <stdio.h>
#include <stdlib.h>
#include <time.h>  

__global__ void sum_cuda(double* a, double *s, int width) {
  int t = threadIdx.x;
  int b = blockIdx.x*blockDim.x;
  double o[1024];  

  if(b+t < width)
    o[t] = a[b+t];

  __syncthreads();
  
  int i;
  for(i = blockDim.x/2; i > 0; i /= 2) {
    if(t < i && b+t+i < width)
      o[t] += o[t+i];
    
    __syncthreads();
  }

  if(t == 0)
    s[blockIdx.x] = o[0];  
} 

int main()
{
  int width = 40000000;
  int size = width * sizeof(double);

  int block_size = 1024;
  int num_blocks = (width-1)/block_size+1;
  int s_size = (num_blocks * sizeof(double));  
 
  double *a = (double*) malloc (size);
  double *s = (double*) malloc (s_size);

  for(int i = 0; i < width; i++)
    a[i] = i;

  double *d_a, *d_s;

  // alocação e cópia dos dados
  cudaMalloc((void **) &d_a, size);
  cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);

  cudaMalloc((void **) &d_s, s_size);

  // definição do número de blocos e threads
  dim3 dimGrid(num_blocks,1,1);
  dim3 dimBlock(block_size,1,1);

  // para armazenar o tempo de execução do código
  double time_spent_sum = 0.0;
  double time_spent_copy = 0.0;

  clock_t begin_sum = clock();
  // chamada do kernel
  sum_cuda<<<dimGrid,dimBlock>>>(d_a, d_s, width);
  clock_t end_sum = clock();
  
  // cópia dos resultados para o host
  clock_t begin_copy = clock();
  cudaMemcpy(s, d_s, s_size, cudaMemcpyDeviceToHost);
  clock_t end_copy = clock();
  // soma das reduções parciais
  for(int i = 1; i < num_blocks; i++) 
    s[0] += s[i];

  printf("\nSum = %f\n",s[0]);
  
  time_spent_sum += (double)(end_sum - begin_sum) / CLOCKS_PER_SEC;
  time_spent_copy += (double)(end_copy - begin_copy) / CLOCKS_PER_SEC;
  printf("\n\nThe elapsed on sum time is %f seconds", time_spent_sum);
  printf("\n\nThe elapsed on copy time is %f seconds\n", time_spent_copy);
  cudaFree(d_a);
  cudaFree(d_s);
}
