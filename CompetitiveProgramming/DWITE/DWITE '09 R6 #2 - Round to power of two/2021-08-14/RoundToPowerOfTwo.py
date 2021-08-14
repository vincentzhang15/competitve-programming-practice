"""
-------------------------------------------------------------------------------------------------
---------------------------- DWITE '09 R6 #2 - Round to power of two ----------------------------
Find the closest power of 2 for each of the 5 lines of input.
If a number is equally close to two powers of two, print the greater value.

Sample Input
0
1
2
3
5

Sample Output
1
1
2
4
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
2^x = y
x ln 2 = ln y
x = log_2(y)
lo = floor x
hi = lo + 1
Find closest.
Ensure to set log 0 to 0 as it is mathematically undefined.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the closest power of 2.
@author Vincent Zhang
@since 14 August 2021
"""

import sys, math

def main():
    input = sys.stdin.readline

    for _ in range(5):
        a = int(input())
        lo = int(math.log(a) // math.log(2)) if a != 0 else 0
        hi = lo + 1

        dLo = abs(2 ** lo - a)
        dHi = abs(2 ** hi - a)

        if dLo < dHi:
            print(2 ** lo)
        else:
            print(2 ** hi)
main()