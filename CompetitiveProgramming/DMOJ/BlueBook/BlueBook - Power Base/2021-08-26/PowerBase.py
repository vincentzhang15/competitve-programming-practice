"""
-------------------------------------------------------------------------------
---------------------------- BlueBook - Power Base ----------------------------
Given x, p, find "x" raised to the power "p" rounded to 2 decimal places.

Sample Input
3
2.0 4
4.0 2
3.0 3

Sample Output
16.00
16.00
27.00

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop and find power.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Evaluates an exponentiation.
@author Vincent Zhang
@since 26 August 2021
"""

for i in range(int(input())):
    x, y = map(float, input().split())
    print("%.2f" % (x ** y))