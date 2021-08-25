"""
PyPy 3 Submission
Python 3 TLE


7 10
##########
#*#****P*#
#***#****#
###*####*#
#***##***#
#O**#***X#
##########

15

OPX
"""

import sys, collections

def bfs(grid, s, e, dist, d):
    q = collections.deque([s])
    while q:
        a, b = q.popleft()
        for i in range(4):
            x = a + d[i]
            y = b + d[i+1]
            if grid[x][y] != '#':
                dist[x][y] = dist[a][b] + 1
                if grid[x][y] == e:
                    return dist[x][y]
                q.append((x, y))

                grid[x][y] = '#'

    return -1

def main():
    input = sys.stdin.readline

    r, c = map(int, input().split())
    d = [1, 0, -1, 0, 1]

    grid = []
    for i in range(r):
        line = input().strip()
        grid.append([*line])
        if 'O' in line:
            o = (i, line.find('O'))
        if 'P' in line:
            p = (i, line.find('P'))

    gridCopy = [_[:] for _ in grid]
    dist = [[0]*c for _ in range(r)]
    d1 = bfs(gridCopy, o, 'P', dist, d)
    if d1 == -1:
        print(-1)
        return

    dist = [[0]*c for _ in range(r)]
    d2 = bfs(grid, p, 'X', dist, d)
    if d2 == -1:
        print(-1)
        return

    print(d1+ d2)
main()