#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>


#define TAM_MAX_INFO 250
#define TAM_MAX_FILA 6    //tamanho inicializado com uma casa a mais do desejado para a fila

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
        printf(" ## %s ## %d ## %d ## %s ## %s ## %s ## %s ##\n",
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

//-----------------------------Fila Circular Dinamica-----------------------------
typedef struct Celula{
  Jogador elemento;
  struct Celula *prox;
}Celula;

//funcao que imita o construtor de celula
Celula *newcelula(Jogador *j){
  Celula *nova = (Celula*)(malloc(sizeof(Celula)));
  nova->elemento = *j;
  nova->prox = NULL;
  return nova;
}
Celula *primeiro, *ultimo;
void startfila(){
  char vazio[] = "0"; //criacao do jogador para o start do no cabeca
  Jogador j = criaJogador(vazio);
  primeiro = newcelula(&j);
  ultimo = primeiro;
}
int arredonda(float valor){
    return (valor >= 0) ? (int)(valor +0.5) : (int)(valor - 0.5);
}
int contajogadores(){
  int contador = 0;
  Celula *i = primeiro->prox;
  while(i != NULL){
    i = i->prox;
    contador++;
  }
  return contador;
}
//metodo que itera sobre os jogadores e calcula a media de altura
void calcularmedia(){
  if(primeiro != ultimo){
    int quantidade = 0;
    float soma = 0;
    Celula *i = primeiro->prox;
    while(i != NULL){
      soma += i->elemento.altura;
      i = i->prox;
      quantidade++;
    }
    printf("\t\t %i \n", arredonda(soma/quantidade));
  }
}

//apesar de nao ser acessado, o elemento do no cabeca ainda se mantem
Jogador desenfileirar(){
  if(primeiro == ultimo){
    printf("Impossivel remover uma fila vazia\n");
    exit(1);
  }
  Celula *aux = primeiro;
  primeiro = primeiro->prox;
  Jogador removido = primeiro->elemento;
  aux->prox = NULL;
  free(aux);
  aux = NULL;

  return removido;
}

void enfileirar(Jogador *j){
  calcularmedia();
  if(contajogadores() == 5){
    Jogador removido = desenfileirar();
  }
  ultimo->prox = newcelula(j);
  ultimo = ultimo->prox;
}

void mostrarfila(){
  int contador = 0;
  Celula *i = primeiro->prox;
  while(i != NULL){
    printf("[%d]", contador);
    imprimir(&i->elemento);
    i = i->prox;
    contador++;
  }
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

    enfileirar(&j);             //reaproveitamos o metodo de insercao
   }
  }while(acabou == false);
}

typedef struct
{
  char acao[2];
  int posicao;
  char id[5];
}comandos;

void manipula(int quantidadeAcoes){
    char entrada[30];
    comandos c;
    for(int i = 0; i < quantidadeAcoes; i++){
      scanf(" %[A-Z  0-9]s", entrada);
      strcpy(c.acao ,strtok(entrada, " "));
      //acoes de insercao
      if(c.acao[0] == 'I'){
        strcpy(c.id,(strtok(NULL, " ")));
        Jogador j = criaJogador(c.id);
        enfileirar(&j);
      }
      else if(c.acao[0] == 'R'){
        Jogador j = desenfileirar();
        printf("(R) %s\n", j.nome);
      }
      //erro de entrada
      else {
        printf("Acao Invalida\n");
      }
    }
    mostrarfila();
}

int main(void){
  startfila();

  cadastra();
  int quantidadeAcoes;

  scanf("%i", &quantidadeAcoes);
  manipula(quantidadeAcoes);
  return 0;
}
