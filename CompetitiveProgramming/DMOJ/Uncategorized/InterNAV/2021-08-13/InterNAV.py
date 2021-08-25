"""
5
4
O3OO2
OOOO#
1###4
#5OOO


1 2 3


"""

import sys

def main():
    input = sys.stdin.readline

    c, r = int(input()), int(input())

    grid = [list(input().strip()) for _ in range(r)]
    vis = [[0 for _ in range(c)] for _ in range(r)]
    for i in range(r):
        idx = "".join(grid[i]).find('1')
        if idx != -1:
            s = (i, idx)
            break

    d = (1, 0, -1, 0, 1)
    stack = [s]
    ans = set(grid[s[0]][s[1]])
    while stack:
        top = stack.pop()
        for i in range(4):
            x = top[0]+d[i]
            y = top[1]+d[i+1]
            if x>=0 and x<r and y>=0 and y<c and not vis[x][y] and grid[x][y] != '#':
                vis[x][y] = 1
                stack.append((x, y))
                if grid[x][y].isnumeric():
                    ans.add(grid[x][y])
    for a in sorted(ans):
        print(a, end=" ")
main()