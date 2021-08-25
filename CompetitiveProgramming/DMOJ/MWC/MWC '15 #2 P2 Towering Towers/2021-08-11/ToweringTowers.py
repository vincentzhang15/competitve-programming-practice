"""
Notes

Loop through list of heights and check adjacent.
If height[cur] < height[prev]:
    print(1) can see only 1
    localmax[prev] = true
    last_max_idx = prev
else: current is taller
    for int i=lastmaxidx; i>=0; i--: # note add additional maxx to begin of list, to ensure find
        if local max and height[cur] < i:
            print(cur - i )
            lastmaxidx = i
            break


########
list height[] = stores heights values, reference list
set locMax = stores indices of local maxes, reverse looping
########

int lastIdx = stores index of last value. (NOT NEEDED, JUST REVERSE ITERATE SET)

dont use set, use stack, push pop index of local max

e.g.,
=
=
=      |
=    | | |   | |
=  | | | | | | |
0  1 2 3 4 5 6 7 (idx)
X      X -   
         -       (popped)

=: insert max height first, add to set

pop only if not taller, always top() first

height at most 1e6

Python 3 VERDICT: only AC Python 3 submission. Last checked: 11 August 2021
55 Other TLE submissions including 
    2 ppl: 3k+ rating
    6+2 ppl: 1.8k+ rating
    7+6+2 ppl: 1.5k+ rating

Fastest PyPy3 submission
"""

import sys

#import timeit
#start = timeit.default_timer()

def main():
    input = sys.stdin.readline
    print = sys.stdout.write

    n = int(input())
    heights = [int(1e6+1)] + list(map(int, input().split()))
    
    stack = [0]
    print("0 ")

    for i in range(2, n+1):
        if heights[i] < heights[i-1]:
            stack.append(i-1)
            print("1 ")
        else:
            while stack:
                top = stack[-1]
                if heights[i] < heights[top]:
                    print(str(i-top if len(stack) > 1 else i-top-1) + " ")
                    break
                stack.pop()
main()

# stop = timeit.default_timer()
# print()
# print("%f" % (stop-start))