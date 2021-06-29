from decimal import *
import math

getcontext().prec = 30

n = int(input())
c = Decimal(input())

for i in range(n):
	c -= Decimal(input())

if c < 0:
	print("Fardin's broke")
else:
	print("{:.2f}".format(c))