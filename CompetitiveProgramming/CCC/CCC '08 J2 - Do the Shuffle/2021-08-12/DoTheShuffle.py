"""
2
1
3
1
2
3
4
1

"""

import sys

def main():
    input = sys.stdin.readline

    d = {
        1:"A",
        2:"B",
        3:"C",
        4:"D",
        5:"E"
    }
    mi = 1
    ma = 5

    while 1:
        a, b = int(input()), int(input())
        if a == 4:
            break

        for _ in range(b):
            if a == 1:
                d[ma+1] = d[mi]
                del d[mi]
                ma += 1
                mi += 1
            elif a == 2:
                d[mi-1] = d[ma]
                del d[ma]
                mi -= 1
                ma -= 1
            else:
                d[mi], d[mi+1] = d[mi+1], d[mi]

    for dd in sorted(d):
        print(d[dd], end=" ")
main()