class Rect:
    def __init__(self):
        self.x1, self.y1, self.x2, self.y2 = map(int, input().split())
    def area(self):
        return (self.x2-self.x1) * (self.y2-self.y1)

def intersection(a, b):
    dx = max(0, min(b.x2, a.x2) - max(b.x1, a.x1))
    dy = max(0, min(b.y2, a.y2) - max(b.y1, a.y1))
    return dx * dy

def intersection_3(a, b, c):
    dx = max(0, min(c.x2, b.x2, a.x2) - max(c.x1, b.x1, a.x1))
    dy = max(0, min(c.y2, b.y2, a.y2) - max(c.y1, b.y1, a.y1))
    return dx * dy

a, b, c = Rect(), Rect(), Rect()
t = a.area() - intersection(a, b) - intersection(a, c) + intersection_3(a, b, c)

if t > 0:
    print("YES")
else:
    print("NO")
