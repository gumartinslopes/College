/*
* Adapted from: http://w...content-available-to-author-only...s.org/sieve-of-eratosthenes
*/
/*
Testes Realizados
    Teste 1:
        Quantidade de nucleos: 4
        Quantidade de threads: não setado
        Tempo sequencial: 4.777048 segundos
        Tempo paralelo: 4.646059 segundos
        N:100000000
    
    Teste 2:
        Quantidade de nucleos: 4
        Quantidade de threads: 2
        Tempo sequencial: 4.07183 segundos
        Tempo paralelo: 4.070716 segundos
        N:100000000
   
    Teste 3:
        Quantidade de nucleos: 4
        Quantidade de threads: 4
        Tempo sequencial: 4.477240 segundos
        Tempo paralelo: 4.63989 segundos
        N:100000000
*/

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <omp.h>
#include <time.h>

int sieveOfEratosthenes(int n){
   // Create a boolean array "prime[0..n]" and initialize
   // all entries it as true. A value in prime[i] will
   // finally be false if i is Not a prime, else true.
   int primes = 0; 
   bool *prime = (bool*) malloc((n+1)*sizeof(bool));
   int sqrt_n = sqrt(n);
 
   memset(prime, true,(n+1)*sizeof(bool));
 
   for (int p=2; p <= sqrt_n; p++)
   {
       if (prime[p] == true)
       {
           // Update all multiples of p
           for (int i=p*2; i<=n; i += p)
           prime[i] = false;
        }
    }
 
    // count prime numbers
    #pragma omp parallel for reduction(+:primes)
    for (int p=2; p<=n; p++)
       if (prime[p])
         primes++;
    return(primes);
} 


int main()
{
    omp_set_num_threads(2);
    int n = 100000000;
    printf("%d\n",sieveOfEratosthenes(n));
    return 0;
} 
