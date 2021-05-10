#include <iostream>
using namespace std;
#define MAX_STACK_HIGHT 10

int n = 0;
int stack[MAX_STACK_HIGHT];

void pop(){
  if(n >  0)
    cout << "elemento removido -> " << stack[--n] << endl;
  else
    cout << "pilha vazia" << endl;
}

void push(int x){
  if(n > MAX_STACK_HIGHT)
    stack[n++] = x;
  else
    cout << "Tamanho maximo da pilha atingido";
}

void display(){
  cout << "Sua Pilha:" << endl;
  for(int i = 0; i < n; i++)
    cout << "-> " << stack[i] << endl;
}

int main() {
  push(10);
  push(20);
  push(30);
  display();
  pop();
  display();
  return 0;
}
