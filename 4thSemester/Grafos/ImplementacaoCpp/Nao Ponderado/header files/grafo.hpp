#pragma once
#include "vertice.hpp"
#include "matriz_adjacencia.hpp"
class Grafo{
    private:
        MatrizAdjacencia *matriz_adj;
        int qtd_atual_vertices;
        int qtd_max_vertices;
        bool direcionado;
        Vertice *vertices;                            // lista de vértices no gráfico
    public:
        Grafo(int qtd_vertices, bool direcionado);            // construtor
        ~Grafo();                                            // destrutor
        void print_lista_vertices();
        void log();
        void add_vertice(std::string rotulo);  
        int get_indice_vertice(std::string rotulo);
        void conecta(std::string inicio, std::string fim);
        bool valida_vertice(std::string rotulo);
        void mostra_adjacencias(std::string rotulo);
};