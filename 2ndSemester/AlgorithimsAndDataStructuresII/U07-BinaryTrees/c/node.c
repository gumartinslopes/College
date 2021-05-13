#include <stdlib.h>
#include "node.h"

Node *newNode(int element){
  Node *created = (Node*)malloc(sizeof(Node));
  created->element = element;
  created->left = NULL;
  created->right = NULL;
  return created;
}
