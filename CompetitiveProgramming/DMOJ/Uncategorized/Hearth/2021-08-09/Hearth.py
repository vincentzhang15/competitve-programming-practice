"""
5 5
KNIFEJUGGLER 2
HAUNTEDCREEPER 2
STONETUSKBOAR 1
LORDJARAXXUS 9
ANNOYOTRON 2
"""

n, t = map(int, input().split())
s = []
c = []
for _ in range(n):
    a, b = input().split()
    s.append(a)
    c.append(int(b))

combos = []
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            if c[i] + c[j] + c[k] <= t:
                combo = [s[i], s[j], s[k]]
                combo.sort()
                combos.append(combo)

for combo in sorted(combos):
    for c in combo:
        print(c, end=' ')
    print()