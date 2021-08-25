"""
VERDICT: Fastest Python 3 Submission
1.46s

Next 5 Places
1.67s
1.68s
1.68s
1.80s
2.13s

"""

import sys, collections, bisect

def main():
    input = sys.stdin.readline

    data = collections.defaultdict(list)

    s = input().strip()
    for i, v in enumerate(s):
        data[v].append(i)
    
    for _ in range(int(input())):
        a, b, c = input().strip().split()
        lo = bisect.bisect_left(data[c], int(a)-1)
        hi = bisect.bisect_right(data[c], int(b)-1)
        print(hi-lo)
main()