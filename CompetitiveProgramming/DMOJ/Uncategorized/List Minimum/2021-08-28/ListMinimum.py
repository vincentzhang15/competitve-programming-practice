"""
----------------------------------------------------------------------
---------------------------- List Minimum ----------------------------
Given a list of numbers, remove the minimum from the list until the list is empty.

Sample Input
3
5
8
2

Sample Output
2
5
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Problem description is the definition of selection sort in ascending order.
Therefore, it sufices to sort with built-in function if avaiable.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Outputs a list of numbers in ascending order.
@author Vincent Zhang
@since 28 August 2021
"""

for v in sorted([int(input()) for _ in range(int(input()))]): print(v)