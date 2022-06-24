tabelaVerdade = [] # A tabela deve ser criada fora e antes da função
def geraTabelaVerdade(m,n): # Função para gerar uma tabela verdade (número de variáveis da tabela(fixo), número de variáveis da tabela(recursivo))
    bits=2**m # determina quantos linhas terá a tabela, valor fixo
    repeticoes_coluna=(bits//(2**n))*2
    repeticoes_linha=(2**n//2)//2
    contador=0 # Esse contador será sempre incrementado até a quantidade de bits e será zerado quando a função repetir
    if not tabelaVerdade: # essa condição cria a primeira coluna da tabela
        for i in range(bits // 2):
            tabelaVerdade.append([0])
        for i in range(bits // 2):
            tabelaVerdade.append([1])
            
    for j in range(repeticoes_coluna):
        for i in range(repeticoes_linha):
            tabelaVerdade[contador].append(0)
            contador += 1
        for i in range(repeticoes_linha):
            tabelaVerdade[contador].append(1)
            contador += 1
    if n==1:
        return tabelaVerdade
    else:
        return geraTabelaVerdade(m,n-1)


def tabela_verdade(quant):
    return geraTabelaVerdade(quant, quant)