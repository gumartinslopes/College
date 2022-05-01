import math

print("Lambda:", end=" ")
lbd = int(input())
print("K:", end=" ")
k = int(input())
k_fatorial = math.factorial(k)
result = (math.pow(math.e,-lbd)) * math.pow(lbd, k) / math.factorial(k)
print("Resultado: {} ou {:.2f}%".format(result, result * 100))
