/*
Durante os testes o grupo concluiu que o melhor tipo de escalonamento é o guided, visto que 
obteve maior diferença de tempo entre os dois códigos.

### Configurações
 - Processador: Intel(R) Core(TM) i7-8550U CPU @ 1.80GHz   1.99 GHz
 - Ram: 8gb
 - SO: Windos 11

### Silly Sort paralelo:
 - Teste1 (Sem schedule configurado): 1.315s -> 756
 - Teste2 (Schedule Dynamic com parâmetro 1000): 1.080s -> 1.061
 - Teste3 (Schedule Guided com parâmetro 1000):975s -> 1.181

### Silly Sort sequencial:
 - Teste1 (Sem schedule configurado):2.080s
 - Teste2 (Schedule Dynamic com parâmetro 1000): 2.141s
 - Teste3 (Schedule Guided com parâmetro 1000):2.156s
*/

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
int main() 
{
   omp_set_num_threads(2);
   int i, j, n = 30000; 
 
   // Allocate input, output and position arrays
   int *in = (int*) calloc(n, sizeof(int));
   int *pos = (int*) calloc(n, sizeof(int));  
   int *out = (int*) calloc(n, sizeof(int));   
 
   // Initialize input array in the reverse order
   for(i=0; i < n; i++)
      in[i] = n-i;  
 
   // Print input array
   //   for(i=0; i < n; i++) 
   //      printf("%d ",in[i]);
 
   // Silly sort (you have to make this code parallel)
   for(i=0; i < n; i++) 
      #pragma omp parallel for reduction(+:pos[i]) schedule(guided, 1000)
      for(j=0; j < n; j++)
	     if(in[i] > in[j]) 
            // possível área de conflito
            pos[i]++;
 
   // Move elements to final position
   for(i=0; i < n; i++) 
      out[pos[i]] = in[i];
 
   // print output array
   //   for(i=0; i < n; i++) 
   //      printf("%d ",out[i]);
 
   // Check if answer is correct
   for(i=0; i < n; i++)
      if(i+1 != out[i]) 
      {
         printf("test failed\n");
         exit(0);
      }
 
   printf("test passed\n"); 
}  
