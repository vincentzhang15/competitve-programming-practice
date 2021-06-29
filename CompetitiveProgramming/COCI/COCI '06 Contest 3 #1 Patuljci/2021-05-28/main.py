import sys
data = []
total = 0
for i in range(9):
    data.append(int(input()))
    total += data[i]

total -= 100

for i in range(9):
    for j in range(i+1, 9):
        if data[i] + data[j] == total:
            for k in range(9):
                if data[k] != data[i] and data[k] != data[j]:
                    print(data[k])
            sys.exit();