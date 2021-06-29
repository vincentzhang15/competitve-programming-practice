import sys
data = sys.stdin.read().split('\n')

weight = float(data[0])
height = float(data[1])
BMI = weight/height/height

if(BMI > 25):
	print("Overweight")
elif(BMI < 18.5):
	print("Underweight")
else:
	print("Normal weight")