#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>


#define TAM_MAX_LIST 3000
#define TAM_MAX_INFO 250
int tamanho;
long tempoantes;
long tempodepois;
long tempototal;

typedef struct                              //"classe"jogador em c se torna uma struct
    {
        int id;
        char nome [30];
        int altura;
        int peso;
        char universidade [30];
        char anoNascimento [5];
        char cidadeNascimento [30];
        char estadoNascimento [30];
    } Jogador;//fim da definição da struct

Jogador lista[TAM_MAX_LIST];

//funcao que cria um arquivo de log para a questao
void documenta(){

}
void ler(int id, char *info){
    FILE *file;

    bool achou = false;
    bool diferente = false;
    int contador = -1;                          //-1 pois devemos contar a leitura do cabeçalho


    file = fopen("arquivo.txt", "r");

    if(file == NULL){
        printf("Não foi possível abrir o arquivo ");
        exit(0);
    }
    while (achou == false){
            fgets(info, 250, file);
        if(contador == id)
            achou = true;
        contador++;
    }

    fclose(file);
}
//funcao que mostra os atributos dos jogadores
void imprimir(Jogador *jogador){
        printf("[%d ## %s ## %d ## %d ## %s ## %s ## %s ## %s]\n",
        jogador->id,
        jogador->nome,
        jogador->altura,
        jogador->peso,
        jogador->anoNascimento,
        jogador->universidade,
        jogador->cidadeNascimento,
        jogador->estadoNascimento);
}

bool acabou(char *entrada){
     bool resp = false;
     if(entrada[0] == 'F' && entrada[1] =='I' && entrada[2] == 'M')
        resp = true;
    return resp;
}



//filtramos a quebra de linha
void tiraQuebraDeLinha(char palavra[]){
	int tam = strlen(palavra);
	if(palavra[tam -2] == '\r' && palavra[tam -1] == '\n')
	    palavra[tam - 2] = '\0';

	else if(palavra[tam - 1] == '\r' || palavra[tam - 1] == '\n')
	    palavra[tam - 1] = '\0';
}

//funcao que filtra valores nao informados
void filtrarNaoInformados(char *info, char *infoFiltrada){
	int tam = strlen(info);
	for(int i = 0; i <= tam; i++, info++){
	    *infoFiltrada++ = *info;
	    if(*info == ',' && (*(info + 1) == ','|| *(info + 1) == '\0')){		//se tivermos ,, copiamos nao informado para a nova string
		strcpy(infoFiltrada, "nao informado");
		infoFiltrada += strlen("nao informado");				//adicionamos o tamanho de nao informado;
	    }
	}
}
//função que registra os jogadores com os devidos filtros.
void registra(Jogador *jj, char *info){
  tiraQuebraDeLinha(info);
	char infoFiltrada[TAM_MAX_INFO];
	filtrarNaoInformados(info, infoFiltrada);

	jj->id = atoi(strtok(infoFiltrada, ","));
  strcpy(jj->nome, strtok(NULL, ","));
  jj->altura = atoi(strtok(NULL, ","));
  jj->peso = atoi(strtok(NULL, ","));
  strcpy(jj -> universidade, (strtok(NULL, ",")));
  strcpy(jj -> anoNascimento, (strtok(NULL, ",")));
  strcpy(jj -> cidadeNascimento, (strtok(NULL, ",")));
  strcpy(jj -> estadoNascimento, (strtok(NULL, ",")));
}

//retorna o clone da srtuct jogador
Jogador clone(Jogador *jogador) {
    Jogador retorno;

    retorno.id = jogador->id;
    strcpy(retorno.nome, jogador->nome);
    retorno.altura = jogador->altura;
    retorno.peso = jogador->peso;
//  retorno.anoNascimento = jogador->anoNascimento;
    strcpy(retorno.universidade, jogador->universidade);
    strcpy(retorno.cidadeNascimento, jogador->cidadeNascimento);
    strcpy(retorno.estadoNascimento, jogador->estadoNascimento);

    return retorno;
}
Jogador criaJogador(char *entrada){
  int id = atoi(entrada);
  char infos[TAM_MAX_INFO];
  ler(id, infos);

  Jogador criado;
  registra(&criado, infos);
  return criado;
}
//-----------------------------lista Dinâmica-----------------------------
//funcao que imita um construtor
typedef struct CelulaDupla{
  Jogador elemento;
  struct CelulaDupla *prox;
  struct CelulaDupla *ant;
}Celula;

