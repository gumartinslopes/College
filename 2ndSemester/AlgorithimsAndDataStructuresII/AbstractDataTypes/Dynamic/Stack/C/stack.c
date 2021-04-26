#include <stdio.h>
#include <stdlib.h>
#include <err.h>

typedef struct Celula{
  struct Celula *prox;
  int elemento;
}Celula;
Celula *topo;

void start(){
  topo = NULL;
}

Celula *novaCelula(int x){
  Celula *novo = (Celula*) malloc(sizeof(Celula));
  novo->elemento = x;
  novo->prox = NULL;
  return novo;
}

void mostrar(){
  printf("\nSua pilha: \n");
  for(Celula* i = topo;i != NULL; i = i->prox)
    printf(" - %d \n", i->elemento);
}

//inserção
void push(int x){
  Celula *aux = novaCelula(x);
  aux->prox = topo;
  topo = aux;
  aux = NULL;
}

//remoção
int pop(){
  if(topo == NULL)
    errx(1, "Impossivel remover em uma pilha vazia");
  int elemento = topo->elemento;
  Celula * aux = topo;
  topo = topo->prox;
  aux->prox = NULL;
  free(aux);
  aux = NULL;
}

int main(){
  start();
  push(1);
  push(2);
  push(85);
  push(115);
  mostrar();
  pop();
  mostrar();
}
