#include <stdio.h>
#include <stdlib.h>

int main(void){
    FILE *pont; //declarando ponteiro para manipular arquivos
    int quantidade;
    double valor;
    double aux;

    pont = fopen("TesteArq.txt","w");    //abrindo para leitura e escrever
    
    scanf(" %i", &quantidade);
    double array[quantidade];
    int cont = quantidade -1;

    for(int i = 0; i < quantidade; i++){
    	scanf(" %lf", &valor);
	fprintf(pont, "%lf\n", valor);
    }
    fclose(pont);

    pont = fopen("TesteArq.txt","r");
    while(!feof(pont)){
        fscanf(pont,"%lf", &aux);
	array[cont] = aux;
    	cont--;
    } 

    for(int i = 0; i < quantidade; i ++){	
    	printf("%g \n", array[i]);	//%g mantem o codigo no formato correto sem 0s a direita
    }
    
    fclose(pont);
    return 0;
}
