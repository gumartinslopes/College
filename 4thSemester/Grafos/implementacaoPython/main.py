from grafo import Grafo
from utils import * 

def cria_grafo():
    input_direcao = ""
    input_ponderacao = ""

    input_direcao = ler_sim_nao("O seu grafo é direcionado?")
    input_ponderacao = ler_sim_nao("O seu grafo é ponderado?")
    print("Qual a quantidade maxima de vértices no seu grafo?", end = "\n--> ")
    quant_vertices = int(input())

    tipo_direcao = True if input_direcao == "s" else False
    tipo_ponderacao = True if input_ponderacao == "s" else False
    g =  Grafo(quant_vertices, tipo_ponderacao, tipo_direcao)
    return g

def conectar(g):
    rotulo_v1 = ""
    rotulo_v2 = ""

    print("Qual o rótulo do primeiro vértice?", end="\n--> ")
    rotulo_v1 = input()
    print("Qual o rótulo do segundo vértice?", end="\n--> ")
    rotulo_v2 = input()
    
    g.conecta(rotulo_v1, rotulo_v2)

def inserir(g):
    print("Qual o rótulo do vértice que voce vai inserir?", end="\n--> ")
    rotulo_v = input()
    g.add_vertice(rotulo_v)

def mostra_adjacencia(g):
    print("Insira o rótulo do vertice", end = ": ")
    rotulo_v = input()
    g.mostra_adjacencias(rotulo_v)

def lida_escolha(escolha, g):
    fim_programa = False
    if(escolha == "0"):
        fim_programa = True   
    elif escolha == "1":
        inserir(g)
    elif escolha == "2":
        conectar(g)
    elif escolha == "3":
        limpa_tela()
        g.log()
        espera_clique()
        input()
    elif escolha == "4":
        mostra_adjacencia(g)
    else:
        print("Entrada inválida, tente novamente!")
        espera_clique()
    return fim_programa

def menu():
    fim_programa = False
    g = cria_grafo()
    while not fim_programa:
        limpa_tela()
        intro() 
        print("Inserir um vertice", end="(1)\n")
        print("Conectar dois vertices", end="(2)\n")
        print("Gerar relatorio do grafo", end="(3)\n")
        print("Buscar adjacencias", end="(4)\n")
        print("Sair do programa", end="(0)\n")
        print("--> ", end = "")
        escolha = input()
        fim_programa = lida_escolha(escolha, g)
        limpa_tela()
menu()