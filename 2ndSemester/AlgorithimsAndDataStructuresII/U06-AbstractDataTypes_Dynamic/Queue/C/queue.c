#include <stdio.h>
#include <stdlib.h>
#include <err.h>

typedef struct Celula{
  int elemento;
  struct Celula *prox;
}Celula;

Celula *primeiro,*ultimo; //declaração do nó cabeça e do último

void *newCelula(int x){
  Celula *nova = (Celula*)malloc(sizeof(Celula));
  nova->elemento = x;
  nova->prox = NULL;
  return nova;
}

void start(){
 primeiro = newCelula(15);//iniciamos o nó cabeça
 ultimo = primeiro;
}

//inserção no final da fila
void inserir(int x){
  ultimo->prox = newCelula(x);
  ultimo = ultimo->prox;
}

//remoção no início da fila
int remover(){
  if(ultimo == primeiro)
    errx(1, "Impossivel remover em uma fila vazia");
  int removido = primeiro->prox->elemento;
  Celula *aux = primeiro->prox;
  primeiro->prox = primeiro->prox->prox;
  aux->prox = NULL;
  free(aux);
  aux = NULL;
  return removido;
}

void mostrar(){
  printf("Sua fila :\n");
  for(Celula *i = primeiro->prox; i != NULL; i = i->prox)
    printf("%d%s", i->elemento,((i->prox == NULL)? " ":","));
  printf("\n\n");
}

int main(){
  start();
  inserir(1);
  inserir(2);
  inserir(3);
  mostrar();
  remover();
  remover();
  inserir(78);
  inserir(1548);
  mostrar();
}
