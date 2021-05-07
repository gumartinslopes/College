#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <err.h>

/*
  Tp03 Pilha Flex
  Matricula: 690773
  Author: Gustavo Martins Lopes da Costa
  Version: 2.0.0
*/

#define TOTAL_MUSIC_NUMBER 170625
#define MAX_LINE_LENGTH 1000
#define MAX_ID_LENGTH 25

typedef struct{
  char list[500];
  int list_length;
}Artists_list;

//struct Date
typedef struct{
  int day;
  int month;
  int year;
}Date;

//struct Music
typedef struct{
  char id[MAX_ID_LENGTH];
  char name[200];
  char key[200];
  Artists_list artists;
  Date release_date;
  double acousticness;
  double danceability;
  double energy;
  int duration_ms;
  double instrumentalness;
  double valence;
  int popularity;
  float tempo;
  double liveness;
  double loudness;
  double speechiness;
  int year;
}Music;

typedef struct Cell{
  Music *element;
  struct Cell *next;
}Cell;

//cabeçalhos das funções

void ler(char* filepath);
void toString(Music *m, char* result);
void initialInsertion();
void readAtribute(int *stringIndex, char *infos, char* output);
void searchById(char id[MAX_ID_LENGTH], char* resp);
Music* getRegister(char *music_info);
void insertDate(Date* d, char* not_formatted_date);
char* getFormattedDate(Date* d);
void insertArtists(Artists_list* a,char* not_formatted_list);

char **totalMusicList;
Cell *top;


//Implementação da fila
Cell *newCell(Music *m){
  Cell *created = (Cell*)malloc(sizeof(Cell));
  created->element = m;
  created->next = NULL;
  return created;
}


void start(){
  top = NULL;
}

int getHight(){
  int counter = 0;
  for(Cell *i  = top; i != NULL; i = i->next)
    counter++;
  return counter;
}

void displayBackwards(Cell *i, int counter){
  if(i->next != NULL)
    displayBackwards(i->next, counter - 1);

  char infos[MAX_LINE_LENGTH];
  toString(i->element, infos);
  printf("[%d] %s \n", counter, infos);
}

void display(){
  displayBackwards(top, getHight() - 1);
}
void push(Music* m){
  Cell *aux = newCell(m);
  aux->next = top;
  top = aux;
  aux = NULL;
}

void pop(){
  if(top == NULL)
    errx(1, "Pilha vazia");
  Cell *aux = top;
  Music *removed = aux->element;
  top = top->next;
 
  printf("(R) %s\n", removed->name);
  aux->next = NULL;
  free(aux);
  aux = NULL;
}

void manipulate(int opQuantity){
  char commands[3];
  char id[MAX_ID_LENGTH];
  for(int i = 0; i < opQuantity; i++){
    scanf(" %s", commands);
    if(commands[0] == 'I'){
      char music_info[MAX_LINE_LENGTH];
      scanf(" %s", id); 
      searchById(id, music_info);
      push(getRegister(music_info));
    }
    else if(commands[0] == 'R'){
      pop();
    }
    else {
      printf("Comando invalido");
    }
  } 
} 

int main(){
  start();
  
  //alocacao do array de strings
  totalMusicList = (char**)malloc(sizeof(char*) * TOTAL_MUSIC_NUMBER);
  //alocacao das strings contidas no array
  for(int i = 0; i < TOTAL_MUSIC_NUMBER; i++)
    totalMusicList[i] = (char*)malloc(sizeof(char*) * MAX_LINE_LENGTH);

  ler("/tmp/data.csv");

  initialInsertion();
  int opQuantity;
  scanf(" %i", &opQuantity);
  manipulate(opQuantity);
  
  free(totalMusicList);
  display();
  return 0;
}

void ler(char* filepath){
  FILE *f = fopen(filepath,"r");

  if(f == NULL){
    perror("Error opening file");   //checagem de erro ao abrir o arquivo
    printf("\n Sorry:(\n ");
  }

  else {
    int i = 0;
    char aux[MAX_LINE_LENGTH];
    fgets(aux, MAX_LINE_LENGTH, f);
    while(fgets(aux, MAX_LINE_LENGTH, f) != NULL){
      strcpy(totalMusicList[i], aux);
      i++;
    }
    fclose(f);
  }
}

