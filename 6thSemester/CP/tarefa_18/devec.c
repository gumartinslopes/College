#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

// Output do compilador:
// devec.c:24:20: missed: couldn't vectorize loop
// devec.c:24:20: missed: not vectorized: latch block not empty.
// devec.c:19:11: missed: couldn't vectorize loop
// devec.c:19:11: missed: not vectorized: number of iterations cannot be computed.
// devec.c:12:13: missed: couldn't vectorize loop
// devec.c:12:13: missed: not vectorized: control flow in loop.
// devec.c:12:13: missed: statement clobbers memory: _1 = rand ();
// devec.c:17:32: missed: statement clobbers memory: _3 = rand ();
// devec.c:24:22: missed: statement clobbers memory: _4 = rand ();

int main()
{
   int arr_1[100];
   int arr_2[100];
   int arr_3[100];

   // Existencia de break no código
   for(int i =0; i < 100; i++ ){
    arr_1[i]= arr_2[i] + arr_3[i];
    if(i == rand() % 10)
        break;
   }
    
    // O compilador não vai identificar a quantidade de iterações que o loop faz
    for(int j =0; j< 100; j = rand() % 100){ 
        arr_1[j]= arr_2[j] + arr_3[j];
        if(j == 5)
            break;
    }

   // Acessos feitos de forma não sequenciais no vetor
   for(int k =0; k < rand() % 100; k++){ 
    arr_2[k] = 0; 
    arr_3[k] = 0;
   }
   return 0;
}