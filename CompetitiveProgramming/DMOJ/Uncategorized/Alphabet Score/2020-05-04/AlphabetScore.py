word = input()
sum = 0
for i in range(26):
	sum += word.count(chr((i+ord('a')))) * (i+1)
print(sum)