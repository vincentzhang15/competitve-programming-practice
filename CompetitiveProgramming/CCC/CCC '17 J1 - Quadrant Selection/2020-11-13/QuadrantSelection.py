import sys
data = sys.stdin.read().split('\n')

x = int(data[0])
y = int(data[1])

if y > 0:
	if x > 0:
		print(1)
	else:
		print(2)
else:
	if x > 0:
		print(4)
	else:
		print(3)