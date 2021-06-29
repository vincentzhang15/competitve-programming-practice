n = int(input())
teamA = list(map(int,input().split()))
teamB = list(map(int,input().split()))
sumA = sum(teamA)
sumB = sum(teamB)
if sumA == sumB:
    print(n)
else:
    for i in range(n-1,-1,-1):
        sumA-= teamA[i]
        sumB-= teamB[i]
        if sumA == sumB:
            print(i)
            break