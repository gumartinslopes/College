#include <stdio.h>
#include <stdlib.h>

#define MAX_LENGTH 100
int length = 0;

void insertFirst(int x,int *list){
  if(length < MAX_LENGTH){
    for(int i = 1; i < length; i++)
      list[i] = list[i - 1];
    list[0] = x;
    length++;
  }
  else
    printf("Impossivel inserir, lista cheia");
}

void insertLast(int x, int *list){
  if(length < MAX_LENGTH)
    list[length++] = x;
  else
    printf("Impossivel inserir, lista cheia");
}

int removeFirst(int *list){
  int removed = 0;
  if(length > 0){
    removed = list[0];
    for(int i = 0; i < length - 1; i++)
      list[i] = list[i + 1];
    length--;
  } 
  else{
    printf("Impossivel remover, lista vazia");
  }

  return removed;
}

int removeLast(int *list){
  int removed = 0;
  if(length > 0)
    removed = list[--length];
  else 
    printf("Impossivel remover, lista vazia");
  return removed;
}

int removePos(int *list, int pos){
  int removed = 0;
  if(length < 0)
    printf("Impossivel remover, lista vazia");
  else if(pos < 0 || pos >= length)
    printf("Posicao invalida");
  else {
    for(int i = pos; i < length - 1; i++)
      i = list[i + 1];
    length--;
  }
  return removed;
}

void insertPos(int x, int *list, int pos){
  if(pos > length || pos < 0)
    printf("Posicao invalida");
  else if(length < MAX_LENGTH){
    for(int i = length; i > pos; i--)
      list[i] = list[i - 1];
    list[pos] = x;
    length++;
  }
  
  else
    printf("Impossivel inserir, lista cheia");
}

void display(int *list){
  printf("Sua lista:\n");
  for(int i = 0; i < length; i++)
    printf("- %d\n", list[i]);
  printf("\n\n");
}

void insertionTest(int *list){
  for(int i = 0; i < 10; i++)
    insertFirst(9, list);
  for(int i = 0; i < 10; i++)
    insertLast(7, list);
  for(int i = 0; i < 10; i++)
    insertPos(i, list, i);
  display(list);
}

void removalTest(int *list){
  for(int i = 0; i < 10; i++)
    removeFirst(list);
  display(list);
  for(int i = 0; i < 10; i++)
    removeLast(list);
  display(list);
  for(int i = 5; i > 0; i--)
    removePos(list, i);
  display(list);
}

int main(){
  int list[MAX_LENGTH];
  insertionTest(list);
  removalTest(list);
  return 0;
}
