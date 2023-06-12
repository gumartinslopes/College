#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#define TAG 1

void main(int argc, char *argv[])
{
    int i, rank, val, numProcs;
    MPI_Status status;
    //inicializa o mpi
    MPI_Init(&argc, &argv);
    //identifica o processo
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    //retorna o número de processos, no caso o número de máquinas existenstes
    MPI_Comm_size(MPI_COMM_WORLD, &numProcs);
    
    if (rank == 0)
    {
        val = 51;
        // enviar o valor para todos os processos
        for(int i = 1; i < numProcs;i++){
            MPI_Send(&val, 1, MPI_DOUBLE, i, TAG, MPI_COMM_WORLD);
            printf("Process %d sends a message to %d\n", rank, i);
        }
    }
    else
    {
        MPI_Recv(&val, 1, MPI_DOUBLE, 0, TAG, MPI_COMM_WORLD, &status);
        // receber o valor enviado
        printf("Process %d receives a message from %d with value %d\n", rank, 0, val);
    }
    //finaliza o programa
    MPI_Finalize();
}
