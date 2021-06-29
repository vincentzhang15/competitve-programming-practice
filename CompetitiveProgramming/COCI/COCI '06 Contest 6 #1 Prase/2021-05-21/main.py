n = int(input())

data = {}
total = 0

for i in range(n):
    s = input()
    if s in data:
        data[s] += 1
    else:
        data[s] = 1
        
    current = data[s]
    other = 0
    for key in data:
        if key != s:
            other += data[key]
    if current - other >= 2:
        total += 1
print(total)