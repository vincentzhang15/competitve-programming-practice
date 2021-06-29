speedLimit = int(input())
speed = int(input())

difference = speed - speedLimit

if difference >= 1 and difference <= 20:
	print("You are speeding and your fine is $100.")
elif difference >= 21 and difference <= 30:
	print("You are speeding and your fine is $270.")
elif difference >= 31:
	print("You are speeding and your fine is $500.")
else:
	print("Congratulations, you are within the speed limit!")