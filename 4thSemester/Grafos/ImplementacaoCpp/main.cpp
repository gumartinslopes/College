#include <iostream>
#include "./header files/grafo.hpp"
#include "./header files/matriz.hpp"
using namespace std;
void teste_grafo_direcionado_nao_ponderado();
void teste_grafo_direcionado_ponderado();
void teste_grafo_nao_direcionado_ponderado();
void teste_grafo_nao_direcionado_nao_ponderado();

//descomente para testar algum tipo de grafo
int main(void){
    teste_grafo_direcionado_nao_ponderado();
    //teste_grafo_direcionado_ponderado();
    //teste_grafo_nao_direcionado_ponderado();
    //teste_grafo_nao_direcionado_nao_ponderado();
    cout << "Fim do programa";
    return 0;
}

void teste_grafo_direcionado_nao_ponderado(){
    //criamos um grafo(max_vertices, direcionado, ponderado)              
    Grafo g = Grafo(10, false, false);
    g.add_vertice("Paulo");
    g.add_vertice("Pedro");
    g.add_vertice("Pepe");
    g.add_vertice("Pamela");
    g.add_vertice("Paulin");
    g.conecta("Paulo", "Pamela");
    g.conecta("Paulin","Pepe");
    g.conecta("Pamela","Pedro");
    g.log();
    g.mostra_adjacencias("Pepe");
}

void teste_grafo_direcionado_ponderado(){
    //criamos um grafo(max_vertices, direcionado, ponderado)              
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

void teste_grafo_nao_direcionado_ponderado(){
    //criamos um grafo(max_vertices, direcionado, ponderado)              
    Grafo g = Grafo(10, false, true);
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

void teste_grafo_nao_direcionado_nao_ponderado(){
    //criamos um grafo(max_vertices, direcionado, ponderado)              
    Grafo g = Grafo(10, false, false);
    g.add_vertice("Silvio");
    g.add_vertice("Max");
    g.add_vertice("Tio Sukita");
    g.add_vertice("Chris");
    g.add_vertice("Ilo");
    g.conecta("Tio Sukita", "Max");
    g.conecta("Silvio","Chris");
    g.conecta("Chris","Ilo");
    g.log();
    g.mostra_adjacencias("Tio Sukita");
}