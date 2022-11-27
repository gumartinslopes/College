#include <iostream>
#include <vector>
#include <cmath>
#include <string>

#include "./header_files/Ponto.hpp"
#include "./header_files/visualizacao.hpp"
#include "./header_files/resultado.hpp"



//raiz quadrada do soma dos quadrados das diferenças entre o x e o y
int distancia_euclidiana(Ponto p1, Ponto p2){
    return sqrt(pow((p1.x - p2.y), 2) + pow((p1.y - p2.y), 2));
}

void mostra_resultado(Resultado r){
    std::cout << "Distancia: " << r.distancia << std::endl;
    std::cout << "Primeiro ponto: " << r.rotulo_primeiro << std::endl;
    std::cout << "Segundo ponto: " << r.rotulo_segundo << std::endl;
}

//1 - Resolucao n^2 (brute-force)
Resultado calcula_distancias(std::vector<Ponto> pontos){
    //maior inteiro possível
    Resultado r;
    int distancia_atual;
    r.distancia = 2147483647;

    for(int i = 0; i < pontos.size() - 1; i++){
        for(int j = i + 1; j < pontos.size(); j++){
            distancia_atual = distancia_euclidiana(pontos[i], pontos[j]);
            if(r.distancia > distancia_atual){
                r.distancia = distancia_atual;
                r.rotulo_primeiro = pontos[i].rotulo;
                r.rotulo_segundo = pontos[j].rotulo;
            }
        }
    }
    return r;
}

int main(){
    int n = 3;
    Ponto p, p2, p3;
    p.rotulo = "p1";
    p.x = 4;
    p.y = 4;
    
    p2.rotulo = "p2";
    p2.x = 2;
    p2.y = 1;
    
    p3.rotulo = "p3";
    p3.x = 3;
    p3.y = 5;


    Ponto lista_pontos[n];
    lista_pontos[0] = p;
    lista_pontos[1] = p2;
    lista_pontos[2] = p3;
    visualiza_pontos(lista_pontos, n);
}