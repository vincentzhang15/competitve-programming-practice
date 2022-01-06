"""
http://www.usaco.org/index.php?page=viewproblem2&cpid=759

SAMPLE INPUT:

1 2 3 5
6 0 10 4
2 1 8 3

SAMPLE OUTPUT:

17

"""

import sys

class Rect:
    def __init__(self):
        self.x1, self.y1, self.x2, self.y2 = map(int, input().split())
    
    def area(self):
        return (self.x2-self.x1) * (self.y2-self.y1)


def inter(a, b):
    dx = max(0, min(a.x2, b.x2) - max(a.x1, b.x1))
    dy = max(0, min(a.y2, b.y2) - max(a.y1, b.y1))
    return dx * dy

sys.stdin = open('billboard.in', 'r')
sys.stdout = open('billboard.out', 'w')

a = Rect()
b = Rect()
c = Rect()

total = a.area() + b.area()
total -= inter(a, b)
total -= inter(a, c)
total -= inter(b, c)

print(total)