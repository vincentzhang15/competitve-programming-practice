"""
-------------------------------------------------------------------------
---------------------------- BlueBook - Cost ----------------------------
Determine the cost to mail a letter based on weight.

"
 0 ≤ N ≤ 30 costs 38 cents
30 < N ≤ 50 costs 55 cents
50 < N ≤ 100 costs 73 cents
if N > 100 then the base cost is 73 cents, plus 24 cents for every additional 50 grams or part thereof.
"

Sample Input
2
5
101

Sample Input Explanation
Line 1: number of tasks.
Line 2 to n+1: tasks.

Sample Output
38
97

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process each condition.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find mailling cost.
@author Vincent Zhang
@since 02 August 2021
@context Self-Learning Python 3
"""

import math

data = [int(input()) for _ in range(int(input()))]
for d in data:
    if d <= 30: print(38)
    elif d <= 50: print(55)
    elif d <= 100: print(73)
    else: print(73 + 24*math.ceil( (d - 100) / 50.0) )