# LCS Problem
# Given two sequences a and b find the longest common
# subsequence between the two sequences

def build_matrix(str_a, str_b):
    matrix = [[] for k in range(len(a) + 1)]
    for i in range(len(matrix)):
        matrix[i] = [0 for k in range(len(b) + 1)]
    return matrix

def lcs(a, b):
    matrix = build_matrix(a, b)
    for i in range(1, len(a) + 1):
        for j in range(1, len(b) + 1):
            if(a[i - 1] == b[j - 1]):
                matrix[i][j] = matrix[i-1][j-1] + 1
            else:
                matrix[i][j] = max(matrix[i-1][j], matrix[i][j-1])
    
    return matrix[-1][-1]


a = "fcab"
b = "abdc"
m = build_matrix(a, b)

print(lcs(a, b))
