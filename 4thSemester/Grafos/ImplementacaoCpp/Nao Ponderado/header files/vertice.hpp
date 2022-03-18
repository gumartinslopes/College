#pragma once
#include <iostream>
#include <string>

class Vertice{
private:
    int grau_incidencia, grau_saida;
    std::string rotulo;
public:
    // Por padrão se não houver rótulo rotulamos unlabled no construtor
    Vertice(std::string rotulo = "unlabled");   
    std::string toString();
    int get_grau();
    int get_grau_saida();
    int get_grau_incidencia();
    std::string get_rotulo();
    void add_grau();
    void add_grau_incidencia();
    void add_grau_saida();
};

