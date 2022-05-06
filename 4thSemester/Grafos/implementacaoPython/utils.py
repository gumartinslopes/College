import os

def espera_clique():
    print("Pressione qualquer tecla para continuar...")
    input()

def intro():
    print("*** GRAFO EM PYTHON ***")

def limpa_tela():
    os.system("cls" if os.name == "nt" else "clear")

def ler_int(min, max, texto):
    num = min - 1
    validado = False
    while validado == False:
        print(texto, end="\n->")
        num = int(input())
        if num > min and num < max:
            validado = True
        else:
            print(f"Valor inválido, insira um valor que esteja dentro do intervalo:[{min}, {max}]")
    return num

def ler_sim_nao(texto):
    validado = False
    entrada = ""
    while validado == False:
        print(texto, end = "(s/n)\n--> ")
        entrada = input()
        if(entrada == "s" or entrada == "n"):
            validado = True
        else:
            print("Valor inválido!Insira apenas (s/n)")
    return entrada
