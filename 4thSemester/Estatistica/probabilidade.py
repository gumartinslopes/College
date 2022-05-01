from poisson import poisson
from modelo_binomial import modelo_binomial


print("(1)Poisson\n(2)Modelo Binomial")
opcao = int(input())
result = 0

if opcao == 1:
    result = poisson()
else:
    result = modelo_binomial()

print("Resultado: {} ou {:.2f}%".format(result, result * 100))
