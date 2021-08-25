"""
PyPy3 submission.

10
3 5
3
2 6
4 5
3 3


6
"""

import sys

def main():
    input = sys.stdin.readline
    
    n = int(input().strip())
    data = [0] * (n + 2)
    x, y = map(int, input().strip().split())
    for i in range(int(input().strip())):
        l, r = map(int, input().strip().split())
        data[l] += 1
        data[r+1] -= 1
    for i in range(2, n+1):
        data[i] += data[i-1]
    print(sum(data[x:y+1]))
main()