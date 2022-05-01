import math

def combinacao(a, b):
    return math.factorial(int(a)) / (math.factorial(int(b)) * math.factorial(int(a - b)))