CelulaDupla *ultimo, *primeiro;

//funcao que imita o construtor de celula
CelulaDupla *newcelula(Jogador *j){
  CelulaDupla *nova = (CelulaDupla*)(malloc(sizeof(CelulaDupla)));
  nova->elemento = *j;
  nova->prox = NULL;
  nova->ant = NULL;
  return nova;
}

//metodo de ordenacao por quicksort
void quicksort(){

}

void ordena(){
  tempoantes = time(NULL);
  quicksort();
  tempodepois = time(NULL);
  tempototal = difftime(tempodepois,tempoantes);
}

void start(){
  char vazio[] = "0"; //criacao do jogador para o start do no cabeca
  Jogador j = criaJogador(vazio);
  primeiro = newcelula(&j);
  ultimo = primeiro;
  tamanho = 0;
}
//funcao de insercao no inicio da lista
void inserirInicio(Jogador *j){
  CelulaDupla *aux = newcelula(j);
  aux->ant = primeiro;
  aux->prox = primeiro->prox;
  primeiro->prox = aux;
  if(primeiro == ultimo){ //lista vazia
      ultimo = aux;
  }
  else{
    aux->prox->ant = aux;
  }
  aux = NULL;
  tamanho++;
}


//insercao no final da lista
void inserirFim(Jogador *j){
  ultimo->prox = newcelula(j);
  ultimo->prox->ant = ultimo;
  ultimo = ultimo->prox;
  tamanho++;
}
void inserir(Jogador *j, int pos){
  if(pos<0 || pos > tamanho){
    printf("Posicao invalida");
    exit(1);
  }
  else if(pos == 0){
    inserirInicio(j);
  }
  else if(pos == tamanho - 1){
    inserirFim(j);
  }
  else{
    CelulaDupla *i = primeiro;
    for(int j = 0; j < pos; j++, i = i->prox);

    CelulaDupla *aux = newcelula(j);
    aux->ant = i;
    aux->prox = i->prox;
    aux->ant->prox = aux->prox->ant = aux;
    aux = i = NULL;
  }
  tamanho++;
}
Jogador removerInicio(){
  if(primeiro == ultimo){
    printf("lista vazia");
    exit(1);
  }
  CelulaDupla *aux = primeiro;
  primeiro = primeiro->prox;        //andamos o no cabeca uma casa
  Jogador removido = primeiro->elemento;
  aux->prox = primeiro->ant = NULL;
  free(aux);
  aux = NULL;
  tamanho--;
  return removido;
}



Jogador removerFim(){
  if(primeiro == ultimo){
    printf("lista vazia, impossível remover");
  }
  Jogador removido = ultimo->elemento;
  ultimo = ultimo->ant;
  ultimo->prox->ant = NULL;
  free(ultimo->prox);
  ultimo->prox = NULL;
  tamanho--;
  return removido;

}
Jogador remover(int pos){
  Jogador removido;
  if(primeiro == ultimo || pos < 0 || pos >= tamanho){
    printf("erro de remocao\n");
    exit(1);
  }
  else if(pos == 0){
    removido = removerInicio();
  }
  else if(pos == tamanho - 1){
    removido = removerFim();
  }
  else{
    CelulaDupla *i = primeiro;
    for(int j = 0; j < pos; j++, i = i->prox); //caminhando até a posicao desejada
    CelulaDupla *aux = i->prox;
    removido = aux->elemento;
    i->prox = aux->prox;
    aux->prox = NULL;
    free(aux);
    i = aux = NULL;
  }
  return removido;
}
void mostrarlista(){

}

//---------------------------------------------------------------


void cadastra(){
  bool acabou = false;
  char entrada[4];

  do{
    scanf(" %s",entrada);

   if(strcmp(entrada, "FIM") == 0){
    acabou = true;
   }
   else{
    Jogador j = criaJogador(entrada);
    inserirFim(&j);             //reaproveitamos o metodo de insercao
   }
  }while(acabou == false);
}
typedef struct
{
  char acao[2];
  int posicao;
  char id[5];
}comandos;

int main(void){
  start();
  cadastra();
  ordena();
  mostrarlista();
  return 0;
}
