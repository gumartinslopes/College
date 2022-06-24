from neuronio import neuronio
from tabela_verdade import tabela_verdade
from tabelas_verdade import *

def and_target(tabela):
    target = []
    for linha in tabela:
        resultado_linha = 1
        for valor in linha:
            resultado_linha = resultado_linha and valor
        target.append(resultado_linha)
    return target

def or_target(tabela):
    target = []
    for linha in tabela:
        resultado_linha = 0
        for valor in linha:
            resultado_linha = resultado_linha or valor
        target.append(resultado_linha)
    return target

def xor_target(tabela):
    target = []
    for linha in tabela:
        resultado_linha = linha[0]
        for i in range(1, len(linha)):
            resultado_linha = resultado_linha ^ linha[i]
        target.append(resultado_linha)
    return target

def teste_tabela(tabela, target, nome_teste, show):
    print(f"** {nome_teste} **")
    n = neuronio(tabela, target, 50)
    result = n.fit()
    print(f'Target esperado: {target}')
    print(f'Resultado obtido: {result}')
    print(f'Épocas gastas: {n.epoca_atual}')
    if(show):
        print(f'\nValores inseridos:{tabela}')


print('Quantos valores a sua tabela terá?', end='\n->')
quant = int(input())
tabela = tabela_verdade(quant)
print('Qual a operação que você deseja realizar? ', end='\n(and = 0)\n(or = 1)\n(xor = 2)\n->')
operacao = input()
target = 0
if operacao == '0':
    target = and_target(tabela)
elif operacao == '1':
    target = or_target(tabela)
else:
    target = xor_target(tabela)
teste_tabela(tabela,target,f'Teste do usuário com {quant} variaveis', False)
