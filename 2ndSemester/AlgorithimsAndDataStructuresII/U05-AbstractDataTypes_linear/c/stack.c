#include <stdio.h>
#include <stdlib.h>
#define MAX_HEIGHT 100

int height = 0;

void push(int x, int *stack){
  if(height < MAX_HEIGHT)
    stack[height++] = x;
  else
    printf("Sua pilha ja possui o maximo de elementos");
}

int pop(int *stack){
  int removed = 0;
  if(height < MAX_HEIGHT)
    removed = stack[--height];
  else 
    printf("Sua pilha esta vazia");
  return removed;
}

void display(int *stack){
  printf("Sua pilha:\n");
  for(int i = height - 1; i >= 0; i--)
    printf("- %d\n", stack[i]);
}

void pushTest(int *stack){
  for(int i = 0; i < 30; i++){
    push(i, stack);
    printf("\t - %d foi empilhado\n", i);
  }
}

void popTest(int *stack){
  for(int i = 0; i < 10; i++)
    printf("\t - %d foi desempilhado\n", pop(stack));
}

int main(){
  int stack[MAX_HEIGHT];
  pushTest(stack);
  display(stack);
  popTest(stack);
  display(stack);
  return 0;
}
