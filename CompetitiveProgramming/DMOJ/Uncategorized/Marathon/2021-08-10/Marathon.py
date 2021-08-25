"""
10 3
5 6 7 8 3 4 5 6 1 2
1 3
2 4
1 10
"""

import sys

def main():
    input = sys.stdin.readline
    n, q = map(int, input().split())
    data = [0] + list(map(int, input().split()))

    for i in range(1, n+1):
        data[i] += data[i-1]

    for i in range(q):
        a, b = map(int, input().split())
        print(data[-1] - data[b] + data[a-1])
main()