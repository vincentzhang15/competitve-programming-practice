"""
################################################################################
############################ ECOO '19 R2 P1 - Email ############################
In each of the total 10 sets of data, find the number of unique emails by following the rules:
"
    --> The entire address is case-insensitive.
    --> Dots (.) before the at-sign (@) sign are ignored.
    --> A plus (+) followed by any string can be added before the at-sign (@). The plus and following string are ignored.
"

Sample Input:
3
foo@bar.com
fO.o+baz123@bAR.com
foo@bar..com
3
c++@foo.com
c...@Foo.com
.c+c@FOO.COM

Sample Input Explanation:
Line 1: n[0], number of emails in set 1.
Line 2 to n[0]+1: emails in set 1.
...
Note: only two sets of data are shown.

Sample Output:
2
1

########################################################################
############################ SOLUTION LOGIC ############################
Direct implementation by finding the index of the "+" and "@" signs.
Process each segment accordingly.
Store email in a set. The answer is the length of the set.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 10 July 2021
@context Learning Python 3
"""

import sys;

# 10 sets of data.
for _ in range(10):
    # Store data in set to remove repetition.
    dataset = set()
    n = int(sys.stdin.readline())
    for i in range(n):
        rawEmail = sys.stdin.readline()
        idxPlus = rawEmail.find("+")
        idxAt = rawEmail.find("@")

        """
        Segment 1: remove all ".".
            Case 1: start to plus sign.
            Case 2: start to at sign if plus does not exist.
        Segment 2: leave alone.
            Only Case: at sign to end.
        """
        email = rawEmail[:idxPlus if idxPlus != -1 else idxAt].replace(".", "") + rawEmail[idxAt:]
        
        # Perform .lower() last to ensure no extra time is wasted lowering invalid characters.
        dataset.add(email.lower())
    # Output answer.
    print(len(dataset))