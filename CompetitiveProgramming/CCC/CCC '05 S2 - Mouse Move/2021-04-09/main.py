c, r = map(int, input().split())
x = 0
y = 0
while 1:
    dx, dy = map(int, input().split())
    if dx == 0 and dy == 0:
        break
    x += dx
    y += dy
    
    if(x < 0):
        x = 0
    elif(x > c):
        x = c
    
    if y < 0:
        y = 0
    elif y > r:
        y = r
    
    print(x, y)