"""
CCC '18 J3 - Are we there yet?

Notice that the result is a 5x5 symmetric matrix with 0 main diagonal.
Find prefix sum and add the symmetric position. Or take the transpose, then sum.

@author Vincent Zhang
@since 24 June 2022
@context Programming practice
"""

import sys

def main():
    input = sys.stdin.readline

    data = list(map(int, input().split()))
    E = len(data)
    mat = [[0]*(E+1) for _ in range(E+1)]
    
    # Find prefix sum.
    for i in range(E+1):
        for j in range(i+1, E+1):
            mat[i][j] = data[j-1] + mat[i][j-1]
        
    # Add symmetric position.
    for i in range(E+1):
        for j in range(i):
            mat[i][j] = mat[j][i]
    
    # Output result.
    for row in mat:
        for col in row:
            print(col, end=" ")
        print()

if __name__=="__main__":
    main()