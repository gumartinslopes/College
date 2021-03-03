#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool checkFim(char entrada[]){
  return (entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M');  
}
bool checkPalindromoRec(char entrada[], int i, int tam){
  bool resp = true;
  if(entrada[i] != entrada[tam - 1 -i]){
    resp = false;
  }
  else if(i < tam - 1){
    resp = checkPalindromoRec(entrada, i + 1, tam);
  }
  return resp;
}

int main (void){
  char entrada[1000];
  char entrada2[1000];
  do{
    scanf(" %[^\n]%*c", entrada);
    if(!checkFim(entrada)){
      if(checkPalindromoRec(entrada,0, strlen(entrada)))
        printf("SIM\n");
      else
        printf("NAO\n");
    }
  }while(!checkFim(entrada));
  return 0;
}
