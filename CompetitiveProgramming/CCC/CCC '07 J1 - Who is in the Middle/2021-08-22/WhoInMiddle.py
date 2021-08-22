"""
--------------------------------------------------------------------------------------------
---------------------------- CCC '07 J1 - Who is in the Middle? ----------------------------
Find the middle number of three numbers.

Sample Input
10
5
8

Sample Output
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
One way is to sort the list and output list[1].
Another way is to subtract max and min from the trio sum.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the middle number in three numbers.
@author Vincent Zhang
@since 22 August 2021
"""

import sys

"""
Solves the problem.
@return void
"""
def main():
    input = sys.stdin.readline
    a, b, c = int(input()), int(input()), int(input())
    print(a+b+c - min(a, b, c) - max(a, b, c))
main()