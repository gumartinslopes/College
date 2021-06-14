#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <stdbool.h>

typedef struct Node{
  int element;
  struct Node *left, *right;
  int level;
}Node;
Node *root;

void start(){
  root = NULL;
}

Node *newNode(int element){
  Node *created = (Node*)malloc(sizeof(Node));
  created->element = element;
  created->left = created->right = NULL;
  created->level = 1;
  return created;
}

int getLevel(Node *n){
  return ((n != NULL) ? n->level : 0);    
}

void setLevel(Node *n){
  int leftLevel = getLevel(n->left);
  int rightLevel = getLevel(n->right);
  n->level = 1 + ((rightLevel > leftLevel)? rightLevel : leftLevel);
}

Node *rotateRight(Node *n){
  printf("\tRight rotation on %d\n", n->element);
  Node *leftChild = n->left;
  n->left = leftChild->right;
  leftChild->right = n;

  setLevel(n);
  setLevel(leftChild);
  return leftChild;
}

Node *rotateLeft(Node *n){
  printf("\tLeft rotation on %d\n", n->element);
  Node *rightChild = n->right;
  n->right = rightChild->left;
  rightChild->left = n;

  setLevel(n);
  setLevel(rightChild);
  return rightChild;
}

Node *balance(Node *n){
  if(n != NULL){
    int factor = getLevel(n->right) - getLevel(n->left);
    //balanced tree
    if(abs(factor) <= 1)
      setLevel(n);
    //unbalanced to the right
    else if(factor == 2){
      int childFactor = getLevel(n->right->right) - getLevel(n->right->left);
      if(childFactor == -1)
        n->right = rotateRight(n->right);
      n = rotateLeft(n);
    }
    //unbalanced to the left
    else if(factor == -2){
      int childFactor = getLevel(n->left->left) - getLevel(n->left->right);
      if(childFactor == 1)
        n->right = rotateLeft(n->left);
      n = rotateRight(n);
    }
  }
  return n;
}

Node *insertRec(Node *n, int element){
  if(n == NULL)
    n = newNode(element);
  else if(n->element > element)
    n->left = insertRec(n->left, element);
  else if(n->element < element)
    n->right = insertRec(n->right, element);
  else 
    printf("The value %d already exists on your tree", element);
  return balance(n);
}

void insert(int element){
  root = insertRec(root, element);
}

void displayPreOrderRec(Node *n){
  if(n != NULL){
    printf("%d\n", n->element);
    displayPreOrderRec(n->left);
    displayPreOrderRec(n->right);
  }
}

void displayPreOrder(){
  printf("\n\tYour tree:\n");
  displayPreOrderRec(root);
}

void displayInOrderRec(Node *n){
  if(n != NULL){
    displayInOrderRec(n->left);
    printf("%d\n", n->element);
    displayInOrderRec(n->right);
  }
}

void displayInOrder(){
  printf("\n\tYour tree:\n");
  displayInOrderRec(root);
}

void standartInput(){
  char input[32];
  bool finishedInput;
  do{
    printf("\n\nType a value to insert on your tree.\n or type END to finish inserting: ");
    scanf(" %s", input);
    finishedInput = strcmp(input, "END") == 0;
    if(!finishedInput)
      insert(atoi(input));
  }
  while(!finishedInput);
}

int main(){
  start();
  system("clear");
  standartInput();
  displayInOrder();
  return 0;
}
