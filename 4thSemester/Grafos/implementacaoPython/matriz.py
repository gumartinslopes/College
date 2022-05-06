class Matriz:
    def __init__(self, nome, n_linhas, n_colunas):
        self._matriz = [[0] * n_linhas for i in range(n_linhas)]
        self._nome = nome
        self._n_linhas = n_linhas
        self._n_colunas = n_colunas

    def add_aresta(self, v1, v2, grafo_direcionado, valor=1):
        if grafo_direcionado == False: 
            self._matriz[v2][v1] = valor
        self._matriz[v1][v2] = valor 
        
    def get_adjacencias(self, v):
        return self._matriz[v] 

    def display(self):
        print("\n" + self._nome)
        for i in range(self._n_linhas):
            for j in range(self._n_colunas):
                print(self._matriz[i][j], end = " ")
            print()
            
    def get_adjacencias(self,index):
        return self._matriz[index]