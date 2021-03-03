#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool checkPalindromo(char* palavra){
  bool resp = true;
  int tamanho = strlen(palavra);
  int i = 0;

  do{
    if(palavra[i] != palavra[tamanho - i -1]){
      resp = false;
    }
    i++;
  }
  while(i < (tamanho/2) && resp!= false);
  return resp;
}

int main(){
  char entrada[100];
  do{
    scanf(" %[^\n]s",entrada);
    if(checkPalindromo(entrada) == true){
      printf("SIM\n");
    }
    else{
      printf("NAO\n");
    }
  }while(strcmp(entrada, "FIM")!=0);
  return 0;
}
