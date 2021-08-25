"""
7
1 3
1 4
2 5
3 7
4 7
6 9
7 8

3

VERDICT: Fastest Python 3 Submission
6.03s

Next 5 Places:
9.67s
10.17s
10.18s
10.90s
14.99s

VERDICT: Fastest PyPy3 Submission
2.01s

Next 5 Places:
2.58s
2.59s
2.60s
4.81s
4.84s

"""

import sys

def main():
    input = sys.stdin.readline

    data = [0] * (int(1e7)+1)

    maxIdx = 0
    for i in range(int(input())):
        a, b = map(int, input().split())
        data[a] += 1
        data[b] -= 1
        maxIdx = max(b, maxIdx)

    maxx = data[0]
    for i in range(1, maxIdx+1):
        data[i] += data[i-1]
        maxx = max(maxx, data[i])
    print(maxx)

main()