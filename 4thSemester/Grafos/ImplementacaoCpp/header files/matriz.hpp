#pragma once
#include <string>
class Matriz{
    private:
        std::string nome;
        int** matriz;
        int num_linhas, num_colunas;
    public:
        Matriz( std::string nome, int qdt_vertices = 0);
        void print_matriz();
        void add_aresta(int index_v1, int index_v2, int valor_v1, int valor_v2, bool direcionado);
        int* get_adjacencias(int index);
        ~Matriz();
};