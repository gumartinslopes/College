from asyncio.windows_events import NULL
from matriz import Matriz  
from vertice import Vertice
from utils import *

class Grafo:
    def __init__(self, max_vertices, ponderado, direcionado):
        self._vertices = []
        
        self._estrutura = Matriz("Matriz de Adjacência", max_vertices, max_vertices)
        if(ponderado):
            self._estrutura_pesos = Matriz("Matriz de Pesos", max_vertices, max_vertices)

        self._max_vertices = max_vertices
        self._qnt_atual_vertices = 0
        self._ponderado = ponderado
        self._direcionado = direcionado

    def add_vertice(self, rotulo):
        if self.existe_vertice(rotulo) == False:
            if(self._qnt_atual_vertices < self._max_vertices):
                v = Vertice(rotulo)
                self._vertices.append(v)
                self._qnt_atual_vertices += 1
            else:
                print("Quantidade máxima de vértices já inserida")
                espera_clique()
        else:
            print("Vertice já inserido no grafo!")
            espera_clique()
    
    def log(self):
        tipo_grafo_ponderacao = "ponderado" if self._ponderado else "não ponderado"
        tipo_grafo_direcao = "direcionado" if self._direcionado else "nao direcionado"
        
        print(f"Tipo de grafo: {tipo_grafo_direcao} e {tipo_grafo_ponderacao}")
        print(f"Quantidade máxima de vértices: {self._max_vertices}")
        print(f"Quantidade atual de vertices: {len(self._vertices)}")

        self.mostra_lista_vertices()
        self._estrutura.display()
        if(self._ponderado):
            self._estrutura_pesos.display()
    
    def conecta(self, rotulo_v1, rotulo_v2):
        indice_v1 = self.get_indice(rotulo_v1)
        indice_v2 = self.get_indice(rotulo_v2)
        peso = 0
        if indice_v1 > -1 and indice_v2 > -1:# validacao da conexao
            if(self._ponderado):
                print("Insira o peso da aresta", end=": ")
                peso = int(input())
                self._estrutura_pesos.add_aresta(indice_v1, indice_v2, self._ponderado, peso)
                
            self._estrutura.add_aresta(indice_v1, indice_v2, self._direcionado)
            if(self._direcionado):
                self._vertices[indice_v1].update_grau_saida()
                self._vertices[indice_v2].update_grau_incidencia()
            else:
                self._vertices[indice_v1].update_grau()
                self._vertices[indice_v2].update_grau()
        else:
            print("ATENÇÂO -> algum dos rótulos inseridos não está presente no seu grafo")
    
    def _get_adjacencias(self, rotulo):
        indice = self.get_indice(rotulo)
        if(indice!= -1):
            adjacencias_raw = self._estrutura.get_adjacencias(indice)
            adjacencias = []
            for i in range(len(adjacencias_raw)):  
                if adjacencias_raw[i] == 1:
                    adjacencias.append(self._vertices[i])
            return adjacencias
        return []
                
                       
    def mostra_adjacencias(self, rotulo):
        indice = self.get_indice(rotulo)
        if(indice != -1):
            adjacencias = self._get_adjacencias(rotulo)
            
            print(f"Vértices adjacentes ao vértice {rotulo}:")
            print("[", end="")
            for i in range(len(adjacencias)):
                print(adjacencias[i].rotulo, end = "")
                print(""if i == self._qnt_atual_vertices - 1 else ",", end = "")
            print("]")
            espera_clique()   
        else: 
            print("Vértice não existente!");
            espera_clique()

    
    def get_indice(self, rotulo):
        result = 0
        for i in range(len(self._vertices)):
            if self._vertices[i].rotulo == rotulo:
                return result
            result += 1 
        return -1   # nao encontrou o vertice
    
    def existe_vertice(self,rotulo):
        return self.get_indice(rotulo) != -1

    def mostra_lista_vertices(self):
        print("Vertices presentes no seu grafo:\n[")
        
        for i in range(self._qnt_atual_vertices):
            print(self._vertices[i].to_string())
        print("]")      