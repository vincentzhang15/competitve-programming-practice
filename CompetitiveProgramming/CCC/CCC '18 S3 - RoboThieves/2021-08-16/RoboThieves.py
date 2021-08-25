"""
4 5
WWWWW
W.W.W
WWS.W
WWWWW

5 7
WWWWWWW
WD.L.RW
W.WCU.W
WWW.S.W
WWWWWWW
"""

import sys, collections

def camRow(dist, i, a, b):
    dist[i][a:b] = [-1]*(b-a)

def camColOld(grid, dist, col, a, b, c=1):
    for i in range(a, b, c):
        if grid[i][col] == 'W':
            break
        dist[i][col] = -1
def camCol(dist, col, a, b):
    for i in range(a, b):
        dist[i][col] = -1

def rIndex(c, a, b, d):
    d.reverse()
    ln = len(d)
    a = ln - a
    b = ln - b
    idx = ln - 1 - d.index(c, b, a)
    return idx

def main():
    input = sys.stdin.readline

    r, c = map(int, input().split())

    dist = [[100000]*c for _ in range(r)]
    dir = [1, 0, -1, 0, 1]

    grid = []
    cams = []
    for i in range(r):
        line = input().strip()
        grid.append([*line])
        if 'S' in line:
            s = (i, line.find('S'))
            grid[i][s[1]] = '.'
        if 'C' in line:
            for j, v in enumerate(line):
                if v=='C':
                    cams.append((i, j))
                    camRow(dist, i, line.rfind('W', 0, j)+1, j+1) # Left.
                    camRow(dist, i, j, line.find('W', j+1, c)) # Right.
    for cam in cams:
        camColOld(grid, dist, cam[1], cam[0], -1, -1) # Up.
        camColOld(grid, dist, cam[1], cam[0], r) # Down.
        """
        col = [row[cam[1]] for row in grid]
        camCol(dist, cam[1], cam[0]+1, col.index('W', cam[0]+1, r)) # Down.
        # camCol(dist, cam[1], rIndex('W', 0, cam[0], col)+1, cam[0]+1) # Up.
        camColOld(grid, dist, cam[1], cam[0], -1, -1) # Up.
        """

    # BFS
    q = collections.deque()
    if dist[s[0]][s[1]] != -1:
        dist[s[0]][s[1]] = 0
        q.append(s)
    while q:
        x, y = q.popleft()
        for i in range(4):
            a, b = x+dir[i], y+dir[i+1]
            if grid[a][b] != 'W':
                while grid[a][b] != '.' and dist[a][b] != -2:
                    dist[a][b] = -2
                    # Walk to end of conveyor, update a,b.
                    if grid[a][b] == 'U': a -= 1
                    elif grid[a][b] == 'D': a += 1
                    elif grid[a][b] == 'L': b -= 1
                    elif grid[a][b] == 'R': b += 1
                if grid[a][b] != '.':
                    continue
                if dist[a][b] > dist[x][y] + 1:
                    dist[a][b] = dist[x][y] + 1
                    q.append((a, b))

    grid[s[0]][s[1]] = 'S'
    for i in range(r):
        for j in range(c):
            if grid[i][j] == '.':
                print(dist[i][j] if dist[i][j] != 100000 else -1)
main()