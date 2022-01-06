import sys

sys.stdin = open('square.in', 'r')
sys.stdout = open('square.out', 'w')

x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

dx = max(x2, x4) - min(x1, x3)
dy = max(y2, y4) - min(y1, y3)

s = max(dx, dy) # sidelength
print(s*s)