//impressao padrao dos elementos relevantes da classe
void toString(Music *m, char *result){
  char *date = getFormattedDate(&m->release_date);

  sprintf(result, "%s ## %s ## %s ## %s ## %lg ## %lg ## %lg ## %lg ## %lg ## %lg ## %lg ## %d",
     m->id, m->artists.list, m->name, date,
     m->acousticness, m->danceability, m->instrumentalness, m->liveness,
     m->loudness, m->speechiness, m->energy, m->duration_ms
  );
  free(date);
}

//pesquisa sequencial do cadastro
void searchById(char id[MAX_ID_LENGTH], char* resp){
  for(int i = 0; i < TOTAL_MUSIC_NUMBER; i++){
    if(strstr(totalMusicList[i], id) != NULL){
      strcpy(resp, totalMusicList[i]);
      i = TOTAL_MUSIC_NUMBER;
    }
  }
}

bool checkContinue(char *id){
  return (strcmp(id, "FIM")!= 0);
}

//funcao de entrada de dados iniciais padronizada
void initialInsertion(){
  char id[MAX_ID_LENGTH];
  bool continueInsertion;
  do{
    scanf(" %s", id);
    fflush(stdin);
    continueInsertion = checkContinue(id);
    if(continueInsertion){
      char music_data[MAX_LINE_LENGTH];
      searchById(id, music_data);
      push(getRegister(music_data));
    }
  }while(continueInsertion);
}

Music *getRegister(char *music_info){
  Music *m = (Music*)malloc(sizeof(Music));
  int lineIndex = 0;
  char fields[19][MAX_LINE_LENGTH];

  //split dos atributos
  for(int i = 0; i < 19; i++)
    readAtribute(&lineIndex, music_info, fields[i]);

  //cadastro individual
  m->valence = atof(fields[0]);
  m->year = atoi(fields[1]);
  m->acousticness = atof(fields[2]);
  insertArtists(&m->artists,fields[3]);
  m->danceability = atof(fields[4]);
  m->duration_ms = atof(fields[5]);
  m->energy = atof(fields[6]);
  //explicit nao utilizado
  strcpy(m->id,fields[8]);
  m->instrumentalness = atof(fields[9]);
  strcpy(m->key,fields[10]);
  m->liveness = atof(fields[11]);
  m->loudness = atof(fields[12]);
  //mode nao utilizado
  strcpy(m->name,fields[14]);
  m->popularity = atoi(fields[15]);
  insertDate(&m->release_date, fields[16]);
  m->speechiness = atof(fields[17]);
  m->tempo = atof(fields[18]);
  return m;
}

//funcao que faz o split dos artibutos corretamente
void readAtribute(int *stringIndex, char *infos, char* output){
  int i = *stringIndex;
  int j = 0;
  while(infos[i] != '\0' && ((infos[i] != ',') || !(infos[i] == ',' && infos[i + 1] != ' '))){ //pulamos virgulas e quotes desnecessarios
    if(infos[i] != '"')
      output[j++] = infos[i];
    i++;
  }
   output[j] = '\0';
  *stringIndex = ++i;
}

//funcoes referente a manipulacao de datas  aaaa-mm-dd
void insertDate(Date* d, char* not_formatted_date){
 char day[3];
 char month[3];
 char year[5];

 strncpy(year,not_formatted_date,4);
 d->year = atoi(year);

 if(not_formatted_date[4] != '-'){
    strcpy(month,"01");
 }

 else{
    month[0] = not_formatted_date[5];
    month[1] = not_formatted_date[6];
 }

 if(not_formatted_date[7] != '-'){
  strcpy(day,"01");
 }
 else {
    day[0] = not_formatted_date[8];
    day[1] = not_formatted_date[9];
 }
 d->month = atof(month);
 d->year = atof(year);
 d->day = atof(day);
}

//display que adequa a formatacao de datas
char *getFormattedDate(Date* d){
    char *formattedDate = (char*)malloc(sizeof(char) * 10);
    sprintf(formattedDate, "%0*d/%0*d/%0*d", 2, d->day, 2, d->month, 4, d->year);
  return formattedDate;
}

void insertArtists(Artists_list* a,char* input){
  int i = 0;
  a->list_length = 0;
  while(i < strlen(input)){
    if(!(input[i] == 39 && (input[i - 1] == 91 || input[i+1] == 93 || input[i + 1] == 44 || input[i - 2] == 44))){
      a->list[a->list_length] = input[i];
      a->list_length++;
    }
    i++;
  }
}
