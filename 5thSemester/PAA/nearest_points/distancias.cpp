#include "./header_files/distancias.hpp"

//raiz quadrada do soma dos quadrados das diferenças entre o x e o y
float distancia_euclidiana(Ponto p1, Ponto p2){
    return sqrt(pow((p1.x - p2.x), 2) + pow((p1.y - p2.y), 2));
}

void calcula_todas_distancias(Ponto pontos[], int n){
    
}