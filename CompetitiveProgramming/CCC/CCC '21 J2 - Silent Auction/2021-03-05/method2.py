nameList = []
bidList = []

n = int(input())
for i in range(n):
    nameList.append(input())
    bidList.append(int(input()))

maxIndex = 0;
if n > 1:
    for l in range(n-1):
        if bidList[l+1]>bidList[maxIndex]:
            maxIndex = l+1

print(nameList[maxIndex])
