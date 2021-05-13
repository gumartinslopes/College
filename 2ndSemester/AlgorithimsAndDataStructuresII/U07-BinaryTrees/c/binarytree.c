#include <err.h>
#include <stdlib.h>
#include <stdio.h>
#include "binarytree.h"

Node* root;

void start(){
  root = NULL;
}

void insert(int x){
  root = insertRec(x, root);
} 

Node* insertRec(int x, Node *n){
  if(n == NULL)
    n = newNode(x);
  else if(x < n->element)
    n->left = insertRec(x, n->left);
  else if(x > n->element)
    n->right = insertRec(x, n->right);
  else
    errx(1, "Element %d is already on your tree", x);
  return n;
}

void insertByFather(int x){
  if(root == NULL)
    root  = newNode(x);
  else if(x < root->element)
    insertByFatherRec(x, root->left, root);
  else if(x > root->element)
    insertByFatherRec(x, root->right, root);
  else 
    errx(1, "Element %d is already on your tree", x);
}

void insertByFatherRec(int x, Node *i, Node *father){
  if(i == NULL){
    if(x < i->element)
      father->left = newNode(x);
    else
      father->right = newNode(x); 
  }
  else if(x < i->element)
    insertByFatherRec(x, i->left, i);
  else if(x > i->element)
    insertByFatherRec(x, i->right, i);
  else 
    errx(1, "Element %d is already on your tree", x);
}

void removeNode(int key){
  root = removeRec(key, root);
}

Node* removeRec(int key, Node *n){
  if(n == NULL)
    errx(1, "The tree is empty");
  else if(key < n->element)
    n->left = removeRec(key, n->left);
  else if(key > n->element)
    n->right = removeRec(key, n->right);
  else if(n->right == NULL)
    n = n->left;
  else if(n->left == NULL)
    n = n->right;
  else
    n->left = getAntecessor(n, n->left);
  return n;
}

Node* getAntecessor(Node *i, Node *j){
  if(j->right == NULL){
    i->element = j->element;
    j = j->left;
  }
  else 
    j = getAntecessor(i, j->right);
  return j;
}

void displayCentral(){
  displayCentralRec(root);
}

void displayCentralRec(Node *n){
  if (n != NULL){
    displayCentralRec(n->left);
    printf("%d\n", n->element);
    displayCentralRec(n->right);
  } 
}

void displayBefore(){
  displayBefore(root);
}

void displayBeforeRec(Node *n){
  if(n != NULL){
    printf("%d\n", n->element);
    displayBeforeRec(n->left);
    displayBeforeRec(n->right);
  }
}

void displayAfter(){
  displayAfterRec(root);
} 

void displayAfterRec(Node* n){
  if(n != NULL){
    displayAfterRec(n->left);
    displayAfterRec(n->right);
    printf("%d\n", n->element);
  }
}

