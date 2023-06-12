//Resultados:

/*
Questão 1
    - Tempo da execução do código: 1.822 segundos

Questão 2
    - Tempo da execução da função de soma: 0.112722 segundos
    - Tempo de exeucção da função de copy: 0.000822 segundos
Questão 3
    - Tempo da execução do código: 0.56 segundos

Questão 4 
    - Tempo da execução do código: 0.453 segundos
    
Questão 5
    - Sem a memória compartilhada, o grupo notou que além dos resultados estarem diferentes, 
       o tempo de execução da soma aumentou mas o da cópia diminuiu.
    - Tempo da execução do função de soma: 0.899863 segundos
    - Tempo da execução da função de copy:  0.000768 segundos
*/


//Códigos:
// --------------------------------------Questão 01 ------------------------------------------
/*
#include <stdio.h>
#include <stdlib.h>
#include <time.h>  

__global__ void sum_cuda(double* a, double *s, int width) {
  int t = threadIdx.x;
  int b = blockIdx.x*blockDim.x;

  __shared__ double o[1024];  

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

*/
// ------------------------------------------------------------------------------------------


// --------------------------------------Questão 02 ------------------------------------------
/*
*/
// ------------------------------------------------------------------------------------------


// --------------------------------------Questão 03 ------------------------------------------
/*
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
*/
// ------------------------------------------------------------------------------------------

// --------------------------------------Questão 04 ------------------------------------------
/*
#include <stdio.h>
#include <stdlib.h>
#include <time.h>  

double sum(double* a, int width) {
    double sum = 0;
    #pragma omp parallel for reduction(+:sum)
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
*/
// ------------------------------------------------------------------------------------------

// --------------------------------------Questão 05 / 06 ------------------------------------------
/*
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

*/
// ------------------------------------------------------------------------------------------
