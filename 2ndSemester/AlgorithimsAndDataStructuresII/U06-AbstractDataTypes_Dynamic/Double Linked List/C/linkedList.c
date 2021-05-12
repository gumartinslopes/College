#include <stdio.h>
#include <stdlib.h>
#include <err.h>

typedef struct Celula{
  int elemento;
  struct Celula* prox;
  struct Celula* ant;
}Celula;

Celula *primeiro, *ultimo;

Celula* novaCelula(int x){
  Celula *c = (Celula*)malloc(sizeof(Celula));
  c->elemento = x;
  c-> prox = c->ant = NULL;
  return c;
}

void start(){
  primeiro = novaCelula(0);//iniciamos o nó cabeça
  ultimo = primeiro;
}

int getTamanho(){
  int tamanho = 0;
  for(Celula *i = primeiro->prox; i != NULL; i = i->prox, tamanho++);
  return tamanho;
}

void inserirNoInicio(int x){
  Celula *aux = novaCelula(x);
  aux->prox = primeiro->prox;
  aux->ant = primeiro;
  primeiro->prox = aux;

  if(primeiro == ultimo)
    ultimo = aux;
  else
    aux->prox->ant = aux;
  aux = NULL;
}

void inserirNoFim(int x){
  ultimo->prox = novaCelula(x);
  ultimo->prox->ant = ultimo;
  ultimo = ultimo->prox;
}

void inserirPos(int pos, int x){
  int tamanho = getTamanho();
  if(pos < 0 || pos > tamanho)
    errx(1, "Posicao de insercao invalida");
  else if(pos == 0)
    inserirNoInicio(x);
  else if(pos == tamanho)
    inserirNoFim(x);
  else {
    Celula *aux = novaCelula(x);
    Celula * i = primeiro->prox;
    for(int j = 0; j < pos; j++, i = i->prox);
    
    aux->prox = i->prox;
    aux->ant = i;
    aux->prox->ant = i->prox = aux;
    
    aux = i = NULL;
  }
}

void removerInicio(){
  if(primeiro == ultimo)
    errx(1, "Impossivel remover em uma lista vazia");
  Celula *removido = primeiro->prox;
  primeiro->prox = removido->prox;
  removido->prox->ant = removido->ant; 
  removido->ant = NULL;
  removido->prox = NULL;
  printf("\n\tRemovemos o elemento %d na primeira posicao", removido->elemento);
  free(removido);
  removido = NULL;
}

void removerFim(){
  if(primeiro == ultimo)
    errx(1, "Impossivel remover em uma lista vazia");
  ultimo = ultimo->ant;
  ultimo->prox->ant = NULL;
  printf("\n\tRemovemos o elemento %d na ultima posicao", ultimo->prox->elemento);
  free(ultimo->prox);
  ultimo->prox = NULL;
}

void removerPos(int pos){
  int tamanho = getTamanho();
  if(primeiro == ultimo)
    errx(1, "Impossivel remover em uma lista vazia");
  else if(pos < 0 || pos > tamanho)
    errx(1, "Posicao invalida");
  else if(pos == 0)
    removerInicio();
  else if(pos == tamanho - 1)
    removerFim();
  else{
    Celula *i = primeiro->prox;
    for(int j = 0; j < pos; j++,i = i->prox);
    Celula *aux = i->prox;
    i->prox = aux->prox; 
    aux->ant = NULL;
    aux->prox = NULL;
    printf("\n\tRemovemos o elemento %d na posicao %d ", aux->elemento, pos);
    free(aux);
  }
}

void mostrar(){
  for(Celula *i = primeiro->prox; i != NULL; i = i->prox)
    printf("%d\n", i->elemento);
}

int main(){
  start();
  for(int i = 0; i < 10; i++)
    inserirNoFim(i);
  
  for(int i = 0; i < 10; i++)
    inserirNoInicio(i);
  inserirPos(7, 777);

  mostrar();
  removerPos(7);
  removerFim();
  removerInicio();
  mostrar();
  
  return 0;
}
