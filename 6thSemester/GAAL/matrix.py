import numpy as np

def ordem(m):
    #      m_linhas,n_colunas
    return len(m), len(m[0])
    
def multiplicacao_escalar(m, e):
    num_linhas = len(m)
    num_colunas = len(m[1])
    produto = np.zeros((num_linhas, num_colunas))

    for i in range(len(m)):
        for j in range(len(m[i])):
            produto[i][j] = m[i][j] * e
    return produto

def multiplica_matrizes(m1, m2):
    num_linhas_m1, num_col_m1 = ordem(m1)
    num_linhas_m2, num_col_m2 = ordem(m2)
    if num_col_m1 != num_linhas_m2:
        print("Impossivel realizar a multiplicacao das duas matrizes!")
        return
    
    multiplicacao = np.zeros((num_linhas_m1, num_col_m2))
    for i in range(num_linhas_m1):
        for j in range(num_col_m2):
            for k in range(num_col_m1):
                multiplicacao[i][j] += m1[i][k] * m2[k][j]    
    return multiplicacao

def soma_matrizes(m1, m2):
    num_linhas_m1, num_col_m1 = ordem(m1)
    num_linhas_m2, num_col_m2 = ordem(m2)
    soma = np.zeros((num_linhas_m1, num_col_m1))
    
    if not num_linhas_m1 == num_linhas_m2 or not num_col_m1 == num_col_m2:
        print("Impossivel realizar a soma de matrizes!")
        return 

    for i in range(num_linhas_m1):
        for j in range(num_col_m1):
            soma[i][j] = m1[i][j] + m2[i][j]
    return soma

m1 = [[1,1],[-1,-1]]
m2 = [[-1,-1], [1,1]]

print("Matriz 1")
print(m1, end = "\n\n")

print("Matriz 2")
print(m2, end = "\n\n")

print("Matriz 1 multiplicada com a matriz 2") 
print(multiplica_matrizes(m1, m2))
