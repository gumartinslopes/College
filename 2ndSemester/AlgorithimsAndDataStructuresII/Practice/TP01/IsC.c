#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
//retorna true se for composto apenas por vogais
bool isAllVowel(char string[]){
  bool resultado = true;
  for(int i =0; i < strlen(string); i++){
    if(string[i]!='A' && string[i]!='E' && string[i]!='I' && string[i] !='O' && string[i]!='U'&&
	      string[i]!='a' && string[i]!='e' && string[i]!='i' && string[i]!='o' && string[i]!='u')
        resultado = false;
  }
  return resultado;
}

//retorna true se for composto apenas por consoantes
bool isAllConsonant(char string[]){
  bool resultado = true;
  for(int i = 0; i < strlen(string); i++){
    if(!(string[i] > 64 && string[i] < 91) && !(string[i] > 96 && string[i] < 123 ))			//filtro de letras
              resultado = false;
	   else if(string[i] == 'A'|| string[i] == 'E' || string[i] == 'I' || string[i] == 'O' || string[i] == 'U'||	//filtro de consoantes
	           string[i] == 'a'|| string[i] == 'e'|| string[i] == 'i' || string[i] == 'o' || string[i] == 'u')
	      resultado = false;
  }

  return resultado;
}

//retorna true se for inteiro
bool isAnInt(char string[]){
  bool resultado = true;
  for(int i = 0; i < strlen(string); i++){
    if(!(string[i] <= 57 && string[i] > 47))	//verificando se o o char fica entre 0(48) a 9(57) pelo codigo ascii
		    resultado = false;
  }
  return resultado;
}

//retorna true se for float
bool isAFloat(char string[]){
  bool resultado = true;
  for(int i = 0; i < str.length(); i ++){
	     if((string[i] > 57 || string[i] < 47) && (string[i] != '.' && string[i] != ','))
	        resultado = false;
	  }
  return resultado;
}

//verifica o fim do metodo
//funcao que verifica a parada do codigo
bool para(char s[], int tam){                    
    return (tam >= 3 && s[0] == 'F'&& s[1] == 'I' && s[2] == 'M');
}

void escreve(bool x){
  if(x)
    printf("SIM ");
  else
    printf("NAO ");
}

int main(void){
  char myString[1050];
  bool x1, x2, x3, x4;
  int tamanho = strlen(myString);
  
  do{
	  scanf(" %[^\n]s", myString);
    
    x1 = isAllVowel(myString);
	  x2 = isAllConsonant(myString);
	  x3 = isAnInt(myString);   
	  x4 = isAFloat(myString);	

	  escreve(x1);
    escreve(x2);
    escreve(x3);
    escreve(x4);
    printf("\n"); 
    
	}while(!para(myString, tamanho));
}//fim da main
