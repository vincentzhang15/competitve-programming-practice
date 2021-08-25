"""

3
1 2
2 3
3 1
3 2

"""

import sys

v = set()

def dfs(data, s):
    global v
    v.add(s)
    for next in data.get(s, []):
        if next not in v:
            dfs(data, next)

def main():
    input = sys.stdin.readline
    
    n = int(input())
    data = {}
    for i in range(n):
        a, b = map(int, input().split())
        if a in data:
            data[a].append(b)
        else:
            data[a] = [b]

    s, e = map(int, input().split())
    dfs(data, s)
    print( "Not Tangled" if e not in v else "Tangled" )

main()