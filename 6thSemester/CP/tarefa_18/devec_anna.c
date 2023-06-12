//devec.c:11:13: note: not vectorized: control flow in loop.
//devec.c:17:4: note: not vectorized: latch block not empty
//devec.c:25:11: note: not vectorized: number of iterations cannot be computed.
//devec.c:34:17: note: not vectorized: multiple exits.
//devec.c:50:43: note: not vectorized: no grouped stores in basic block.
//devec.c:52:14: note: not vectorized: no vectype for stmt: vect__10.14_74 = MEM[(int *)vectp_A.12_72];


#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

int main()
{
   int vet1[2048], vet2[2048], vet3[2048];

   for(int i =0; i < 2048; i++ ){
    vet1[i]= vet2[i] + vet3[i];
    if(i == rand() % 10)
        break;
   }

   for(int i =0; i < rand() % 2048; i++ ){ //acessos nao sequenciais ao vetor
    vet2[i] = 0; 
    vet3[i] = 0;
   }

    for(int i =0; i< 2048; i = rand() % 2048){ // com i recebendo essa sentenÃ§a o compilador nao vai conseguir identificar quantas interacoes existem no loop
        vet1[i]= vet2[i] + vet3[i];
        if(i == 5)
            break;
    }

    int teste = rand();
    for(int i = 0; i <2048; i = teste){
        vet1[i]= vet2[i] + vet3[i];
        teste = rand() % i;
    }


    code_501_example1(vet1);


   return 0;
}

int bound();
void code_501_example1(int *A)
{
    for (int i=0; i<bound(); ++i)
    {
        A[i] = A[i] + 1;
    }
    for (int i=0, imax = bound(); i<imax; ++i)
    {
        A[i] = A[i] + 1;
    }
}
