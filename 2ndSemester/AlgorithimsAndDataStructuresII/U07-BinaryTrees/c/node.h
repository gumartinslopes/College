
typedef struct Node{
  int element;
  struct Node *left, *right;
}Node;

Node *newNode(int element);
