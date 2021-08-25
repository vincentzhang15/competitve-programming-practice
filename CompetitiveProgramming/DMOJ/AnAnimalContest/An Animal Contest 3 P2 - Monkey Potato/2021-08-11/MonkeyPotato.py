"""
5 6
3 1 2 5 4 9


k = 1
    s = 1
        0: -1
        n: n
    s > 1
        min 0: next min
        else: n
k = 2
    s = 1
        0: -1
        n: nn
    s > 1
        min 0: next min * 2
        else: nn

k = 3
    s = 1
        0: -1
        n: nnn
    s > 1
        min 0: n0n
        else: nnn

k = 4
    s = 1
        0: -1
        n: nnnn
    s > 1
        min 0: n00n
        else: nnnn

"""

import sys

def main():
    input = sys.stdin.readline

    k, d = map(int, input().split())
    v = set(map(int, input().split()))

    m = min(v)
    if k <= 2:
        if len(v) == 1:
            if m == 0:
                print(-1)
            else:
                print(str(m)*k)
        else:
            if m == 0:
                v.remove(m)
                m = str(min(v))
            print(m*k)

    else:
        if m != 0:
            print(str(m)*k)
        else:
            if len(v) == 1:
                print(-1)
            else:
                v.remove(m)
                m = str(min(v))
                print(m + "0"*(k-2) + m)

main()