import sys
n = int(input())

minx = 100000
miny = 100000
maxx = -1
maxy = -1

for i in range(n):
	x, y = map(int, input().split())
	x += 1000
	y += 1000
	minx = min(minx, x)
	miny = min(miny, y)
	maxx = max(maxx, x)
	maxy = max(maxy, y)

area = (maxx-minx)*(maxy-miny)
print(area)