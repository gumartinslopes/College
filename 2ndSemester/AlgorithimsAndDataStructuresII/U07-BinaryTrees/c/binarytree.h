#include "node.h"
#define bool short
#define true 1
#define false 0

bool searchRec(int, Node*);
void displayCentralRec(Node*);
void displayBeforeRec(Node*);
void displayAfterRec(Node*);
void insertByFatherRec(int, Node*, Node*);
Node* insertRec(int, Node*);
Node* removeRec(int, Node*);
Node* getAntecessor(Node*, Node*);

void start();
bool search(int);
void displayCentral();
void displayBefore();
void displayAfter();
void insert(int);
void removeNode(int);
