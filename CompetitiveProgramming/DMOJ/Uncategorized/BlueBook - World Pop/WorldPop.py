"""
------------------------------------------------------------------------------
---------------------------- BlueBook - World Pop ----------------------------
World population increases p% every year. Population was n in year y.
Estimate popluation in final year.

Sample Input
1.6
1987
5000000000
2087

Sample Input Explanation
Line 1: r, growth rate.
Line 2: y, start years.
Line 3: n, population at start year.
Line 4: e, end year.

Sample Output
24453487116

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find n * (r/100+1)^(e-y) rounded to nearest integer.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to estimate population.
@author Vincent Zhang
@since 04 August 2021
@context Self-Learning Python 3
"""

r = float(input())
s = int(input())
p = int(input())
e = int(input())

print(round( p * (r/100+1) ** (e-s) ))