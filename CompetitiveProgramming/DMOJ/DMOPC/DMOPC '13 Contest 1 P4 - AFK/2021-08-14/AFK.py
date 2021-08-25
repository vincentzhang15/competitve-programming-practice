"""
Sample Input
2
27 5
OOCOOOOOOOOOOOOOOOOOOOOOOOO
XXXXXXXXXXXXXXXXXXXXXXXXXXO
OOOOOOOOOOOOOOOOOOOOOOOOOOO
OXXXXXXXXXXXXXXXXXXXXXXXXXX
OOOOOOOOOOOOOOOOOOOOOOOOOWO
5 5
OOOOO
OOOOO
OXXOO
OWXCO
OOXOO

Sample Output
#notworth
8

VERDICT: Fastest Python 3 Submission
7.23s

The times for the following 4 places are:
8.71s
9.27s
9.73s
10.17s

"""

import sys, collections

def bfs(grid, s, dist, d):
    q = collections.deque([s])
    while q:
        a, b = q.popleft()
        for i in range(4):
            x = a + d[i]
            y = b + d[i+1]

            if grid[x][y] != "X":
                dist[x][y] = dist[a][b] + 1

                if dist[x][y] >= 60:
                    return "#notworth"
                if grid[x][y] == "W":
                    return dist[x][y]
                q.append((x, y))
                grid[x][y] = "X"
    return "#notworth"

def main():
    input = sys.stdin.readline
    d = [1, 0, -1, 0, 1]
    hBorder = ['X']*(52)

    for _ in range(int(input().strip())):
        c, r = map(int, input().strip().split())
        dist = [[0]*(c+2) for _ in range(r+2)]

        grid = [hBorder]
        for i in range(r):
            line = input().strip() 
            grid.append([*("X" + line + "X")])
            if "C" in line:
                s = (i+1, line.find("C")+1)
            if "W" in line:
                e = (i+1, line.find("W")+1)

        if abs(e[1] - s[1]) + abs(e[0] - s[0]) >= 60:
            print("#notworth")
        else:
            grid.append(hBorder)
            print(bfs(grid, s, dist, d))
main()