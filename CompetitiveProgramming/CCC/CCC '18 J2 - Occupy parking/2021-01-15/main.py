n = int(input())
d1 = input()
d2 = input()

summ = 0
for i in range (0, n):
    if d1[i] == 'C' and d2[i] == 'C':
        summ += 1
print(summ)