#include <stdio.h>
#include <mpi.h>

int main (int argc, char *argv[])
{
  int rank, size;

    // inicializa o mpi
    MPI_Init (&argc, &argv);
    //identifica o processo
    MPI_Comm_rank (MPI_COMM_WORLD, &rank);
    //retorna o número de processos, no caso o número de máquinas existenstes
    MPI_Comm_size (MPI_COMM_WORLD, &size);
    printf( "Hello world from process %d of %d\n", rank, size );
    //finaliza o programa
    MPI_Finalize();
    return 0;
}