#include "./header files/grafo.hpp"
#include "./header files/matriz.hpp"
#include <iostream>

Grafo::Grafo(int qtd_vertices, bool direcionado, bool ponderado){
    this->direcionado = direcionado;
    this->qtd_max_vertices = qtd_vertices;
    this->ponderado = ponderado;
    this->qtd_atual_vertices = 0;
    this->vertices = new Vertice[qtd_max_vertices];   
    this->matriz_adj = new Matriz("Matriz de Adjacencia", qtd_max_vertices);
    if(this->ponderado)
        this->matriz_peso = new Matriz("Matriz de Pesos",qtd_max_vertices);
}

Grafo::~Grafo(){
    delete []this->vertices;
    delete this->matriz_adj;
}
 
void Grafo::add_vertice(std::string rotulo){
    if(qtd_atual_vertices == qtd_max_vertices)
        std::cout<<"Quantidade maxima de vertices alcancada, impossivel inserir mais!\n";   
    else{
        Vertice novo_vertice = Vertice(rotulo);
        this->vertices[qtd_atual_vertices] = novo_vertice;
        qtd_atual_vertices++;
    }       
}

int Grafo::get_indice_vertice(std::string rotulo){
    int index = -1;
    int i = 0;
    while(index == -1 && i < this->qtd_atual_vertices){
        if(rotulo.compare(this->vertices[i].get_rotulo()) == 0)                 //se achou indice = indice
            index = i;                                                   //se nao achou indice = -1
        i++;
    }
    return index;
}

void Grafo::conecta(std::string rotulo_inicio, std::string rotulo_fim){
    int index_inicio, index_fim;
    index_inicio = this->get_indice_vertice(rotulo_inicio);
    index_fim = this->get_indice_vertice(rotulo_fim);
    
    if(index_fim >= 0 && index_inicio >= 0){
        Vertice *vi = &this->vertices[this->get_indice_vertice(rotulo_inicio)];
        Vertice *vf = &this->vertices[this->get_indice_vertice(rotulo_fim)];
       
        int valor_inicio = 1;
        int valor_fim = (this->direcionado == true) ? 0 : 1;
       
        std::cout << vi->get_rotulo() << " foi conectado com "<< vf->get_rotulo()<< std::endl;
       
        this->matriz_adj->add_aresta(index_inicio, index_fim, valor_inicio, valor_fim, this->direcionado);
       
        trata_graus(vi, vf);
       
        if(this->ponderado)
            adiciona_peso(index_inicio, index_fim);
        
        vi = vf = NULL;
    }
    else{
        std::cout << "Um dos grafos que voce tentou conectar nao foi inserido no grafo";
    }
}

void Grafo::adiciona_peso(int index_inicial, int index_fim){
    int peso;
    std::cout << "Insira o peso desejado para sua aresta: ";
    std::cin >> peso;
    this->matriz_peso->add_aresta(index_inicial, index_fim, peso, peso, this->direcionado);
}

//método que faz a alteração dos graus com as devidas checagens
void Grafo::trata_graus(Vertice *vi, Vertice *vf){
    if(this->direcionado == true){
        vi->add_grau_saida();
        vf->add_grau_incidencia();
    }
    else{
        vi->add_grau();
        vf->add_grau();
    }
}

//metodo auxiliar
bool Grafo::valida_vertice(std::string rotulo){
    bool validado =  this->get_indice_vertice(rotulo) > -1;
    if(!validado)
        std::cout << "O vertice " << rotulo << " nao foi inserido no grafo" << std::endl;
    return validado;
}

//métodos de log
void Grafo::log(){
    std::cout << " ***** LOG DO GRAFO *****" << std::endl;
    std::cout << "Tipo de grafo: " << ((this->direcionado)?"direcionado":"nao direcionado") << std::endl;
    std::cout << "Quantidade maxima de vertices : " << this->qtd_max_vertices << std::endl;
    std::cout << "Quantidade de vertices inseridas no grafo: " << this->qtd_atual_vertices << std::endl;
    this->print_lista_vertices();
    this->matriz_adj->print_matriz();
    this->matriz_peso->print_matriz();
}

void Grafo::print_lista_vertices(){
    std::cout << "Seu grafo em lista:\n[\n";
    for(int i = 0; i < this->qtd_atual_vertices; i++){
       std::cout << this->vertices[i].get_rotulo() <<", "<< std::endl;
    }
    std::cout << "]";
}

void Grafo::mostra_adjacencias(std::string rotulo){
    if(this->valida_vertice(rotulo)){
        int* adjacencias = this->matriz_adj->get_adjacencias(this->get_indice_vertice(rotulo));
        std::cout << rotulo <<" se conecta com: " <<"[";
        for(int i = 0; i < this->qtd_atual_vertices; i++)
            if(adjacencias[i] != 0)
                std::cout <<  vertices[i].get_rotulo() << ((i < qtd_atual_vertices - 1)?", ":""); 
        std::cout << "]" << std::endl;
        adjacencias = NULL; 
    }
}   