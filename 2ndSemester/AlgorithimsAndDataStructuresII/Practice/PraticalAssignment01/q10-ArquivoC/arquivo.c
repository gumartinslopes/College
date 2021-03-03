#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void escreverValores(int quant, char *filePath);
void leAoContrario(int quant, char *filePath);

//funcao principal do programa
int main(){
  int quant;
  scanf("%d",&quant);
  escreverValores(quant, "arquivo.bin");
  leAoContrario(quant,"arquivo.bin");
}

//funcao de escrita de todos os valores
void escreverValores(int quant, char *filePath){
  FILE *raff = fopen(filePath, "wb");
  if(raff == NULL){//checagem de erro na abertura
    printf("Impossivel abrir o arquivo");
    exit(0);
  }
  else{
    float valor;
    for(int i = 0; i < quant; i++){
      scanf(" %f",&valor);
      fwrite(&valor,sizeof(float), 1, raff);
    }
    fclose(raff);
  }
}

//funcao que le o arquivo ao contrario e printa o valor double
void leAoContrario(int quant, char *filePath){
  FILE *raff = fopen(filePath,"rb");
  if(raff == NULL){//checagem de erro na abertura
    printf("Impossivel abrir o arquivo");
    exit(0);
  }
  else{
    float valor;
    for(int i = quant - 1; i >= 0; i--){
      fseek(raff, i * sizeof(float), SEEK_SET);//movemos o cabecote uma posicao a tras
      fread(&valor, sizeof(float), 1,raff);
      printf("%g\n", valor);
    }
    fclose(raff);
  }
}
