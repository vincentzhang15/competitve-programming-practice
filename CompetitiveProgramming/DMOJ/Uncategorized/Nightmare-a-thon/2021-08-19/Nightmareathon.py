"""
VERDICT Fastest Python 3 Submission
5.49s
Next 5 Places
6.46s
7.13s
7.15s
7.17s 
7.19s

VERDICT Fastest PyPy3 Submission
3.22s
Next 5 Places
3.31s
3.55s
3.57s
5.04s
10.03s


INPUT
7 2
5 4 5 2 3 1 5
2 4
1 6


5 2
5 1

"""

import sys

def main():
    input = sys.stdin.readline

    n, q = map(int, input().strip().split())
    rat = [0, *map(int, input().split()), 0]

    lm = [0]*(n+2)
    lf = [0]*(n+2)
    maxx = -1
    for i in range(1, n+1):
        if rat[i] > maxx:
            maxx = rat[i]
            lf[i] = 1
        elif rat[i] == maxx:
            lf[i] = lf[i-1]+1
        else:
            lf[i] = lf[i-1]
        lm[i] = maxx
    
    rm = [0]*(n+2)
    rf = [0]*(n+2)
    maxx = -1
    for i in range(n, 0, -1):
        if rat[i] > maxx:
            maxx = rat[i]
            rf[i] = 1
        elif rat[i] == maxx:
            rf[i] = rf[i+1]+1
        else:
            rf[i] = rf[i+1]
        rm[i] = maxx

    # Process queries.
    for _ in range(q):
        a, b = map(int, input().strip().split())

        maxl = lm[a-1]
        maxr = rm[b+1]

        if maxl == maxr:
            print(maxl, lf[a-1] + rf[b+1])
        elif maxl > maxr:
            print(maxl, lf[a-1])
        else:
            print(maxr, rf[b+1])

main()