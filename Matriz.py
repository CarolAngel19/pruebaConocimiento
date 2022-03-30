import numpy as np

def validPlace(matrix,x,y):
    if x < 0 or x >= len(matrix) or y < 0 or y >= len(matrix[0]) or matrix[x][y] == 1:
        return False
    return True


def paintAllColumnAndRowMatrix(matrix, column, row):
    for j in range(len(matrix[row])):
        matrix[row][j] = 1
    for i in range(len(matrix)):
        matrix[i][column] = 1
    print(matrix)
    

if _name_ == "_main_":
    matrix = np.zeros((5,10), dtype=int)
    for i in range(0,5):
        print(f"Lugar seleccionado {i},{i}. Es valido? {validPlace(matrix,i,i)}")
        paintAllColumnAndRowMatrix(matrix, i, i)