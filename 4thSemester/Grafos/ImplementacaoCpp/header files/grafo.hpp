#pragma once
#include "vertice.hpp"
#include "matriz.hpp"
class Grafo{
    private:
        Matriz *matriz_adj;
        Matriz *matriz_peso;
        int qtd_atual_vertices;
        int qtd_max_vertices;
        bool direcionado;
        bool ponderado;
        Vertice *vertices;                            // lista de vértices no gráfico
    public:
        Grafo(int qtd_vertices, bool direcionado, bool ponderado);// construtor
        ~Grafo();                                                 // destrutor
        void print_lista_vertices();
        void log();
        void add_vertice(std::string rotulo);  
        int get_indice_vertice(std::string rotulo);
        void conecta(std::string inicio, std::string fim);
        void adiciona_peso(int index_inicial, int index_fim);
        void trata_graus(Vertice *vi, Vertice *vf);
        bool valida_vertice(std::string rotulo);
        void mostra_adjacencias(std::string rotulo);
};