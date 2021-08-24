"""
---------------------------------------------------------------------------------
---------------------------- BlueBook - Times Tables ----------------------------
Create a times table for "n" from 1 to n.

Sample Input
5

Sample Output
5 X 1 = 5
5 X 2 = 10
5 X 3 = 15
5 X 4 = 20
5 X 5 = 25

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop from 1 to n and multiply.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Creates a column in a times table.
@author Vincent Zhang
@since 24 August 2021
"""

n = int(input())
for i in range(1, n+1):
    print(f"{n} X {i} = {n*i}")