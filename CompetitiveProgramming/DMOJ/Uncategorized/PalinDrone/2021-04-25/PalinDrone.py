def calc():
	s = input()
	if len(s) > 2:
		print(999999998)
		return
		
	i = int(s)
	if i >= 18:
		print(999999998)
		return
	
	if i >= 17:
		print(99999998)
		return
	
	if i == 1:
		print(9)
		return
		
	print(1, end="")
	if i % 2 != 0:
		print(0, end="")
	for i in range(i // 2 - 1):
		print(9, end="")
	print(8, end="")

calc()