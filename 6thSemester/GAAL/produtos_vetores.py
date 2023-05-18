def produto_escalar(a, b):
    result = 0
    for i in range(len(a)):
        result += a[i] * b[i]
    return result

v1 = (1,-3,5)
v2 = (7,2,1)

prod_vet = produto_escalar(v1,v2)
print(f"O produto escalar entre v1 e v2 eh {prod_vet}")
