"""
365 12

11

"""

import sys

def main():
    input = sys.stdin.readline

    n, m = map(int, input().split())
    while n>0:
        cur = abs(n-m)
        nxt = abs(n//2-m)
        if nxt > cur:
            print(n)
            break
        n //= 2
main()