"""
----------------------------------------------------------------------------------
---------------------------- BlueBook - Cross Country ----------------------------
Given a two digit code, output one of the following corresponding results.
If a code does not exist output "invalid code".

Code 	Output
MG 	    midget girls
MB 	    midget boys
JG 	    junior girls
JB 	    junior boys
SG 	    senior girls
SB 	    senior boys

Sample Input
JG

Sample Output
junior girls

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Store codes in a map or check cases with if-else.

-------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ---------------------------
Program to output the matching result of a code if it exists.
@author Vincent Zhang
@since 01 August 2021
@context Self-Learning Python 3
"""

d = {
    "MG" : "midget girls",
    "MB" : "midget boys",
    "JG" : "junior girls",
    "JB" : "junior boys",
    "SG" : "senior girls",
    "SB" : "senior boys"
}
s = input()
print("invalid code" if s not in d else d[s])