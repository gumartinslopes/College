#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <climits>
#include <algorithm>

#include "ponto.hpp"
#include "resultado.hpp"
#include "mergesort.hpp"

#define N 10000000

//cabecalhos das funcoes
void visualiza_espaco(Ponto espaco[], int n);
void visualiza_resultado(Resultado r);
void inicializa_espaco(Ponto espaco[], int n);
int compare_x(const void* a, const void *b);
int compare_y(const void* a, const void *b);
float distancia_euclidiana(Ponto* p1, Ponto* p2);
Resultado closest_bf(Ponto espaco[], int n);
Resultado closest_dq(Ponto espaco[], int n);


int main(){
    Ponto* espaco = new Ponto[N];
    inicializa_espaco(espaco, N);
    //visualiza_espaco(espaco, N);

    Resultado r_dq = closest_dq(espaco, N);
    //Resultado r_bf = closest_bf(espaco, N);
    visualiza_resultado(r_dq);
    //visualiza_resultado(r_bf);
    std::cout <<"CABO" << std::endl; 
    delete[] espaco;
    return 0;
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
Resultado closest_bf(Ponto espaco[], int n){
    Resultado r;
    Resultado pr;
    float min_delta = INT_MAX;
    for(int i = 0; i < n - 1; i++){
        for(int j = i + 1 ; j < n; j++){
            float delta = distancia_euclidiana(&espaco[i], &espaco[j]);
            // pr.distancia = delta;
            // pr.p1_x = espaco[i].x;
            // pr.p2_x = espaco[j].x;
            // pr.p1_y = espaco[i].y;
            // pr.p2_y = espaco[j].y;
            // visualiza_resultado(pr);
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


Resultado closest_no_limite(Ponto limite[], int n, float delta) 
{ 
    Resultado r;
    r.distancia = INT_MAX;
    float min = delta; // Initialize the minimum distance as d 
    qsort(limite, n, sizeof(Ponto), compare_y); 
  
    // Pick all points one by one and try the next points till the difference 
    // between y coordinates is smaller than d. 
    // This is a proven fact that this loop runs at most 6 times 
    for (int i = 0; i < n; i++) 
        for (int j = i+1; j < n && (limite[j].y - limite[i].y) < min; j++) {
            float dist = distancia_euclidiana(&limite[i], &limite[j]);
            if (dist < min){
                min = dist;
                r.distancia = dist;
                r.p1_x = limite[i].x;
                r.p1_y = limite[i].y;
                r.p2_x = limite[j].x;
                r.p2_y = limite[j].y;
            } 
        }
    return r; 
} 

Resultado closest_dq_rec(Ponto espaco[], int n){
    //caso base eh trivial de resolver com bruteforce
    if (n <= 3) 
        return closest_bf(espaco, n); 
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
    //trocar para mergesort
    qsort(espaco,n, sizeof(Ponto), compare_x);
    
    return closest_dq_rec(espaco, n);
}