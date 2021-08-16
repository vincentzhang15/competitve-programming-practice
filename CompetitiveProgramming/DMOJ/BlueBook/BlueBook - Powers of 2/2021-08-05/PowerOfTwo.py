"""
--------------------------------------------------------------------------------
---------------------------- BlueBook - Powers of 2 ----------------------------
Find smallest power of two >= input integer.

Sample Input
200

Sample Output
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
log_2(input) yields the exponent to raise 2 to, to get "input".
Because:
    log_2(input) = a <==> 2^a = input
Thus, the smallest power of 2 >= input is the ceiling of log_2().

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the smallest power of 2 >= input integer.
@author Vincent Zhang
@since 05 August 2021
@context Self-Learning Python 3
"""

import math
print( math.ceil(math.log(int(input()), 2)) )