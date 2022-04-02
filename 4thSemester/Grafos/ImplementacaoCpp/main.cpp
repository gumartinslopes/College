#include <iostream>
#include "./header files/grafo.hpp"
#include "./header files/matriz.hpp"
using namespace std;

void teste_grafos(){
    Grafo g = Grafo(10, true, true);
    g.add_vertice("v1");
    g.add_vertice("v2");
    g.add_vertice("v3");
    g.add_vertice("v4");
    g.conecta("v1", "v2");
    g.conecta("v2","v3");
    g.conecta("v2","v4");
    g.log();
    g.mostra_adjacencias("v2");
}

int main(void){
    teste_grafos();
    //teste_matriz();
    cout << "Fim do programa";
    return 0;
}
