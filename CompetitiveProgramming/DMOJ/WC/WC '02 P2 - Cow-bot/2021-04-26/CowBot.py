import math

n = int(input())

def isPrime(a):
	if a < 2:
		return False
	for i in range(2, int(a**0.5)+1):
		if a % i == 0:
			return False
	return True

for i in range(n):
	a, b = map(int, input().split())
	for j in range(b):
		s = str(a)
		if isPrime(a):
			a *= 11
		elif math.ceil(math.sqrt(a)) == math.sqrt(a):
			a += int(s[::-1])
		elif s == s[::-1]:
			a = int(s + "4")
		elif s[0] == '2':
			a = int("5" + s)
		elif "7" in s:
			temp = s[:len(s)-1]
			if len(temp) == 0:
				a = 0
			else:
				a = int(temp)
		elif a % 6 == 0:
			temp = s[1:]
			if len(temp) == 0:
				a = 0
			else:
				a = int(temp)
		elif len(s)%2 ==0:
			a = int(s[:len(s)//2] + "1" + s[len(s)//2:])
		else:
			a += 231
	print(a)