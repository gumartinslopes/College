#include <time.h>
#include <stdio.h>
#include <mpi.h>
#include <stdlib.h>

#define N 10
#define MAX 4
#define NUMBER 3

int get_maior(int* buffer, int bottom, int top)
{
    int result = 0x80000000; // valor muito baixo
    for(int i = bottom; i < top; i++)
    {
      if(result < buffer[i])
      {
        result = buffer[i];
      }
    }
    return result;
}

void main(int argc, char *argv[])
{
  int p, rank, maior_parcial, maior_final, numProcs;
  int buffer[N];
  MPI_Status status;

  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  MPI_Comm_size(MPI_COMM_WORLD, &numProcs);

  if (rank == 0)
  {
    // preencher o buffer com N valores inteiros aleatórios
    for (int i = 0; i < N; i++)
      buffer[i] = rand() % 10;
    printf("Buffer\n");
    for(int i = 0; i < N; i++)
      printf(" - %d \n", buffer[i]);
  }

  // distribuir o vetor para todos os outros processos
  MPI_Bcast(buffer, N, MPI_INT, 0, MPI_COMM_WORLD);

  // processar o maior dos valores dentro do seu intervalo
  int top, bottom;
  if(rank == 0){
    bottom = 0;
    top = 3;
  }
  else if (rank == 1){
    bottom = 3;
    top = 7;
  }
  else{
    bottom = 7;
    top = 10;
  }

  maior_parcial = get_maior(buffer, bottom, top);
  // reduzir os maiores no maior, enviando o resultado para o processo com rank = 0
  MPI_Reduce(&maior_parcial, &maior_final, 1, MPI_INT, MPI_MAX,0, MPI_COMM_WORLD);

  if (rank == 0)
  {
    printf("MAIOR: %d", maior_final);
  }

  MPI_Finalize();
}