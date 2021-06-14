#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Node{
	int element;
	Node* left, right;
	bool color;
} Node;

Node root;

Node newNode(int element, bool color){
	Node created = (Node*)malloc(sizeof(Node));
	created->element = element;	
	created->left = NULL;
	created->right = NULL;
	return created;
}

void insert(){

}

void start(){
	root = NULL;
}

int main(){
   	printf("Hello World");
	return 0;
}
	
