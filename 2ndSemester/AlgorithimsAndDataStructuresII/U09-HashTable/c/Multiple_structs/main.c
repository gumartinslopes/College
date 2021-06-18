#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

#define MAX_SIZE 31

typedef struct{
    int day;
    int month;
    int year;
}Date;

typedef struct
{
    char street[50];
    char district[50];
    char city[50];
    char country[50];
    int num, cep;
}Adress;

typedef struct{
    int code;
    Date sign_date;
    char office[50];
    float salary;
}Contract;

typedef struct {  
    char name[50];
    int cpf;
    Adress address;
    Date birth_date;
    Contract contract;
}Person;



/*---------- Display Functions ---------*/

void printAdress(Adress d){
    printf("street: %s\n", d.street);
    printf("district: %s\n", d.district);
    printf("city %s\n",d.city);
    printf("country: %s\n",d.country);
    printf("num: %d\ncep: %d\n", d.num, d.cep);
}

void printDate(Date d){
    printf("%2d/%2d/%4d\n", d.day, d.month, d.year);
}

void printContract(Contract c){
    printf("--Contract--\n");
    printf("Code: %d\n", c.code);
    printDate(c.sign_date);
    printf("Office: %s\n", c.office);
    printf("Salary: %.2f\n", c.salary);
}

void displayPerson(Person p){
    printf("--Person--\n");
    printf("Name: %s", p.name);
    printf("CPF: %d", p.cpf);
    printAdress(p.address);
    printDate(p.birth_date);
    printContract(p.contract);
}


/*---------- Read Functions ------------*/

Adress readAdress(){
    printf("\n\t--- Adress Insertion ---\n");
    Adress add;
    printf("Street: ");
    fgets(add.street, 49, stdin);
    printf("Distric: ");
    fgets(add.district, 49, stdin);
    printf("City: ");
    fgets(add.city, 49, stdin);
    printf("Country: ");
    fgets(add.country, 49, stdin);
    printf("Num: ");
    scanf(" %d", &add.num);
    printf("Cep: ");
    scanf(" %d", &add.cep);
    return add;

}

Date readDate(){
    Date d;
    printf("\n\tDisplay the date on the format dd mm aaaa\n->");
    scanf(" %d%d%d", &d.day, &d.month, &d.year);
    return d;
}

Contract readContract(){
    Contract c;
    printf("\n\t--- Contract Insertion ---\n");
    printf("Code: ");
    scanf(" %d", &c.code);
    printf("Signing date: ");
    c.sign_date = readDate();
    printf("Office: ");
    scanf(" %s", c.office);
    printf("Salary: ");
    scanf(" %f", &c.salary);
    return c;
}

Person readPerson(){
    Person p;
    printf("\n\t--- Person Insertion ---\n");
    printf("Name: ");
    fgets(p.name, 49, stdin);
    fflush(stdin);
    printf("CPF:");
    scanf(" %d", &p.cpf);
    p.address = readAdress();
    printf("Birthday");
    p.birth_date = readDate();
    p.contract = readContract();
    return p;
}

void clearPrompt(){
    system("cls");
}

void init_table (Person table[]){
    for(int i = 0; i < MAX_SIZE; i++)
        table[i].cpf = 0;
}

int hash(int key){
    return key % MAX_SIZE;
}


void insert(Person table[], Person element){
    int pos = hash(element.cpf);
    while(element.cpf != 0){
        pos = hash(pos + 1);
    }
    table[pos] = element;
}

bool search(Person table[], int key){
    int pos = hash(key);
    bool result = false;
    while(table[pos].cpf != 0){
        if(table[pos].cpf == key){
            result = true;
            break;
        }
        else{
            pos = hash(pos + 1);
        }
    }

    return result;
}

void insertion_menu(Person table[]){
    printf("Please insert all the data:");
    Person value = readPerson();
    insert(table,value);
}

void search_menu(Person table[]){
    printf("Please inser a value to search: ");
    int key;
    scanf(" %d", &key);
    if(search(table,key) == true)
        printf("The element %d exists on yout table\n", key);
    else
        printf("The element %d does not exist your your table\n", key);
}

void display(Person table[]){
    for(int i = 0; i < MAX_SIZE; i++){
        printf("%d - ", i);
        if(table[i].cpf != 0){
            displayPerson(table[i]);
            printf("\n ---------------------------- \n");
        }
    }
}

int main(){
    int option;
    Person table[MAX_SIZE];
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