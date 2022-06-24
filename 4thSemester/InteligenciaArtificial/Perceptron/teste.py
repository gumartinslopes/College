from neuronio import neuronio
tabela = [[0,0], [0,1], [1,0], [1,1]]
target = [0,0,0,1]
n = neuronio(tabela, target, 50)
print(n.fit())