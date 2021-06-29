dir = ""
while 1:
	s = input()
	if s == "99999":
		break
	
	sum = ord(s[0])-48 + ord(s[1])-48
	if sum ==0:
		print(dir, end = " ")
	elif sum %2 == 0:
		dir = "right"
		print(dir, end = " ")
	else:
		dir = "left"
		print(dir, end = " ")
	print(s[2:])