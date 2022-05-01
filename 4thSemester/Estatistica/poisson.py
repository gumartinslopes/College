import math

def poisson():
    print("Lambda:", end=" ")
    lbd = float(input())
    print("K:", end=" ")
    k = int(input())
    k_fatorial = math.factorial(k)
    return (math.pow(math.e,-lbd)) * math.pow(lbd, k) / math.factorial(k)
