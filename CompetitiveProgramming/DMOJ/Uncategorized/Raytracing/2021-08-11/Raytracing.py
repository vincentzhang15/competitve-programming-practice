"""
10
3 3 9 4 7 6 6 6 0 3
10
1 2 4 4 5
1 4 8 2 3
2 5 3
1 4 7 0 6
1 1 4 1 2
1 0 2 0 2
1 0 9 0 4
2 5 6
1 0 7 0 1
2 3 3


######## TLE
"""

import sys

def main():
    input = sys.stdin.readline

    n = int(input())
    h = list(map(int, input().split()))
    q = int(input())

    for qq in range(q):
        s = list(map(int, input().split()))
        if s[0] == 2:
            h[s[1]] = s[2]
        else:
            c = 0
            for i in range(s[1], s[2]+1):
                if h[i] >= s[3] and h[i] <= s[4]:
                    c += 1
            print(c)
main()