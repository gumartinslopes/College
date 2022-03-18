#pragma once
class MatrizAdjacencia{
    private:
        int** matriz;
        int num_linhas, num_colunas;
    public:
        MatrizAdjacencia(int qdt_vertices = 0);
        void print_matriz();
        void add_aresta(int index_v1, int index_v2, int valor_v1, int valor_v2);
        int* get_adjacencias(int index);
        ~MatrizAdjacencia();
};