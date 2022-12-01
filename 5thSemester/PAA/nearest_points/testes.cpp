#include "./header_files/testes.hpp"
#include "./header_files/mergesort.hpp"

void teste_ordenacao(){
    int n = 10;
    Ponto lista_pontos[n];
    inicializa_pontos(lista_pontos, n);
    visualiza_pontos(lista_pontos, n);
    std::cout << "\n\n\n";
    mergesort(lista_pontos, n-1);
    visualiza_pontos(lista_pontos, n);
}

void teste_10_pontos(bool divide_and_conquer){
    int n = 10;
    Ponto lista_pontos[n];
    inicializa_pontos(lista_pontos, n);
    visualiza_pontos(lista_pontos, n);
    mostra_resultado(pontos_mais_proximos_bf(lista_pontos, n), n);
}

void teste_1000_pontos(bool divide_and_conquer){
    int n = 1000;
    Ponto lista_pontos[n];
    inicializa_pontos(lista_pontos, n);
    mostra_resultado(pontos_mais_proximos_bf(lista_pontos, n), n);
}

void teste_100000_pontos(bool divide_and_conquer){
    int n = 100000;
    Ponto lista_pontos[n];
    inicializa_pontos(lista_pontos, n);
    mostra_resultado(pontos_mais_proximos_bf(lista_pontos, n), n);
}

void teste_1000000_pontos(bool divide_and_conquer){
    int n = 1000000;
    Ponto lista_pontos[n];
    inicializa_pontos(lista_pontos, n);
    mostra_resultado(pontos_mais_proximos_bf(lista_pontos, n), n);
}

void teste_pontos_selecionados(bool divide_and_conquer){
    int n = 5;
    Ponto lista_pontos[n];
    lista_pontos[0].rotulo = "p0";
    lista_pontos[1].rotulo = "p1";
    lista_pontos[2].rotulo = "p2";
    lista_pontos[3].rotulo = "p3";
    lista_pontos[4].rotulo = "p4";

    lista_pontos[0].x = 1;
    lista_pontos[1].x = 2;
    lista_pontos[2].x = 3;
    lista_pontos[3].x = 4;
    lista_pontos[4].x = 6;

    lista_pontos[0].y = 1;
    lista_pontos[1].y = 1;
    lista_pontos[2].y = 3;
    lista_pontos[3].y = 1;
    lista_pontos[4].y = 3; 
    mostra_resultado(pontos_mais_proximos_bf(lista_pontos, n), n);
}

void inicializa_pontos(Ponto pontos[], int n){
    unsigned seed = time(0);

    srand(seed);
    for(int i = 0; i < n; i++){
        pontos[i].rotulo = "p" + std::to_string(i);
        pontos[i].x = rand()%11;
        pontos[i].y = rand()%11;
    }
}
