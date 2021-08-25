"""
6
1 2
2 3
3 1
10 11
100 10
11 100
1 100
2 3
0 0

No
Yes 0
"""

import sys

def main():
    input = sys.stdin.readline

    data = {}
    for _ in range(int(input())):
        a, b = map(int, input().split())
        data[a] = b
    
    while 1:
        a, b = map(int, input().split())
        if a == 0 and b == 0:
            break
        
        c = -1
        v = set()
        while 1:
            if a == b:
                print("Yes", c)
                break
            if a in data and a not in v:
                v.add(a)
                a = data[a]
                c += 1
            else:
                print("No")
                break
main()