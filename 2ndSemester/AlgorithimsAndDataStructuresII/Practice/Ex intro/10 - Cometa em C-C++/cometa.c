#include <stdio.h>
#include <stdlib.h>

int getProximoAno(int anoAtual){
  int proximo = 1986;
  do{
    proximo+=76;
  }while (proximo <= anoAtual);
  return proximo;
}
int main(void){
  int anoAtual;
  do{
    scanf(" %i",&anoAtual);
      if(anoAtual != 0)
        printf("%i\n",getProximoAno(anoAtual));
  }while(anoAtual != 0);
  return 0;
}
