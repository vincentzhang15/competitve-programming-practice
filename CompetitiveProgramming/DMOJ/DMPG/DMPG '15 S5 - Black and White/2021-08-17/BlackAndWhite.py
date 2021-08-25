"""
MLE


10 2
0 0 10 10
2 2 6 6

64
"""

import sys

def main():
    input = sys.stdin.readline

    n, m = map(int, input().split())

    data = [[0]*(n+1) for _ in range(n+1)]
    for i in range(m):
        a, b, c, d = map(int, input().strip().split())
        data[a][b] ^= 1
        data[a+c][b] ^= 1
        data[a][b+d] ^= 1
        data[a+c][b+d] ^= 1
    for i in range(n):
        for j in range(1, n):
            data[i][j] ^= data[i][j-1]
    for i in range(1, n):
        for j in range(n):
            data[i][j] ^= data[i-1][j]

    e = 0
    for i in range(n):
        for j in range(n):
            if data[i][j]:
                e += 1
    print(e)
main()