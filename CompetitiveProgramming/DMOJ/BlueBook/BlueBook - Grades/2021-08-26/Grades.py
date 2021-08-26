"""
---------------------------------------------------------------------------
---------------------------- BlueBook - Grades ----------------------------
Determine the grade letter given an integer that is an element of (-1000, 1000)
    "
    A 	80 - 100
    B 	70 - 79
    C 	60 - 69
    D 	50 - 59
    F 	0 - 49
    X 	Anything else…
    "

Sample Input
3
10
99
101

Sample Output
F
A
X

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
If statements.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Find the grade leter of a grade value.
@author Vincent Zhang
@since 26 August 2021
"""

for _ in range(int(input())):
    x = int(input())
    if x >= 80 and x <= 100:
        print("A")
    elif x >= 70 and x <= 79:
        print("B")
    elif x >= 60 and x <= 69:
        print("C")
    elif x >= 50 and x <= 59:
        print("D")
    elif x >= 0 and x <= 49:
        print("F")
    else:
        print("X")
