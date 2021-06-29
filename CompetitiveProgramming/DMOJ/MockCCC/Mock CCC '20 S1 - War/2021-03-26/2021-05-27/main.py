n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

i = 0

count = 0
isLast = False
while i < n:
    if a[i] == b[i] and not isLast:
        count += 1
        isLast = True
    elif a[i] != b[i]:
        isLast = False
    i += 1
print(count)