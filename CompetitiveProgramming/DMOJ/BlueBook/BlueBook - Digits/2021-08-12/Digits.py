"""
---------------------------------------------------------------------------
---------------------------- BlueBook - Digits ----------------------------
Find number of digits of each number. Negative sign is not a digit.

Sample Input
4
123
1
-12
0

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: numbers.

Sample Output
3
1
2
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find absolute value of every number then its string length.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the number of digits in a list of numbers.
@author Vincent Zhang
@since 12 August 2021
"""

for _ in range(int(input())): print(len(str(abs(int(input())))))