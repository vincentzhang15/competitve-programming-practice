"""
4
1
3
1 3 1
2 3 2
3 3 2
"""

import sys
input = sys.stdin.readline

s = int(input())
stations = [0] * (s+2)
n = int(input())

for _ in range(int(input())):
    a, b, k = map(int, input().split())
    stations[a] += k
    stations[b+1] -= k

#print(stations)
count = 0
for i in range(1, s+1):
    stations[i] += stations[i-1]
    if stations[i] < n:
        count += 1
#print(stations)
print(count)