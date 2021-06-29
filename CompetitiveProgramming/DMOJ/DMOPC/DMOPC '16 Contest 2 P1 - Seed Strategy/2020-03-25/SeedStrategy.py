n = int(input())
k = int(input())

count = 0
for i in range(k):
	m = int(input())
	if m == 1:
		count += 0.5
	elif m == 2:
		count += 1
	elif m == 3:
		count += 5

if count <= n:
	print ("Continue")
else:
	print ("Return")