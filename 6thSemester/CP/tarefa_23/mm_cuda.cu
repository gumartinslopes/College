#include <stdio.h>
#include <stdlib.h>
/*
 - Tempos
    - GPU:7.412 segundos
    - CPU Sequencial: 2 min 1.036 segundos
    - CPU Paralela: 56 segundos
*/
/*Código PARA GPU - CUDA*/
__global__ void mm(double *a, double *b, double *c, int width)
{
    int i = blockIdx.y * blockDim.y + threadIdx.y;
    int j = blockIdx.x * blockDim.x + threadIdx.x;

    if (i < width && j < width) {
        double sum = 0;
        for (int k = 0; k < width; k++)
        {
            double x = a[i * width + k];
            double y = b[k * width + j];
            sum += x * y;
        }
        c[i * width + j] = sum;
    }
}

int main()
{
    int width = 2000;
    double *a, *b, *c;
    double *d_a, *d_b, *d_c;

    int size = width * width * sizeof(double);

    a = (double *)malloc(size);
    b = (double *)malloc(size);
    c = (double *)malloc(size);

    for (int i = 0; i < width; i++)
    {
        for (int j = 0; j < width; j++)
        {
            a[i * width + j] = i;
            b[i * width + j] = j;
            c[i * width + j] = 0;
        }
    }

    cudaMalloc((void **)&d_a, size);
    cudaMalloc((void **)&d_b, size);
    cudaMalloc((void **)&d_c, size);

    cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);
    cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);

    dim3 threadsPerBlock(32, 32);
    dim3 numBlocks((width + threadsPerBlock.x - 1) / threadsPerBlock.x, (width + threadsPerBlock.y - 1) / threadsPerBlock.y);

    mm<<<numBlocks, threadsPerBlock>>>(d_a, d_b, d_c, width);

    cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);

    for(int i = 0; i < width; i++) {
        for(int j = 0; j < width; j++) {
            printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
        }
    }

    //desalocação de memória
    free(a);
    free(b);
    free(c);

    cudaFree(d_a);
    cudaFree(d_b);
    cudaFree(d_c);

    return 0;
}
