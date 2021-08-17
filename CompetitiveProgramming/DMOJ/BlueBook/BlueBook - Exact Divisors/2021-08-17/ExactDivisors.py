"""
-----------------------------------------------------------------------------------
---------------------------- BlueBook - Exact Divisors ----------------------------
Print all exact divisors of a number in any order. Includes 1 and N.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check every number from 1 to N. O(N) with loop.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find all exact divisors of a number.
@author Vincent Zhang
@since 17 August 2021
"""

n = int(input())
for i in range(1, n+1):
    if n%i == 0:
        print(i)