data = []

for i in range(4):
    a = list(map(int, input().split(" ")))
    data.append(a)

summ = data[0][0] + data[0][1] + data[0][2] + data[0][3]

exit = False
for i in range(4):
    nSum = 0
    for j in range(4):
        nSum += data[i][j]
    if nSum != summ:
        print("not magic")
        exit = True
        break

if not exit:
    for i in range(4):
        nSum = 0
        for j in range(4):
            nSum += data[j][i]
        if nSum != summ:
            print("not magic")
            exit = True
            break
if not exit:
    print("magic")