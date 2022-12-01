#include "./header_files/visualizacao.hpp"

void visualiza_pontos(Ponto pontos[], int n){
    for(int i = 0; i < n; i++){
        mostra_ponto(pontos[i]);
    }
    std::cout << "\n\n";
}

void mostra_ponto(Ponto p){
    std::cout << "{" << std::endl;
    std::cout << "\tRotulo: " << p.rotulo << std::endl;
    std::cout << "\tX: " << p.x << std::endl;
    std::cout << "\tY: " << p.y << std::endl;
    std::cout << "}" << std::endl;
}

void mostra_resultado(Resultado r, int num_elementos){
    std::cout << "*** Resultado do teste para "<< num_elementos << " instancias aleatorias ***" << std::endl;
    std::cout << "Pontos mais proximos:: " << r.rotulo_primeiro << " e " << r.rotulo_segundo << std::endl;
    std::cout << "Distancia entre os pontos: " << r.distancia << std::endl;
}