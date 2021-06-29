s1 = list(input())
s2 = list(input())

count = 0
for i in range(len(s1)):
	if s1[i] != s2[i]:
		count += 1

if count == 1:
	print("LARRY IS SAVED!")
else:
	print("LARRY IS DEAD!")