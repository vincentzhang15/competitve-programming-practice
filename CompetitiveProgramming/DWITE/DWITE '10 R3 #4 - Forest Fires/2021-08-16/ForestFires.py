"""
..........
..........
..........
..........
..TTTTT...
..F...F...
..........
..........
..........
..........
----------
..........
..........
..........
...TT.TT..
...F......
..........
..........
..........
..........
..........
----------

3
-1

10 × 10 map
    . - blank space
    T - a tree
    F - a tree on fire
"""

import sys, collections

def main():
    input = sys.stdin.readline
    border = ['.']*12
    d = [1, 0, -1, 0, 1]

    for _ in range(5):
        grid = [border]
        q = collections.deque()
        trees = 0

        for i in range(10):
            line = input().strip()
            trees += line.count('T')
            grid.append(['.'] + [*line] + ['.'])
            if 'F' in line:
                for j, v in enumerate(line):
                    if v == 'F':
                        q.append((i+1, j+1, 0))
                        grid[i+1][j+1] = '.'
        grid.append(border)

        # BFS
        maxx = set()
        while q:
            x, y, dist = q.popleft()
            maxx.add(dist)
            for i in range(4):
                r, c = x+d[i], y+d[i+1]
                if grid[r][c] != '.':
                    grid[r][c] = '.'
                    q.append((r, c, dist+1))
                    trees -= 1

        print(-1 if trees > 0 else max(maxx))
        input()
main()