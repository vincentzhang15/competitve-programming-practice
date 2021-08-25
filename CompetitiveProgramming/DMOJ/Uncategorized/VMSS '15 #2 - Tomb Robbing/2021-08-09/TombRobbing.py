"""
6 10
XXXXXXXXXX
X...X..X.X
XX.XX..XXX
XXXX..XXXX
X.......XX
XXXXXXXXXX
"""

def main():
    r, c = map(int, input().split())
    grid = [list(input()) for _ in range(r)]
    vis = [[0 for j in range(c)] for i in range(r)]

    rooms = 0
    for i in range(r):
        for j in range(c):
            if grid[i][j] == '.' and not vis[i][j]:
                rooms += 1
                vis[i][j] = 1
                stack = [[i, j]]

                d = [1, 0, -1, 0, 1]
                while stack:
                    coord = stack.pop()
                    for k in range(4):
                        x = coord[0] + d[k]
                        y = coord[1] + d[k+1]
                        if x >= 0 and y >= 0 and x < r and y < c and grid[x][y] == '.' and not vis[x][y]:
                            vis[x][y] = 1
                            stack.append([x, y])
    print(rooms)
main()