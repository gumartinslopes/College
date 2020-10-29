#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

void criptografa(char mensagem[]){
  char criptografado[1066];
  char aux;
  for(int i = 0; i < strlen(mensagem); i ++){
    aux =  mensagem[i] + 3;
    if(mensagem[i] == ' ' && mensagem[i] != '\n')
	criptografado[i] = ' ';
    else
        criptografado[i] = aux;
  }
  printf("%s\n", criptografado);
}
//funcao que verifica o fim do programa
bool para(char string[]){
  return (strlen(string) == 3 && string[0] == 'F' && string[1] == 'I' && string[2] == 'M');
}

int main(void){
  char myString[1060];

  do{
    scanf(" %[^\n]s", myString);
    criptografa(myString);
  }while(!para(myString));
  return 0;
}
