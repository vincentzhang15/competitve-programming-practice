"""
-------------------------------------------------------------------------------------
---------------------------- CCC '21 J2 - Silent Auction ----------------------------
Find the name of the first bidder with the highest price.

Sample Input 1
3
Ahmed
300
Suzanne
500
Ivona
450

Sample Output 1
Suzanne

Sample Input 2
2
Ijeoma
20
Goor
20

Sample Output 2
Ijeoma

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find the max price.
Find the first name with the max price.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the first highest bidder.
@author Vincent Zhang
@since 23 August 2021
"""

import sys

"""
Solves the problem.
@return void
"""
def main():
    input = sys.stdin.readline

    cName, mName, cPrice, mPrice = "", "", -1, -1
    for i in range(int(input())):
        cName, cPrice = input(), int(input())
        if cPrice > mPrice:
            mPrice = cPrice
            mName = cName
    print(mName.rstrip())
main()