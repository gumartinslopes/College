def get_determinat(m):
    val_1 = m[0][0] * m[1][1] * m[2][2]
    val_2 = m[0][1] * m[1][2] * m[2][0]
    val_3 = m[0][2] * m[1][0] * m[2][1]

    val_4 = m[2][0] * m[1][1] * m[0][2]
    val_5 = m[2][1] * m[1][2] * m[0][0]
    val_6 = m[2][2] * m[1][0] * m[0][1]
    
    return val_1 + val_2 + val_3 - val_4 - val_5 - val_6
matrix = [[4,4,3],[0,4,0],[3,4,4]]

print(get_determinat(matrix))
