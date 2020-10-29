#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>


//funcao que verifica se eh palindromo
bool verificaPalindromoRecursivo(char s[], int tamanho, int i){      
    bool resultado = true; 
    
    if(i > tamanho/2) //apenas 1 char
      resultado = true;
    else if(s[i] != s[tamanho - 1 - i])
      resultado = false;
    else
	      resultado = verificaPalindromoRecursivo(s, tamanho, i + 1);

    return resultado;
}

//funcao que verifica a parada do codigo
bool para(char s[]){                    
    return (strlen(s) >= 3 && s[0] == 'F'&& s[1] == 'I' && s[2] == 'M');
}

int main(void){
    char myString [1050];
  
    do{
        scanf(" %[^\n]s", myString);

	      for (int i = 0, pos = 0; i < strlen(myString); i++, pos++) {
            if (myString[pos] == ' ') pos++;
                myString[i] = myString[pos];
    	  } 
        int tam = strlen(myString);
        bool ehPalindromo = verificaPalindromoRecursivo(myString,tam,0);
        if(ehPalindromo)
            printf("SIM\n");
        else
            printf("NAO\n");
        
    }while(!para(myString));  
    return 0;  
}//fim da main

