p = int(input())

total = 0 # max value
maxName = ""

for i in range(p):# 0 1 2 
  name = input()
  bid = int(input())

  if bid > total:
    total = bid
    maxName = name

print(maxName)
