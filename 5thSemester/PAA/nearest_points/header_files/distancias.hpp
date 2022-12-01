#include <cmath>
#include "resultado.hpp"
#include "ponto.hpp"

//raiz quadrada do soma dos quadrados das diferenças entre o x e o y
float distancia_euclidiana(Ponto p1, Ponto p2);

//1 - Resolucao n^2 (brute-force)
void calcula_todas_distancias(Ponto pontos[], int n);