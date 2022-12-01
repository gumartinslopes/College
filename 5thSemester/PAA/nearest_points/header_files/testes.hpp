#include <iostream>
#include <cstdlib>
#include <ctime>

#include "ponto.hpp"
#include "resultado.hpp"
#include "pontos_mais_proximos.hpp"
#include "visualizacao.hpp"

void teste_ordenacao();
void teste_10_pontos(bool divide_and_conquer);
void teste_1000_pontos(bool divide_and_conquer);
void teste_100000_pontos(bool divide_and_conquer);
void teste_1000000_pontos(bool divide_and_conquer);
void teste_pontos_selecionados(bool divide_and_conquer);
void inicializa_pontos(Ponto pontos[],int n);
void mostra_resultado(Resultado r);