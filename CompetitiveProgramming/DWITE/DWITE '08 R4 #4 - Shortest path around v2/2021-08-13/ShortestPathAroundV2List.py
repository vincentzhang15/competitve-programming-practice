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

def bfs(grid, s, e):
    d = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
    
    dist = [[999999999 for _ in range(8)] for _ in range(8)]
    q = collections.deque([s])
    dist[s[0]][s[1]] = 0

    while q:
        left = q.popleft()
        x1 = left[0]
        y1 = left[1]
        for dd in d:
            x2 = x1 + dd[0]
            y2 = y1 + dd[1]
            if x2 >= 0 and y2 >= 0 and x2 < 8 and y2 < 8 and grid[x2][y2] != '#' and dist[x2][y2] > dist[x1][y1] + 1:
                dist[x2][y2] = dist[x1][y1] + 1

                if e == (x2, y2):
                    return dist[x2][y2]

                q.append((x2, y2))
    return -1



def main():
    input = sys.stdin.readline

    for _ in range(5):
        grid = []
        s = 0
        e = 0
        for i in range(8):
            line = input()
            grid.append(list(line.strip()))
            for j in range(8):
                if line[j] == 'A':
                    s = (i, j)
                if line[j] == 'B':
                    e = (i, j)
        print(bfs(grid, s, e))
main()

