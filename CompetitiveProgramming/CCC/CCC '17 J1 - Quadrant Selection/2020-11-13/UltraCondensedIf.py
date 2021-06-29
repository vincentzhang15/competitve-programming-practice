import sys
data = sys.stdin.read().split('\n')

x = int(data[0])
y = int(data[1])

print((1 if x > 0 else 2) if y > 0 else (4 if x > 0 else 3))