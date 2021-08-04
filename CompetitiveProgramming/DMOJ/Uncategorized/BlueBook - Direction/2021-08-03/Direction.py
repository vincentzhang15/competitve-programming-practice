"""
------------------------------------------------------------------------------
---------------------------- BlueBook - Direction ----------------------------
Given a direction in integer degrees N. 0 ≤ N < 360.
Print the closest cardinal direction.
Ties are broken by smaller directions.
Direction in increasing size are N, E, S, W.
I.e., choose N over E when deg <= 45
             N over W when deg >= 315

Sample Input
2
45
180

Sample Input Explanation
Line 1: T, number of tasks.
Line 2 to T+1: degrees.

Sample Output
N
S

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process conditions.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to print the closest cardinal direction.
@author Vincent Zhang
@since 03 August 2021
@context Self-Learning Python 3
"""

for _ in range(int(input())):
    d = int(input())
    if d <= 45 or d >= 315:
        print("N")
    elif d <= 135:
        print("E")
    elif d <= 225:
        print("S")
    else:
        print("W")