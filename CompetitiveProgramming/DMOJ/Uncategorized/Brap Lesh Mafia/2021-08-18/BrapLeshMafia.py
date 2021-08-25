"""

4 12
1 4
2 9
3 8
5 5

11
"""

import sys

def main():
    input = sys.stdin.readline

    n, m = map(int, input().strip().split())
    summ = 0
    for i in range(n):
        a, b = map(int, input().strip().split())
        summ += a*b
    print(summ%m)
main()