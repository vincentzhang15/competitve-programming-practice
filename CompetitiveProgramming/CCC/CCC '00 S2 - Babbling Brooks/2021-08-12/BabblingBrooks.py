"""
3
10
20
30
99
1
50
88
3
88
2
77
"""

import sys

def main():
    input = sys.stdin.readline

    s = [int(input()) for _ in range(int(input()))]
    while 1:
        x = int(input())
        if x == 77:
            break
        elif x == 88:
            a = int(input())
            s[a-1] += s.pop(a)
        else:
            a = int(input())
            b = int(input())
            v = s[a-1] * b/100
            s[a-1] -= v
            s.insert(a-1, v)
    
    for ss in s:
        print(round(ss), end=" ")
main()