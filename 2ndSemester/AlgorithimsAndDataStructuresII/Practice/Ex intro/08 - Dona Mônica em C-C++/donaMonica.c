#include <stdlib.h>
#include <stdio.h>

int getIdadeFilho3(int idadeMae, int idadeFilho1, int idadeFilho2){
  return(idadeMae - (idadeFilho1 + idadeFilho2));
}

//retorna a maior idade dentre os filhos
int getMaior(int idade1,int idade2, int idade3){
  int maiorIdade;
  if(idade1 > idade2 && idade1 > idade3)
    maiorIdade = idade1;
  else if(idade2 > idade1 && idade2 > idade3)
    maiorIdade = idade2;
  else
    maiorIdade = idade3;
  return maiorIdade;
}
//idades iguais nao importam para a resolucao da questao

int main(void){
  int idadeMae, idadeFilho1, idadeFilho2, idadeFilho3;
  do{
      scanf(" %i", &idadeMae);
      if(idadeMae != 0){
        scanf(" %i", &idadeFilho1);
        scanf(" %i", &idadeFilho2);
        idadeFilho3 = getIdadeFilho3(idadeMae,idadeFilho1,idadeFilho2);
        printf("%i\n",getMaior(idadeFilho1, idadeFilho2, idadeFilho3));
      }
  }while(idadeMae != 0);
  return 0;
}
