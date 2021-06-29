import sys
data = sys.stdin.read().split('\n')

pos = 1
for i in range (len(data)):
	if int(data[i]) == 0:
		print("You Quit!")
		break
		
	if pos + int(data[i]) <= 100:
		pos += int(data[i])
	
	# snakes
	pos = 19 if pos == 54 else pos
	pos = 48 if pos == 90 else pos
	pos = 77 if pos == 99 else pos
	
	# ladders
	pos = 34 if pos == 9 else pos
	pos = 64 if pos == 40 else pos
	pos = 86 if pos == 67 else pos
		
	# output
	print("You are now on square", pos)
	
	# exit
	if pos == 100:
		print("You Win!")
		break
