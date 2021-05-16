#include <stdio.h>
#include <stdlib.h>
#define MAX_LENGTH 6 //uma posicao do array nao sera usada

int first, last;

void start(){
  int first = last = 0;
}

void enqueue(int x, int *queue){
  if(((last + 1) % MAX_LENGTH) == first){
    printf("A fila esta cheia");
  }
  else{
    queue[last] = x;
    last = (last + 1) % MAX_LENGTH;
  }
}

int dequeue(int *queue){
  int removed = 0;
  if(first != last){
    removed = queue[first];
    first = (first + 1) % MAX_LENGTH;
  }
  return removed; 
}

void display(int *queue){
  int i = first;
  printf("Sua fila:\n");
  while(i != last){
    printf("%d - ", queue[i]);
    i = (i + 1) % MAX_LENGTH;
  }
  printf("\n");
}

void enqueueTest(int *queue){
  for(int i = 0; i < MAX_LENGTH - 1; i ++)
    enqueue(i, queue);
  display(queue);
}

void dequeueTest(int *queue){
  for(int i = 0; i < 3; i++)
    printf("\t- %d foi removido da fila\n", dequeue(queue));
  display(queue);
}

int main(){
  start();
  int queue[MAX_LENGTH];
  enqueueTest(queue);
  dequeueTest(queue);
  return 0;
}
