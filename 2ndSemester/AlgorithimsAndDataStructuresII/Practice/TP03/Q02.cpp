#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define TAM_MAX_LIST 3000
#define TAM_MAX_INFO 250

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

int tam = 0;

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


//-----------------------------lista-----------------------------
//funcao que imita um construtor
void start(){
  tam = 0;
}

void inserirInicio(Jogador *j){
  if(tam >= TAM_MAX_LIST){
    exit(1);
  }
  //levamos os elementos uma posicao a frente
  for(int i = tam; i > 0; i--){
    lista[i] = lista[i - 1];
  }

  lista[0] = *j;
  tam++;
}
void inserir(Jogador *j, int pos){
  if(tam >= TAM_MAX_LIST || pos < 0 || pos > tam){
    exit(1);
  }

  for(int i = tam; i > pos; i--){
    lista[i] = lista[i - 1] ;
  }

  lista[pos] = *j;
  tam++;
}
void inserirFim(Jogador *j){
  if(tam >= TAM_MAX_LIST){
    exit(1);
  }

  lista[tam] = *j;
  tam++;
}



Jogador removerInicio(){
  if(tam == 0){
    exit(1);
  }

  Jogador removido = lista[0];
  tam--;
  //movemos todos os jogadores uma posicao a frente
  for(int i = 0; i < tam; i++){
    lista[i] = lista[i + 1];
  }
  return removido;
}

  Jogador remover(int pos){
  if(tam == 0 || pos < 0 || pos >= tam){
    exit(1);
  }
  Jogador removido = lista[pos];

  tam--;
  //movemos todos os jogadores uma posicao atras
  for(int i  = pos; i < tam; i++){
    lista[i] = lista[i+1];
  }
  return removido;
}

Jogador removerFim(){
  if(tam == 0){
    exit(1);
  }
  //pre decrementamos o tamanho na remocao
  return lista[--tam];
}

void mostrarlista(){
  int contador = 0;
  for(int i = 0; i < tam; i++){
    printf("[%i]",i);
    imprimir(&lista[i]);
  }
}

//---------------------------------------------------------------
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

void manipula(int quantidadeAcoes){
    char entrada[30];
    comandos c;
    for(int i = 0; i < quantidadeAcoes; i++){
      scanf(" %[A-Z * 0-9]s", entrada);
      strcpy(c.acao ,strtok(entrada, " "));
      //acoes de insercao
      if(c.acao[0] == 'I'){
        //inserir no inicio
        if(c.acao[1] == 'I'){
          strcpy(c.id,(strtok(NULL, " ")));
          Jogador j = criaJogador(c.id);
          inserirInicio(&j);
        }
        //inserir no final
        if(c.acao[1] == 'F'){
          strcpy(c.id,(strtok(NULL, " ")));
          Jogador j = criaJogador(c.id);
          inserirFim(&j);
        }
        //inserir posicao
        if(c.acao[1] == '*'){
          c.posicao = atoi(strtok(NULL, " "));
          strcpy(c.id,(strtok(NULL, " ")));
          Jogador j = criaJogador(c.id);
          inserir(&j, c.posicao);
        }
      }
      //acoes de remocao
      else if(c.acao[0] == 'R'){
        //remover no inicio
        if(c.acao[1] == 'I'){
          Jogador removido = removerInicio();
          printf("(R) %s\n", removido.nome);
        }
        //remover no fim
        else if(c.acao[1] == 'F'){
          Jogador removido = removerFim();
          printf("(R) %s\n", removido.nome);
        }
        //remover posicao
        else if(c.acao[1] == '*'){
          c.posicao = atoi(strtok(NULL, " "));
          Jogador removido = remover(c.posicao);
          printf("(R) %s\n", removido.nome);
        }
      }
      //erro de entrada
      else {
        printf("Acao Invalida\n");
      }
    }
    mostrarlista();
}
int main(void){
  start();

  int quantidadeAcoes;
  cadastra();

  scanf("%i", &quantidadeAcoes);
  manipula(quantidadeAcoes);
  return 0;
}
