n, m, k = map(int, input().split())

bestRat = [-1]*n
bestProf = [-1]*n

for i in range(k):
    p, q, r = map(int, input().split())
    if r > bestRat[q-1]:
        bestRat[q-1] = r
        bestProf[q-1] = p
for i in range(n):
    print(bestProf[i], end=" ")