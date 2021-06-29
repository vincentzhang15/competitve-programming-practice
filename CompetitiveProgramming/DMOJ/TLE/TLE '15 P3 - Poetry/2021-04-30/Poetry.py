import sys

n = int(input())
limits = []

for i in range(n):
	limits.append(int(input()))

line = input() + " "
first = 0
last = 0

for i in range(sys.maxsize):
	if first >= len(line):
		break
		
	limit = limits[i%n]
	last = first + limit
	last = line.rfind(' ', 0, last+1)

	if last < first:
		print(line[first:first+limit])
		first += limit
	else:
		print(line[first:last])
		first = last + 1
