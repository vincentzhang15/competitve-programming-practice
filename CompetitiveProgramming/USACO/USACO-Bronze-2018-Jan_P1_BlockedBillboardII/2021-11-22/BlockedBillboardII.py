"""
http://www.usaco.org/index.php?page=viewproblem2&cpid=783

SAMPLE INPUT:

2 1 7 4
5 -1 10 3

SAMPLE OUTPUT:

15

"""

import sys

class Rect:
    def __init__(self):
        self.x1, self.y1, self.x2, self.y2 = map(int, input().split())
    def area(self):
        return (self.x2-self.x1) * (self.y2-self.y1)

sys.stdin = open('billboard.in', 'r')
sys.stdout = open('billboard.out', 'w')

def intersect(a, b):
    dx = max(0, min(a.x2, b.x2) - max(a.x1, b.x1))
    dy = max(0, min(a.y2, b.y2) - max(a.y1, b.y1))
    return dx * dy if a.x2 >= b.x2 and a.x1 < b.x1 or b.y2 >= b.y2 and a.y1 < b.y1 else 0

lawn = Rect()
feed = Rect()

print(lawn.area() - intersect(lawn, feed))

