n = int(input())
b = list(map(int, input().split()))
h = list(map(int, input().split()))

ans = 0
for i in range(len(h)):
    ans += (b[i] + b[i+1]) * h[i]
print(ans/2)