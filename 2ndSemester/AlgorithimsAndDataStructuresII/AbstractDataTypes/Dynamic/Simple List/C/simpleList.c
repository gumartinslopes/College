#include <stdio.h>
#include <stdlib.h>
#include <err.h>

typedef struct Celula{
  int elemento;
  struct Celula *prox;
}Celula;

Celula* newCelula(int x){
  Celula *criada = (Celula*)malloc(sizeof(Celula));
  criada->elemento = x;
  criada->prox = NULL;
  return criada;
}

Celula *primeiro, *ultimo;

void start(){
  primeiro = newCelula(-1);//inicialização do nó cabeça
  ultimo = primeiro;
}

void mostrar(){
  printf("Sua Lista:\n");
  for(Celula *i = primeiro->prox; i != NULL; i = i->prox)
    printf("%d %s", i->elemento, ((i->prox == NULL) ? " " : ", "));
  printf("\n");
}

int getLength(){
  int contador = 0;
  for(Celula *i = primeiro->prox; i != NULL; i = i-> prox, contador++);
  return contador;
}

void inserirInicio(int x){
  Celula *aux = newCelula(x); 
  aux->prox = primeiro->prox;
  primeiro->prox = aux;
  if(primeiro == ultimo)
    ultimo = aux;
  aux = NULL;
}

void inserirUltimo(int x){
  ultimo->prox = newCelula(x);
  ultimo = ultimo->prox;
}

void inserirPos(int pos, int x){
  int tamanho = getLength(); 
  if(pos > tamanho|| pos < 0)
    errx(1, "Posição de insercao invalida");
  else if(pos == 0)
    inserirInicio(x);
  else if(pos == tamanho)
    inserirUltimo(x);
  else{
    Celula* i = primeiro;
    for(int j = 0; j < pos; j++, i = i->prox);
    Celula* aux = newCelula(x);
    aux->prox = i->prox;
    i->prox = aux;
    aux = i = NULL;
  }
}

int removerInicio(){
  if(ultimo == primeiro)
    errx(1, "Impossivel remover em uma lista vazia");
  int removido = primeiro->prox->elemento;
  Celula* aux = primeiro->prox;
  primeiro->prox = primeiro->prox->prox;
  aux->prox = NULL;
  free(aux);
  aux = NULL;
  return removido;
}

int removerUltimo(){
  if(primeiro == ultimo)
    errx(1, "Impossivel remover em uma lista vazia");
  Celula *i;
  for(i = primeiro; i->prox != ultimo; i = i->prox);
  int removido = ultimo->elemento;
  ultimo = i;
  free(ultimo->prox);
  i = ultimo->prox = NULL;
  return removido;
}

int  removerPos(int pos){
  int removido, tamanho = getLength();
  if(primeiro == ultimo || pos < 0 || pos >= tamanho)
    errx(1, "posicao de remocao invalida");
  else if(pos == 0)
   removido = removerInicio();
  else if(pos == tamanho - 1)
    removido = removerUltimo();
  else{
    Celula *i = primeiro;
    for(int j = 0; j < pos; j++, i = i->prox);
    Celula *aux = i->prox;
    removido = aux->elemento;
    i->prox = aux->prox;
    aux->prox = NULL;
    free(aux);
    i = aux = NULL;
  }
  return removido;
}

int main(){
  start();
  inserirInicio(1);
  inserirUltimo(2);
  inserirPos(1, 115);
  mostrar();
  printf("%d", getLength());
  return 0;
}
