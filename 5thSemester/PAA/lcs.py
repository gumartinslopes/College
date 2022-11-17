def lcs_recursive(a, b, x = None,y = None):
    x = len(a) - 1 if x == None else x
    y = len(b) - 1 if y == None else y
    
    if x == -1 or y == -1:
        return 0

    elif a[x] == b[y]:
        return 1 + lcs_recursive(a, b, x-1, y-1)
    
    else:
        return max(lcs_recursive(a, b, x-1, y), lcs_recursive(a, b, x, y-1))

a = 'abcdef'
b = 'agedf'
result_recursive = lcs_recursive(a, b)
result_table = 0
print(f'The recursive solution found the largest commom sequence of: ', result_recursive)
print(f'The recursive solution found the largest commom sequence of: ', result_table)

