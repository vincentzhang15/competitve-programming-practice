"""
3 6
Math
TOK
English

Go to Metro
2


1: TOK
2: english
3: chem
4: math
"""

import sys

def main():
    input = sys.stdin.readline

    data = {
        "TOK":1,
        "English":2,
        "Chemistry":3,
        "Math":4
    }

    c, n = map(int, input().split())
    sub = [data[input().strip()] for _ in range(c)]

    if sum(sub) <= n:
        print("YEA BOI")
    else:
        sub.sort(reverse=True)
        while 1:
            if n - sub[-1] < 0:
                break
            n -= sub.pop()
        print("Go to Metro")
        print(c - len(sub))

main()