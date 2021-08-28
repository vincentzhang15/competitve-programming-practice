"""
-----------------------------------------------------------------
---------------------------- Boolean ----------------------------
Evaluate a boolean expression.

Sample Input 1
not not True

Sample Output 1
True

Sample Input 2
not not not False

Sample Output 2
True

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Count the number of "not". Even number will cancel out. Only need to apply one negation if odd.
Another way is to XOR while taking input, and compare initial assumed value with final True/False.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Evaluates a boolean expression.
@author Vincent Zhang
@since 28 August 2021
"""

words = input().split()
if len(words) == 1:
    print(words[0])
else:
    v = words.count("not")
    if v % 2 == 0:
        print(words[-1])
    else:
        if words[-1] == "True":
            print("False")
        else:
            print("True")
