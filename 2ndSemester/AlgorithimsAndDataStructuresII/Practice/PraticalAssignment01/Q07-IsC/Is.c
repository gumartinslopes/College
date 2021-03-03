#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAXTAM 1000

bool checkFim(char entrada[]);
void getResp(bool resp);
bool isVogal(char n);
bool isConsoante(char n);
bool isNumero(char n);
bool checkApenasVogais(char entrada[]);
bool checkInt(char entrada[]);
bool checkApenasConsoantes(char entrada[]);
bool checkFloat(char entrada[]);

//funcao principal
int main(void){
  char entrada[MAXTAM];
  do{
    scanf(" %[^\n]*c", entrada);
    if(!checkFim(entrada)){
       getResp(checkApenasVogais(entrada));
       getResp(checkApenasConsoantes(entrada));
       getResp(checkInt(entrada));
       getResp(checkFloat(entrada));
       printf("\n");
    } 
  }while(!checkFim(entrada));
  return 0; 
}

//funcao que determina o fim do programa
bool checkFim(char entrada[]){
  return (entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M');
}

//funcao responsavel por printar a resposta
void getResp(bool resp){
  if(resp == true)
    printf("SIM ");
  else
    printf("NAO ");
}
//funcao auxiliar que checa vogais
bool isVogal(char n){
  bool resp = false;
  char vogais[] = {'a','e','o','u','A','E','O','U'};

  for(int i = 0; i < 10; i++){
    if(n == vogais[i]){
      resp = true;
      i = 10;
    }
  }
  return resp;
}

//funcao auxiliar que checa consoantes
bool isConsoante(char n){
  bool resp = false;
  if(isVogal(n) == false && (n > 65 && n <= 90 || n > 97 && n <= 122))
    resp = true;
  return resp;
}

//metodo auxiliar que verifica algarismos
bool isNumero(char n){
  bool resp = false;
  if(n >= 48 && n <= 57)
    resp = true;
  return resp;
}
/* 4 funcoes da questao */

//checagem do primeiro topico
bool checkApenasVogais(char entrada[]){
  bool resp = true;
  for(int i = 0; i < strlen(entrada); i++){
    if(isVogal(entrada[i]) == false && entrada[i] != ' '){
      resp = false;
      i = strlen(entrada);
    }
  }
  return resp;
}
bool checkApenasConsoantes(char entrada[]){
  bool resp = true;
  for(int i = 0; i < strlen(entrada); i++){
    if(!isConsoante(entrada[i]) && entrada[i] != ' '){
      resp = false;
      i = strlen(entrada);
    } 
  }
  return resp;
}
//checagem do terceiro topico
bool checkInt(char entrada[]){
  bool resp = true;
  for(int i = 0; i < strlen(entrada); i++){
    if(!isNumero(entrada[i]) && entrada[0] != '-'){
      resp = false;
      i = strlen(entrada); 
    }
  }
  return resp;
}

//checagem do ultimo topico
bool checkFloat(char entrada[]){
  bool resp = true;
  int contadorVirgula = 0, contadorPonto = 0;
  int tam = strlen(entrada);

  if(!checkInt(entrada)){
    for(int i = 0; i < tam; i++){
      if(!(isNumero(entrada[i])) && (entrada[i] != '.') && (entrada[i] != ',')){
        resp = false;
        i = tam;
      }
      else if(entrada[i] == ','){
        if(contadorVirgula > 0){
          resp = false;
          i = tam;
        }
        else{
          contadorVirgula++;
        }
      }
      else if(entrada[i] == '.'){
        if(contadorPonto > 0){
          resp = false;
          i = tam;
        }
        else{
          contadorPonto++;
        }
      }
    }
  }
  return resp;
}
