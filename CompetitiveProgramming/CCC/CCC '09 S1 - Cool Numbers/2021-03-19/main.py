import math as m

a = int(input())
b = int(input())

data = []
count = 0
for i in range(1, int(round(pow(10e8, 1/6)))):
    if pow(i, 6) >= a and pow(i, 6) <= b:
        count += 1
print(count)