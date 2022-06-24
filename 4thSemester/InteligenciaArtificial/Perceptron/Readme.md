# Perceptron em Python
Aqui iremos implementar(na mão) o algoritmo perceptron em python.
## O que é o Perceptron?
Uma das primeiras redes neurais apresentadas. É um algoritmo de aprendizado supervisionado de correção de erro que possui apenas um neurônio e utiliza uma função de ativação de tipo limiar.

## Como Funciona?
Cada neurônio possui um conjunto de entradas(que chamaremos de x) e um conjunto de pesos(que chamaremos de w), um para cada entrada. 
 - 1. No início da iteração, para cada entrada, iremos somar a multiplicação dos pesos pela entrada subtraída do bias. 
 - 3. Fazemos o somatório das entradas com cada peso subtraindo o bias.
 - 2. Aplicamos a função de ativação.
 - 3. A partir da função de ativação calculamos o erro.


