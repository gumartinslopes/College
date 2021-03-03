#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

//funcao que resolve o problema
bool checkPalindromo(char entrada[]){
  bool resultado = true;
  int tamanho = strlen(entrada);
  int i = 0;
  do{
    if(entrada[i] != entrada[tamanho - 1 -i]){
      resultado = false;
    }
    i++;
  }while(i < tamanho/2 && resultado != false);
  return resultado;
}



//funcao que verifica o fim do loop 
bool checkFim(char s[]){
  return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

//funcao principal
int main(void){
  char entrada[1000];
  bool fimPrograma;
  do{
    scanf(" %[^\n]", entrada);
    fimPrograma = checkFim(entrada);
    if(!fimPrograma){
      if(checkPalindromo(entrada)){
        printf("SIM\n");
      }
      else {
        printf("NAO\n");
      }
    }
    

  }while(!fimPrograma);
  return 0;
}

