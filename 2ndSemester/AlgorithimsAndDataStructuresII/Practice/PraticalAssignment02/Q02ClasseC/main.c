#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define TOTAL_MUSIC_NUMBER 170625
#define MAX_LINE_LENGTH 1000
#define MAX_PLAYLIST_LENGTH 500
#define MAX_ID_LENGTH 25

typedef struct{
  char list[400];
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


//cabeçalhos das funções
void ler(char* filepath,char** totalMusicList);
void imprimir(Music *m);
int standartInput(char input[MAX_PLAYLIST_LENGTH][MAX_ID_LENGTH]);
void insertOnPlaylist(int insert_quantity, char idList[MAX_PLAYLIST_LENGTH][MAX_ID_LENGTH], char **totalMusicList, Music playlist[]);
void cadastra(char data_without_formatation[],Music* m);
void dataSplit(char* raw_info, char** formatted_data,int array_length);
void insertDate(Date* d, char* not_formatted_date);
void displayFormattedDate(Date* d);
void insertArtist(Artists_list* a,char* not_formatted_list);

int main(){
  char idList[MAX_PLAYLIST_LENGTH][MAX_ID_LENGTH];//vetor que armazena os ids do input
  int listed_id_quantity = standartInput(idList);
  Music playlist[MAX_PLAYLIST_LENGTH];
  
  //alocacao do array de strings
  char **totalMusicList; 
  totalMusicList = (char**)malloc(sizeof(char*) * TOTAL_MUSIC_NUMBER);

  //alocacao das strings contidas no array
  for(int i = 0; i < TOTAL_MUSIC_NUMBER; i++)
    totalMusicList[i] = (char*)malloc(sizeof(char*) * MAX_LINE_LENGTH);
   
  ler("/tmp/data.csv", totalMusicList);
  
  insertOnPlaylist(listed_id_quantity, idList,totalMusicList, playlist);
  
  for(int i = 0;i < listed_id_quantity; i++){
    imprimir(&playlist[i]); 
  }
  free(totalMusicList);

  return 0;
}

void ler(char* filepath,char** totalMusicList){
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
void imprimir(Music *m){
 printf("%s ## %s ## %s ## ", m->id, m->artists.list, m->name);
 displayFormattedDate(&m->release_date);
 printf(" ## %g ## %g ## %g ## %g ",m->acousticness, m->danceability, m->instrumentalness, m->liveness);
 printf("## %g ## %g ## %g ## %d \n", m->loudness, m->speechiness, m->energy, m->duration_ms); 
}

//funcao de entrada de dados padronizada
int standartInput(char inputs[MAX_PLAYLIST_LENGTH][MAX_ID_LENGTH]){
  char aux[MAX_ID_LENGTH];
  int input_quantity = 0;
  do{
    scanf(" %s", aux);
    if(strcmp(aux, "FIM")!= 0){
      strcpy(inputs[input_quantity], aux);
      input_quantity++;
    }
  }while(strcmp(aux, "FIM") != 0 && input_quantity <= MAX_PLAYLIST_LENGTH);
  return input_quantity;
}

void insertOnPlaylist(int insert_quantity, char idList[MAX_PLAYLIST_LENGTH][MAX_ID_LENGTH], char **totalMusicList, Music playlist[]){
  void searchById(char id[MAX_ID_LENGTH], char **totalMusicList, char* resp);//cabecalho declarado aqui pois apenas esta funcao chama a searchById
  
  for(int i = 0; i < insert_quantity; i++){
    char music_data[MAX_LINE_LENGTH];
    searchById(idList[i], totalMusicList, music_data); 
    cadastra(music_data, &playlist[i]);
  }
}

//pesquisa sequencial do cadastro
void searchById(char id[MAX_ID_LENGTH], char **totalMusicList, char* resp){
  for(int i = 0; i < TOTAL_MUSIC_NUMBER; i++){
    if(strstr(totalMusicList[i], id) != NULL){
      strcpy(resp, totalMusicList[i]);
      i = TOTAL_MUSIC_NUMBER;
    }
  }
}

//funcao que simula um construtor
void cadastra(char *data_without_formatation,Music* m){
  char **music_info;

  music_info = (char**)malloc(sizeof(char*) * 19);
  
  for(int i = 0; i < 19; i++)
    music_info[i] = (char*)malloc(sizeof(char) * 200);

  dataSplit(data_without_formatation,music_info, 19);
  m->valence = atof(music_info[0]);
  m->year = atoi(music_info[1]);
  m->acousticness = atof(music_info[2]);
  insertArtist(&m->artists, music_info[3]);
  m->danceability = atof(music_info[4]);
  m->duration_ms = atof (music_info[5]);
  m->energy = atof(music_info[6]);
//m.explicity = atoi( music_info[7]);       //dado nao cadastrado
  strcpy(m->id, music_info[8]);
  m->instrumentalness = atof(music_info[9]);
  strcpy(m->key, music_info[10]);
  m->liveness = atof(music_info[11]);
  m->loudness =  atof(music_info[12]);
//m.mode = atoi(music_info[13]);               //dado nao cadastrado
  strcpy(m->name, music_info[14]);
  m->popularity = atoi(music_info[15]);
  insertDate(&m->release_date,music_info[16]);
  m->speechiness = atof(music_info[17]);
  m->tempo = atof(music_info[18]);
  free(music_info);
}

void dataSplit(char* raw_info, char** formatted_data, int array_length){
  
  char aux[100];
  int arrayIndex, stringIndex, auxIndex;
  arrayIndex = stringIndex = auxIndex = 0;

  while(arrayIndex < array_length){
    //split padrao
    if(raw_info[stringIndex] == 44 || raw_info[stringIndex] == '\0'){
      strncpy(formatted_data[arrayIndex], aux, auxIndex);
      formatted_data[arrayIndex][auxIndex] = '\0';
      arrayIndex++;
      auxIndex = 0;
    }
    
   //verificacao de artista unico
   else if(raw_info[stringIndex] == 91){
    aux[auxIndex] = raw_info[stringIndex]; //acrescentamos o [
      do{
        auxIndex++;   
        stringIndex++;
        aux[auxIndex] = raw_info[stringIndex];  
      }while(raw_info[stringIndex] != 93);
      auxIndex++;
    }

   //filtro de aspas
   else if(raw_info[stringIndex] == '"'){
      stringIndex ++;//pulamos o "
      while(raw_info[stringIndex] != '"'){
        aux[auxIndex] = raw_info[stringIndex];
        auxIndex++;
        stringIndex++;
      }
    }
        
    else{
      aux[auxIndex] = raw_info[stringIndex];
      auxIndex++;
    }
    stringIndex++;
  } 
}

//funcoes referente a manipulacao de datas  aaaa-mm-dd
void insertDate(Date* d, char* not_formatted_date){
 char day[3];
 char month[3];
 char year[5];
  
 strncpy(year,not_formatted_date,4);
 d->year = atoi(year);
 
 if(not_formatted_date[4] != '-'){
    strcpy(month,"00");
 } 

 else{
    month[0] = not_formatted_date[5];
    month[1] = not_formatted_date[6];
 }

 if(not_formatted_date[7] != '-'){
  strcpy(day,"00");
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
void displayFormattedDate(Date* d){
    printf("%0*d/%0*d/%0*d", 2, d->day, 2, d->month, 4, d->year);
}

void insertArtist(Artists_list* a,char* input){
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
