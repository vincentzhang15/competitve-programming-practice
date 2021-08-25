"""
........
....#...
....#...
A...#..B
....#...
....#...
........
........
......#.
......#.
......#.
......#.
A..####B
..#.....
.##.....
.##.....

"""

import sys, collections

input = sys.stdin.readline
d = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]

def bfs(s):
    q = collections.deque([s])
    while q:
        a = q.popleft()
        for dd in d:
            b = tuple(map(sum, zip(a, dd)))
            if b not in dist and b[0] in range(8) and b[1] in range(8) and grid[b] != '#':
                dist[b] = dist[a] + 1
                q.append(b)
    return -1

for _ in range(5):
    grid = {}
    for i in range(8):
        line = input()
        for j in range(8):
            grid[(i, j)] = line[j]
            if line[j] == 'A': s = (i, j)
            if line[j] == 'B': e = (i, j)
    dist = {s:0}
    bfs(s)
    print(dist[e])