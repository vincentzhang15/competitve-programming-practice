"""
-----------------------------------------------------------------------------------------
---------------------------- CCC '17 J1 - Quadrant Selection ----------------------------
Determine the quadrant in which a pair of non-zero integral coordinates lie.

Sample Input 1
12
5

Sample Output 1
1

Sample Input 2
9
-13

Sample Output 2
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check half of coordinate plane, e.g., upper half, when y > 0: x > 0, x < 0.
Only 2 cases remain, both y < 0:
    Check x < 0
    Else

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to identify the quadrant of a pair of coordinates.
@author Vincent Zhang
@since 21 August 2021
"""

x, y = int(input()), int(input())
if y > 0:
    if x > 0:
        print(1)
    else:
        print(2)
else:
    if x < 0:
        print(3)
    else:
        print(4)