#include <iostream>
#include "./header files/matriz_adjacencia.hpp"
//construtor
MatrizAdjacencia::MatrizAdjacencia(int qtd_vertices){
    this->num_linhas = qtd_vertices;
    this->num_colunas = qtd_vertices;
    this->matriz = new int*[qtd_vertices];
    
    //inicializando a matriz
    for(int i = 0; i < qtd_vertices; i++)
        this->matriz[i] = new int[qtd_vertices];
    
    //populando a matriz com 0s
    for(int i = 0; i < qtd_vertices; i++)
        for(int j = 0; j < qtd_vertices; j++)
            this->matriz[i][j] = 0;
}

void MatrizAdjacencia:: print_matriz(){
    std::cout << "\n -- Matriz de adjacencia -- " << std::endl;
    for(int i = 0; i < this->num_linhas; i++){
        for(int j = 0; j < this->num_colunas; j++)
            std::cout << "|" << this->matriz[i][j] << "|";
        std::cout<<"\n";
    }
}

//se grafo direcionado valor_v1 = 1, valor_v2 mantém
//se grafo nao direcionado valor_v1 = 1 valor_v2 = 1
void MatrizAdjacencia::add_aresta(int index_vi, int index_vf, int valor_v1, int valor_v2){
    if(index_vi >= num_linhas || index_vf >= num_colunas){
        std::cout << "Posicao de insercao na matriz invalida" << std::endl;
    }
    else{
            this->matriz[index_vi][index_vf] = valor_v1;
        if(valor_v2 != 0)                   
            this->matriz[index_vf][index_vi] = valor_v2;
    }
}

int* MatrizAdjacencia::get_adjacencias(int index){
    return this->matriz[index];
}
//destrutor
MatrizAdjacencia::~MatrizAdjacencia(){
    for(int i = 0; i < this->num_linhas; i ++)
        delete [] this->matriz[i];
    delete[] this->matriz;
}