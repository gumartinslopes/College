#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

typedef struct Node{
  int element;
  struct Node *left, *right;
}Node;

Node *newNode(int x){
  Node *tmp = (Node*) malloc(sizeof(Node));
  tmp->element = x;
  tmp->left = tmp->right = NULL;
  return tmp;
}

Node *insert(int x, Node *n){
  if(n == NULL)
    n = newNode(x);
  else if(x < n->element)
    n->left = insert(x, n->left);
  else 
    n->right = insert(x, n->right);
  return n;
}

void rearrange(int *array, Node *n, int *i){
  if(n != NULL){
    rearrange(array, n->left, i);
    array[*i] = n->element;
    (*i)++;
    rearrange(array, n->right, i);
  }
}

void sort(int *array, int len){
  Node *root = NULL;
  for(int i = 0; i < len; i++)
   root = insert(array[i], root);
  int rearrangePos = 0;
  rearrange(array, root, &rearrangePos);
}

void display(int *array, int len){
  printf("[");
  for(int i = 0; i < len; i++)
    printf("%d%s", array[i], ((i < len - 1)?", " : "]\n"));
}

void populate(int *array, int len){
  for(int i = 0; i < len; i++)
    array[i] = rand() % 100;
}

int main(){
  srand((unsigned)time(NULL));
  int array[10];
  int len = sizeof(array)/sizeof(int);
  populate(array, len);

  display(array, len);
  sort(array, len);
  display(array, len);
  
  return 0;
}
