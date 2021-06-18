#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*The basic implementation of the hash table*/
#define MAX_SIZE 31

typedef struct Node{
    int key;
    struct Node *next;
}Node;

typedef struct List{
    struct Node *first;
}List;

void init_list(List *l){
    l->first = NULL;
}

void init_table (List table[]){
    for(int i = 0; i < MAX_SIZE; i++)
        init_list(&table[i]);
}

int hash(int key){
    return key % MAX_SIZE;
}

void display_list(List *l){
    printf("[");
    for(Node *i = l->first; i != NULL; i = i-> next){
        printf("%d%s", i->key, ((i->next == NULL)? "" : ", "));
    }
    printf("]\n");
}
void display(List table[]){
    int i;
    printf("Your table\n[");
    for(int i = 0; i < MAX_SIZE; i++){
        printf("\t%d - ", i);
        display_list(&table[i]);
    }
    printf("]");
}

Node *new_node(int element){
    Node *n = (Node*)malloc(sizeof(Node));
    n->key = element;
    n->next = NULL;
    return n;
}

void insert_list(List *l, int element){
   Node *n = new_node(element);
   n->next = l->first;
   l->first = n;
}

void insert(List table[], int element){
    int pos = hash(element);
    insert_list(&table[pos], element);
}

bool search_list(List *l, int key){
    bool result = false;
    Node* i = l->first;
    while(i != NULL && i-> key != key){
       if(i->key == key){
           result = true;
           i = NULL;
       }
       else 
        i = i->next;
     }
    return result;
}

bool search(List table[], int key){
    int pos = hash(key);
    return search_list(&table[pos], key);
}

void insertion_menu(List table[]){
    printf("Please insert a value:");
    int value;
    scanf(" %d", &value);
    insert(table,value);
}

void search_menu(List table[]){
    printf("Please inser a value to search: ");
    int key;
    scanf(" %d", &key);
    if(search(table,key) == true)
        printf("The element %d exists on yout table\n", key);
    else
        printf("The element %d does not exist your your table\n", key);
}

int main(){
    int option;
    List table[MAX_SIZE];
    init_table(table);
    do{
        printf("(0)Quit\n(1)Insert\n(2)Search\n(3)Display\n");
        scanf(" %d", &option);
        switch (option)
        {
        case 0:
            printf("Thanks for using the hash table app\n");
            break;
        case 1:
            insertion_menu(table);
            break;
        case 2:
            search_menu(table);
            break;
        case 3: 
            display(table);
            break;
        
        default:
            break;
        }
    }while(option != 0);
    return 0; 
}