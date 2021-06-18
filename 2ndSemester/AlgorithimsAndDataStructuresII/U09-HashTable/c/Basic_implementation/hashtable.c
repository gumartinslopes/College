#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*The basic implementation of the hash table*/
#define MAX_SIZE 31

void init_table (int table[]){
    for(int i = 0; i < MAX_SIZE; i++)
        table[i] = -1;          //in this case qe assume that all values are positive or 0
}

int hash(int key){
    return key % MAX_SIZE;
}

void display(int table[]){
    int i;
    printf("Your table\n[");
    for(int i = 0; i < MAX_SIZE; i++)
        printf("\t%d = %d\n", i, table[i]);
    printf("]");
}

void insert(int table[], int key){
    int id = hash(key);
    while(table[id] >= 0)
        id = hash(++id);
    table[id] = key;
}

bool search(int table[], int key){
    int id = hash(key);
    bool result = false;
    while(table[id] > -1){
        if(table[id] == key){
            result = true;
            break;
        }

        else
            id = hash(++id);
    }
    return result;
}

void insertion_menu(int table[]){
    printf("Please insert a value:");
    int value;
    scanf(" %d", &value);
    insert(table,value);
}

void search_menu(int table[]){
    printf("Please inser a value to search: ");
    int key;
    scanf(" %d", &key);
    if(search(table,key) == true)
        printf("The element %d exists on yout table\n", key);
    else
        printf("The element %d does not exist your your table\n", key);
}

int main(){
    int option, table[MAX_SIZE];
    init_table(table);
    do{
        printf("(0)Quit\n(1)Insert\n(2)Search\n(3)Display\n");
        scanf(" %d", &option);
        switch (option)
        {
        case 0:
            printf("Thanks for using the hashtable app\n");
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