"""
------------------------------------------------------------------------------------------
-------------------------------- BlueBook - Pop Explosion --------------------------------
Population increases rate "r" percent each year.
Population in starting year "s" is "A".
Find year "e" in which population reaches "e".

Sample Input
5.5 24000000 1980 100000000

Sample Input Explanation
r A s B

Sample Output
2007

--------------------------------------------------------------------------------
-------------------------------- SOLUTION LOGIC --------------------------------
Rearrage population projection for ending year.
B = A * (r/100+1) ^ (e-s)
ln(B/A) = (e-s) ln(r/100+1)
e = ln(B/A)/ln(r/100+1) + s
e = log_(r/100+1)(B/A) + s (if language supports log base)

----------------------------------------------------------------------------------
-------------------------------- PROGRAM COMMENTS --------------------------------
Program to find the year of a population projection.
@author Vincent Zhang
@since 07 August 2021
@context Self-Learning Python 3
"""

import math

line = list(map(float, input().split()))
r, a, s, b = line[0], line[1], line[2], line[3]
print(round(s + math.log(b/a, r/100+1)))