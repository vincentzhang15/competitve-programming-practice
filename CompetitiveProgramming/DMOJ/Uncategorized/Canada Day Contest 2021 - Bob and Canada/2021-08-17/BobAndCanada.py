"""

8
3
RWR
3
WWW
3
WRR
4
RWRW
6
WWWRRR
6
WWRRWW
10
RRRRWWRWRR
10
WWRRWWWWRW

0
2
2
1
1
3
1
3
"""

import sys

def main():
    input = sys.stdin.readline

    for _ in range(int(input())):
        n, s = int(input()), input().strip()
        r = [0] * n
        w = [0] * n

        for i, v in enumerate(s):
            if v == 'R':
                r[i] = 1
            else:
                w[i] = 1
        for i in range(1, n): r[i] += r[i-1]
        for i in range(1, n): w[i] += w[i-1]

        minn = 999
        ans = 9999999
        for b in range(1, n-1):
            a = b-1
            minn = min(minn, w[a]-r[a])
            ans = min(ans, w[n-1]-w[b] +r[b]+minn)

        print(ans)
    
main()