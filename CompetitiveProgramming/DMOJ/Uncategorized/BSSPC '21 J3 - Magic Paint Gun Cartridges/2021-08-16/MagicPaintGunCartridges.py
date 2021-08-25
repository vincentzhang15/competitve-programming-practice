"""
6 4
..RR.P
..OORO
BBB.UU
ROBB..

5 4 4


VERDICT: Fastest Python 3 Submission
2.07s

Next 5 Places
3.81s
4.49s
4.85s
5.32s
6.31s

"""

import sys, re

def main():
    input = sys.stdin.readline

    paints = [0]*3 # R, Y, B
    for _ in range(int(input().split()[-1])):
        line = input()
        paints[0] += len(re.findall(r"[ROPB]+", line))
        paints[1] += len(re.findall(r"[YOGB]+", line))
        paints[2] += len(re.findall(r"[UGPB]+", line))
    print(f"{paints[0]} {paints[1]} {paints[2]}")
main()