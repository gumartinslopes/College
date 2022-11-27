#include "./header_files/visualizacao.hpp"

void visualiza_pontos(Ponto pontos[], int n){
    for(int i = 0; i < n; i++){
        mostra_ponto(pontos[i]);
    }
}

void mostra_ponto(Ponto p){
    std::cout << "{" << std::endl;
    std::cout << "\tRotulo: " << p.rotulo << std::endl;
    std::cout << "\tX: " << p.x << std::endl;
    std::cout << "\tY: " << p.y << std::endl;
    std::cout << "}" << std::endl;
}