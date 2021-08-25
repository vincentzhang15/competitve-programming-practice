"""
--------------------------------------------------------------------------------
---------------------------- BlueBook - Max is Last ----------------------------
Given a list of numbers, print the max value last.

Sample Input
4
3
2.7
5.12
-0.63

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: list of numbers.

Sample Output
3.00
2.70
-0.63
5.12

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max, print the rest without max, print max.
E.g., by creating new list without max, iterating through list and not printing max.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Prints a list with the maxiumum value last.
@author Vincent Zhang
@since 25 August 2021
"""

data = [float(input()) for _ in range(int(input()))]
maxx = max(data)
data.remove(maxx)
for d in data:
    print("%.2f" % d)
print("%.2f" % maxx)