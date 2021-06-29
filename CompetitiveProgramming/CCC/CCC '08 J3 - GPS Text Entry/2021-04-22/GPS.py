data = [
	['A', 'B', 'C', 'D', 'E', 'F'],
	['G', 'H', 'I', 'J', 'K', 'L'],
	['M', 'N', 'O', 'P', 'Q', 'R'],
	['S', 'T', 'U', 'V', 'W', 'X'],
	['Y', 'Z', ' ', '-', '.', 'enter']
]

s, total, x, y = input(), 0, 0, 0
for i in s:
	for j in range(5):
		if i in data[j]:
			r, c = data[j].index(i), j
			total += abs(r-x) + abs(c-y)
			x, y = r, c
			
total += abs(x-4) + abs(y-5)
print(total)