from commons import combinacao
import math
def modelo_binomial():
    print("n =",end = " ")
    n = float(input())
    print("p =", end = " ")
    p = float(input())
    print("k =", end = " ")
    k = float(input())
    return combinacao(n, k) * math.pow(p, k) * math.pow((1 - p), (n - k))

