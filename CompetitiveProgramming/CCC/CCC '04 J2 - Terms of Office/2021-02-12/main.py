a = int(input())
b = int(input())

for i in range(a, b+1):
    if (i-a) % 60 == 0:
        print("All positions change in year", i)
