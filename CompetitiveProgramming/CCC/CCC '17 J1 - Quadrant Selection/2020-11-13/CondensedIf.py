import sys
data = sys.stdin.read().split('\n')

x = int(data[0])
y = int(data[1])

if y > 0:
	print(1 if x > 0 else 2)
else:
	print(4 if x > 0 else 3)
