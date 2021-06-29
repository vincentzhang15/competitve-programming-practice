n = int(input())

x = 0
y = 0
for i in range(n):
	a = input()
	b = int(input())
	if a == "North":
		y += b
	elif a == "South":
		y -= b
	elif a == "East":
		x += b
	elif a == "West":
		x -= b
		
print(str(x) + " " + str(y))