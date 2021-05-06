#include <stdio.h>
#include <stdlib.h>

typedef struct Cell{
  int element;
  struct Cell *next;
}Cell;
Cell *top;

void start(){
  top = NULL;
}

Cell *newCell(int x){
  Cell *created = (Cell*)malloc(sizeof(Cell));
  created->element = x;
  created->next = NULL;
  return created;
}

void mostrar(){
  printf("\nYour stack: \n");
  for(Cell *i = top; i != NULL; i = i->next)
    printf("%d ", i->element, ((i->next == NULL)? "\n" : " - "));
}

//inserção
void push(int x){
  Cell *aux = newCell(x);
  aux->next = top;
  top = aux;
  aux = NULL;
}

//remoção
int pop(){
  int removed = 0;
  if(top == NULL)
    printf("Pilha vazia impossivel remover");
  else{
  Cell *aux = top;
  removed = aux->element;
  top = top->next;
  aux->next =NULL;
  aux = NULL;
  }
  return removed;
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
