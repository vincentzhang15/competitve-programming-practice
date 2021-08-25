"""
3
4
3 10 8 14
1 11 12 12
6 2 3 9


start: 1 1
    3: go 1 3, 3 1
    8: go 1 8, 8 1
          2 4, 4 2
product of all squares are same
store product of grid location as key and cell value as value
makes adj list instead of matrix
no need to calculate factors because product contains list of all cell values

"""

import sys

def dfs(data, s, e):
    vis = set([s])
    stack = [s]
    while stack:
        top = stack.pop()
        if top in data:
            for d in data[top]:
                if d not in vis:
                    if d == e:
                        return "yes"
                    vis.add(d)
                    stack.append(d)
    return "no"

def main():
    input = sys.stdin.readline

    n = int(input())
    m = int(input())

    data = {}
    for i in range(1, n+1):
        line = list(map(int, input().split()))
        for j in range(1, m+1):
            c = line[j-1]
            if i*j in data:
                data[i*j].append(c)
            else:
                data[i*j] = [c]
    print(dfs(data, 1, n*m))
main()