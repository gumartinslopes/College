#include <iostream>
using namespace std;
#define MAX_QUEUE_LENGTH 10

int first, last;
int queue[MAX_QUEUE_LENGTH + 1];//+1 pois teremos uma posição que não utilizaremos

void start(){
  first = last = 0;
}

void unqueue(){
  if(last == first)
    printf("Impossivel remover em uma fila vazia!");
  else{
    first = (first + 1) % MAX_QUEUE_LENGTH;
  }
}

void insert(int x){
  if(((last + 1) % MAX_QUEUE_LENGTH) == first)
    unqueue();
  queue[last] = x;
  last = (last + 1) % MAX_QUEUE_LENGTH;
}

void display(){
  printf("Sua Fila: \n");
  for(int i = first; i != last; i = ((i + 1) % MAX_QUEUE_LENGTH))
    printf("%d \n", queue[i]);
}

int main(){
  start();
  for(int i = 0; i < 10; i++)
    insert(i);
  display();
  unqueue();
  display();

  return 0;
}
