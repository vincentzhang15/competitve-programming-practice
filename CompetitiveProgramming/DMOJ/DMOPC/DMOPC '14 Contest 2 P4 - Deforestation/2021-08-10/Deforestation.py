"""

5
1
2
3
4
5
3
0 4
1 3
2 2

"""

import sys

def main():
    input = sys.stdin.readline
    n = int(input())
    data = [0]
    for i in range(n):
        data.append(data[i] + int(input()))

    for i in range(int(input())):
        a, b = map(int, input().split())
        a += 1
        b += 1
        print(data[b] - data[a-1])
main()