#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <chrono>
#include <climits>
#include <algorithm>

#include "ponto.hpp"
#include "resultado.hpp"
#include "mergesort.hpp"

using namespace std::chrono;


//cabecalhos das funcoes
void visualiza_espaco(Ponto espaco[], int n);
void visualiza_resultado(Resultado r);
void teste(int n);
void inicializa_espaco(Ponto espaco[], int n);
int compare_x(const void* a, const void *b);
int compare_y(const void* a, const void *b);
float distancia_euclidiana(Ponto* p1, Ponto* p2);
Resultado par_mais_proximo_bf(Ponto espaco[], int n);
Resultado closest_dq(Ponto espaco[], int n);


int main(){
    teste(10);
    teste(100);
    teste(1000);
    teste(10000);
    teste(100000);
    //teste(1000000);
    return 0;
}

void teste(int n){
    Ponto* espaco = new Ponto[n];
    inicializa_espaco(espaco, n);
    auto start_bf = steady_clock::now();
    Resultado r_bf = par_mais_proximo_bf(espaco, n);
    auto fim_bf = steady_clock::now();

    auto start_dq = steady_clock::now();
    Resultado r_dq = closest_dq(espaco, n);
    auto fim_dq = steady_clock::now();

    auto elapsed_dq = fim_dq - start_dq;
    auto elapsed_bf = fim_bf - start_bf;

    std::cout << "************ Teste com  " << n << " instancias ************" << std::endl;
    std::cout << "A solucao divide and conquer durou: " << duration_cast<milliseconds>(elapsed_dq).count() << " milissegundos"<< std::endl;
    std::cout << "A solucao bruteforce durou: " << duration_cast<milliseconds>(elapsed_bf).count() <<  " milissegundos" << std::endl;
    std::cout<< "Resultado Divide and Conquer" <<std::endl;
    visualiza_resultado(r_dq);
    std::cout<< "Resultado Brute Force" <<std::endl;
    visualiza_resultado(r_bf);

    std::cout << "\n\n\n"<< std::endl;
    delete[] espaco;
}

void visualiza_espaco(Ponto espaco[], int n){
    std::cout << "[";
    for(int i = 0; i < n-1; i++){
        std::cout <<"(x:"<< espaco[i].x <<", y:" << espaco[i].y << ")," << std::endl;    
    }
    std::cout <<"(x:"<< espaco[n - 1].x <<", y:" << espaco[n - 1].y <<")" << std::endl;
}

void visualiza_resultado(Resultado r){
    std::cout << "\n";
    std::cout << " - distancia: " << r.distancia << std::endl;
    std::cout << "P1: (x:" << r.p1_x << ",y:" << r.p1_y << ")" << std::endl;
    std::cout << "P2: (x:" << r.p2_x << ",y:" << r.p2_y << ")" << std::endl;
}

void inicializa_espaco(Ponto espaco[], int n){
    unsigned seed = time(0);
    srand(seed);
    for(int i = 0; i < n; i++){
        espaco[i] = {rand()%1000, rand()%1000};
    }
}

float distancia_euclidiana(Ponto* p1, Ponto* p2){
    return sqrt(pow((p1->x - p2->x), 2) + pow((p1->y - p2->y), 2));
}

//solucao O(n^2) utilizando a técnica de Bruteforce
Resultado par_mais_proximo_bf(Ponto espaco[], int n){
    Resultado r;
    Resultado pr;
    float min_delta = INT_MAX;
    for(int i = 0; i < n - 1; i++){
        for(int j = i + 1 ; j < n; j++){
            float delta = distancia_euclidiana(&espaco[i], &espaco[j]);
            if(delta < min_delta){
                min_delta = delta;
                r.distancia = delta;
                r.p1_x = espaco[i].x;
                r.p2_x = espaco[j].x;
                r.p1_y = espaco[i].y;
                r.p2_y = espaco[j].y;
            }
        }
    }
    return r;
}


//Encontrando os pontos mais próximos dentro da delimitação
Resultado closest_no_limite(Ponto pontos_limite[], int n, float distancia_limite) 
{ 
    Resultado r;
    r.distancia = INT_MAX;
    float min = distancia_limite;
    //reordenamos o vetor
    mergesort(pontos_limite, n, false); 
  
    //Sua complexidade é O(1) pois irá executar em no máximo 6 vezes.
    for (int i = 0; i < n; i++) 
        for (int j = i+1; j < n && (pontos_limite[j].y - pontos_limite[i].y) < min; j++) {
            float dist = distancia_euclidiana(&pontos_limite[i], &pontos_limite[j]);
            if (dist < min){
                min = dist;
                r.distancia = dist;
                r.p1_x = pontos_limite[i].x;
                r.p1_y = pontos_limite[i].y;
                r.p2_x = pontos_limite[j].x;
                r.p2_y = pontos_limite[j].y;
            } 
        }
    return r; 
} 

Resultado closest_dq_rec(Ponto espaco[], int n){
    //caso base eh trivial de resolver com bruteforce
    if (n <= 3) 
        return par_mais_proximo_bf(espaco, n); 
    Resultado r;  
    int meio = n/2; 
    //obtendo os resultados das duas particoes
    Resultado r_esq = closest_dq_rec(espaco, meio); 
    Resultado r_dir = closest_dq_rec(espaco + meio, n - meio); 
  
    r = (r_esq.distancia < r_dir.distancia)?r_esq:r_dir;
  
    Ponto* limite = new Ponto[n]; 
    int j = 0; 
    for (int i = 0; i < n; i++) {
        if (abs(espaco[i].x - espaco[meio].x) < r.distancia) 
            limite[j++] = espaco[i];
    }
    
    //obtendo o menor entre os valores obtidos no limite
    Resultado r_limite = closest_no_limite(limite, j, r.distancia);
    r = (r.distancia < r_limite.distancia)?r: r_limite;
    delete [] limite;
    return r;
}

Resultado closest_dq(Ponto espaco[], int n){
    //para essa solucao eh necessario que o espaco esteja ordenado
    mergesort(espaco, n, true);
    return closest_dq_rec(espaco, n);
}