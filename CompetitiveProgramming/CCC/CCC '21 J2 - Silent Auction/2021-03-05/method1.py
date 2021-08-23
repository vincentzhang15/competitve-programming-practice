n = int(input())
maxName = input()
maxPrice = int(input())

for i in range(n-1):
    curName = input()
    curPrice = int(input())
    
    if curPrice > maxPrice:
        maxPrice = curPrice
        maxName = curName

print(maxName)
