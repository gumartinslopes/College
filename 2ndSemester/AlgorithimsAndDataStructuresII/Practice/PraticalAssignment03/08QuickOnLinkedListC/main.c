#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <err.h>
#include <time.h>
/*
  Tp03 Lista Dupla Flex
  Matricula: 690773
  Author: Gustavo Martins Lopes da Costa
  Version: 2.0.0
*/

#define TOTAL_MUSIC_NUMBER 170625
#define MAX_LINE_LENGTH 1000
#define MAX_QUEUE_LENGTH 5
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
  struct Cell *prev;
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
Cell* getCell(int pos);
void sort();
void quicksort(int left, int right);

char **totalMusicList;
Cell *first, *last;
int log_comp = 0, log_mov = 0;

//Implementação da Lista Dupla
Cell *newCell(Music *m){
  Cell *created = (Cell*)malloc(sizeof(Cell));
  created->element = m;
  created->next = created->prev = NULL;
  return created;
}

void start(){
  Music *empty;
  first = newCell(empty);
  last = first;
}

int getLength(){
  int counter = 0;
  for(Cell *i = first->next; i != NULL; i = i->next)
    counter++;
  return counter;
}

double getAverage(){
  double sum = 0;
  double quantity = 0;
  Cell *i = first->next;
  while(i != NULL){
    sum += i->element->duration_ms;
    i = i->next;
    quantity++;
  }
  return(sum / quantity);
}

void display(){
  char infos[MAX_LINE_LENGTH];
  for(Cell *i = first->next; i != NULL; i = i->next){
    toString(i->element, infos);
    printf("%s \n", infos);
  }
}

char* removeFirst(){
  if(first == last)
    errx(1, "ERRO! Lista vazia");
   Cell *aux = first->next;
   char* removed = aux->element->name;
   first->next = first->next->next;
   aux->next = first->prev = NULL;
   free(aux->element);
   free(aux);
   aux = NULL;
   return removed;
}

char* removeLast(){
  if(first == last)
    errx(1, "ERRO! Lista vazia");
  char *removed = last->element->name;
  last = last->prev;
  last->next->prev = NULL;
  free(last->next);
  last->next = NULL;
  return removed;
}

char* removePos(int pos){
  char *removed;
  int length = getLength();
  if(last == first)
    errx(1, "Erro lista vazia");
  else if(pos > 0 || pos >= length)
    errx(1, "Posicao invalida");
  else if(pos == 0)
    removed = removeFirst();
  else if(pos == length)
    removed = removeLast();
  else{
    Cell *i = first->next;
    for(int j = 0; j < pos; j++, i = i->next);
    i->prev->next = i->next;
    i->next->prev = i->prev;
    removed = i->element->name;
    i->next = i->prev = NULL;
    free(i);
    i = NULL;
  }
  return removed;
}

void insertFirst(Music* m){
 Cell * aux = newCell(m);
 aux->prev = first;
 aux->next = first->next;
 first->next = aux;
 if(first == last)
   last = aux;
 else
   aux->next->prev = aux;
 aux = NULL;
}

void insertLast(Music* m){
  last->next = newCell(m);
  last->next->prev = last;
  last = last->next;
}

void insertPos(int pos,Music* m){
  int length = getLength();
  if(pos < 0 || pos > length)
    errx(1, "ERRO! Posição inválida");
  else if(pos == 0)
    insertFirst(m);
  else if(pos == length - 1)
    insertLast(m);
  else {
    Cell *i = first;
    for(int j = 0; j < pos; j++, i = i->next);
    Cell *aux = newCell(m);
    aux->prev = i;
    aux->next = i->next;
    aux->prev->next = aux->next->prev = aux;
    aux = i = NULL;
  }
}

Cell* getCell(int pos){
  Cell* i = first->next;
  for(int counter = 0; counter < pos; counter++, i = i->next);
  return i;
}

void swap(Cell *a, Cell *b){
  Cell *aux = newCell(a->element);
  a->element = b->element;
  b->element = aux->element;
} 

bool isMinorThan(Cell *a, Cell *b){
  bool result;
  
  log_comp++;
  if(a->element->duration_ms < b->element->duration_ms)
    result = true;

  else if(a->element->duration_ms == b->element->duration_ms){
    result = (strcmp(a->element->name, b->element->name) < 0)?true : false;
    log_comp+=2;
  }
  else
    result = false;
  return result;
}

void quicksort(int left, int right){
  int i = left, j = right;
  Cell *pivot = newCell(getCell((left + right) / 2)->element);
  while(i <= j){
    while(isMinorThan(getCell(i), pivot))
      i++;
    while(isMinorThan(pivot, getCell(j)))
      j--;
    if(i <= j){
      swap(getCell(i), getCell(j));
      log_mov += 3;
      i++;
      j--;
    }
  }
  if(left < j)
    quicksort(left, j);
  if(i < right)
    quicksort(i, right);
}

void sort(){
  quicksort(0, (getLength() - 1));
}

//funcao para documentacao do algorimto
void createlog(char *filepath,int comp, int mov, double time){
  FILE *fileptr = fopen(filepath, "w");
  fprintf(fileptr, "690773\t%d\t%d\t%f",comp, mov, time); 
  fclose(fileptr);
}

int main(){
  start();
  clock_t begin, end;
 
  //alocacao do array de strings
  totalMusicList = (char**)malloc(sizeof(char*) * TOTAL_MUSIC_NUMBER);
  //alocacao das strings contidas no array
  for(int i = 0; i < TOTAL_MUSIC_NUMBER; i++)
    totalMusicList[i] = (char*)malloc(sizeof(char*) * MAX_LINE_LENGTH);

  ler("/tmp/data.csv");

  initialInsertion();
  begin = clock(); 
  sort();
  display();
  end = clock();
  
  double execution_time = ((end - begin) / (double)CLOCKS_PER_SEC);
  createlog("690773_quicksort2.txt", log_comp, log_mov, execution_time);
  
  free(totalMusicList);
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
      insertLast(getRegister(music_data));
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
