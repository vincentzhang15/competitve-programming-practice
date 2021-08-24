"""
-----------------------------------------------------------------
---------------------------- Sorting ----------------------------
Sort a list <=100 of integers <= 32000 in ascending order.

Sample Input
4
4
3
2
1

Sample Output
1
2
3
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built in sorting method.
Or write own sorting method.
O(N^2) selection sort will work.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Sorts a list of integers.
@author Vincent Zhang
@since 24 August 2021
"""

for v in sorted([int(input()) for _ in range(int(input()))]): print(v)