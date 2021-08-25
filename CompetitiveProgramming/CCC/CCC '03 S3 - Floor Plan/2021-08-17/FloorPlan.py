"""
105
14
16
IIIIIIIIIIIIIIII
I......I.......I
I......III.....I
I........I.....I
I........IIIIIII
IIIIIIIIII.....I
I.I......I.....I
III..III.I.....I
I....I.IIIII...I
I....I.....III.I
I....I.......I.I
I....I.....III.I
I....I.....I...I
IIIIIIIIIIIIIIII

4 rooms, 1 square metre(s) left over

"""

import sys

def main():
    input = sys.stdin.readline
    a, r, c = int(input()), int(input()), int(input())

    vis = [[0]*c for _ in range(r)]
    map = [input().strip() for _ in range(r)]
    d = [1, 0, -1, 0, 1]

    rooms = []
    count = 0
    first = True
    for i in range(0, r):
        for j in range(0, c):
            if not vis[i][j]:
                # DFS
                stack = [(i, j)]
                vis[i][j] = 1
                while stack:
                    x, y = stack.pop()
                    for k in range(4):
                        x2, y2 = x+d[k], y+d[k+1]
                        if x2 in range(r) and y2 in range(c) and map[x2][y2] != 'I' and not vis[x2][y2]:
                            vis[x2][y2] = 1
                            count += 1
                            stack.append((x2, y2))
                if count != 0:
                    if i == 0 and j == 0 and first:
                        count += 1
                        first = False
                    rooms.append(count)
                    count = 0

    count = 0
    for room in reversed(sorted(rooms)):
        if a - room >= 0:
            count += 1
            a -= room
        else:
            break

    print(count, "room," if count == 1 else "rooms,",  a, "square metre(s) left over")

main()