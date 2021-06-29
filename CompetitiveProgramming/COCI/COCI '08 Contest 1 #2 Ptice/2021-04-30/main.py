n = int(input())
s = input()

A = ['A','B','C']
B = ['B','A','B','C']
G = ['C','C','A','A','B','B']

ca = 0
cb = 0
cg = 0

for i in range(len(s)):
    a = A[i%len(A)]
    b = B[i%len(B)]
    g = G[i%len(G)]
    
    c = s[i]
    
    if a == c:
        ca += 1
    if b == c:
        cb += 1
    if g == c:
        cg += 1
    
maxx = max(ca, max(cb, cg))
print(maxx)
result = []

if ca == maxx:
    result.append("Adrian")
if cb == maxx:
    result.append("Bruno")
if cg == maxx:
    result.append("Goran")
    
result.sort()
for i in result:
    print(i)