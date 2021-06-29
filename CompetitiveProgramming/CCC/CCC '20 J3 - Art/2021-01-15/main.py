#5
#44,62
#34,69
#24,78
#42,44
#64,10

n = int(input())

minx = 101
maxx = -1
miny = 101
maxy = -1

for i in range (n):
    x, y = map(int, input().split(','))
    minx = min(minx, x)
    maxx = max(maxx, x)
    miny = min(miny, y)
    maxy = max(maxy, y)

print((minx-1), (miny-1), sep=",")
print((maxx+1), (maxy+1), sep=",")
