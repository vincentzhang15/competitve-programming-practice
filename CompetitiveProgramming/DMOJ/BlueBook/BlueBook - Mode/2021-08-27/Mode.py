"""
-------------------------------------------------------------------------
---------------------------- BlueBook - Mode ----------------------------
Find mode of a set of positive non-zero integers <= 100.

Sample Input
2
3
4
4
-1

Sample Output
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max frequency, then sort all modes with the frequency.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the mode of a dataset.
@author Vincent Zhang
@since 27 August 2021
"""

import sys, collections

"""
Solves the problem.
@return void
"""
def main():
    input = sys.stdin.readline

    data = collections.defaultdict(int)
    while 1:
        x = int(input())
        if x == -1:
            break
        data[x] += 1
    
    maxx = max(data.values())
    final = [key for key in data.keys() if data[key] == maxx]
    for v in sorted(final):
        print(v)

main()