"""
9
1 1
5 5
7 7
5 7
7 5
10 10
5 10
10 5
20 20
"""

n = int(input())
data = set()
a = []
b = []
for _ in range(n):
    x, y = map(int, input().split())
    data.add((x, y))
    a.append(x)
    b.append(y)

area = 0
for i in range(n):
    for j in range(i+1, n):
        p1 = (a[i], b[i])
        p2 = (a[j], b[j])
        if (p1[0], p2[1]) in data and (p2[0], p1[1]) in data:
            area = max(area, abs(p1[1] - p2[1]) * abs(p1[0] - p2[0]))
print(area)