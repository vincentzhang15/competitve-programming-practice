n, m = map(int, input().split())

items = list()
for i in range(n):
    items.append(input())
    
count = 0
for i in range(m):
    t = int(input())
    exit = False
    for j in range(t):
        item = input()
        if item not in items:
            exit = True
    if not exit:
        count += 1

print(count)