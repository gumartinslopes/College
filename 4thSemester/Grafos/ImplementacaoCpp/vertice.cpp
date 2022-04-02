#include <string>
#include <iostream>
#include "./header files/vertice.hpp"

Vertice::Vertice(std::string rotulo){
    this->rotulo = rotulo;
    this->grau_incidencia = this->grau_saida = 0;
}

std::string Vertice::toString(){
    std::string str = "\nRotulo: " + this->rotulo;
    str += "\nGrau de incidecia" + std::to_string(this->grau_incidencia); 
    str += "\nGrau de saida" + std::to_string(this->grau_saida); 
    return str;
}

void Vertice::add_grau_incidencia(){
    this->grau_incidencia++;
}

void Vertice::add_grau_saida(){
    this->grau_saida++;
}

//incrementa ambos os graus (exclusivo para grafos nao direcionados)
void Vertice::add_grau(){
    this->grau_incidencia += 1;
    this->grau_saida = grau_incidencia;
}

//metodo criado apenas para facilitar a legibilidade do código
int Vertice::get_grau(){
    return this->grau_incidencia;
}

int Vertice::get_grau_saida(){
    return this->grau_saida;
}

int Vertice::get_grau_incidencia(){
    return this->grau_incidencia;
}

std::string Vertice::get_rotulo(){
    return this->rotulo;
}




