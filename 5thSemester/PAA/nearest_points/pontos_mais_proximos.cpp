#include "./header_files/pontos_mais_proximos.hpp"

//(i) solucao O(n^2)que utiliza a técnica de força bruta para a obtenção do resultado.
Resultado pontos_mais_proximos_bf(Ponto pontos[], int n){
    //maior inteiro possível
    Resultado r;
    float distancia_atual;
    r.distancia = 2147483647;

    for(int i = 0; i < n - 1; i++){
        for(int j = i + 1; j < n; j++){
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

//(i) solucao O(n^log(n))que utiliza a técnica divisão e conquista para a obtenção dos resultados.
Resultado pontos_mais_proximos_dq(Ponto pontos[], int n){
    Resultado r;
    return r;
}