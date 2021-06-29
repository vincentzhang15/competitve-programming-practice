for i in range(5):
	day, month, year = map(int, input().split())
	if year < 1997:
		print("old enough")
	elif year > 1997:
		print("too young")
	else:
		if month > 10:
			print("too young")
		elif month < 10:
			print("old enough")
		else:
			if day > 27:
				print("too young")
			else:
				print("old enough")