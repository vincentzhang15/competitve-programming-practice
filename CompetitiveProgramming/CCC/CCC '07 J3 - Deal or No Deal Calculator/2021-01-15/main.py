b = [100, 500, 1000, 5000, 10000, 25000, 50000, 100000, 500000, 1000000]

summ = 0
for i in (b):
    summ += i
    
n = int(input())
remain = 10
for i in range (n):
    a = int(input())
    summ -= b[a-1]
    remain -= 1

bank = int(input())
our = summ / remain

if bank > our:
    print("deal")
else:
    print("no deal")