"""
-------------------------------------------------------------------------------------------
---------------------------- DMOPC '20 Contest 5 P1 - Home Row ----------------------------
Given two strings, find the minimum keystrokes to change the first string to the second string.
Strings will always be lowercase alphabet characters.
Keystrokes available:
    1. Type a lowercase letter.
    2. Delete a letter from the end of the string.

Sample Input 1
adachi
shimamura

Sample Output
15

Sample Input 2
shinomiya
shirogane

Sample Output 2
12

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
A matching prefix is the only part of the first string that does not need to be changed.
Every subsequent character in the first string needs to be deleted from the string.
Every subsequent character in the second string needs to be added to the first string.

Procedural Programming Langage Implementation (see HomeRow.py .cpp .c .java)
    Step 1: loop through characters in both strings to find the length of the equal prefix.
    Step 2: calculate result.
        Method 1: len(s1)+len(s2) - 2 * number of non equivalent characters.
            e.g,
              aaaaabcde    -> aaaaa bcde
              aaaaacdefghi -> aaaaa cdef    ghi
              +len                  -2*len
        Method 2: 2*non equivalent chars + diff in string lengths
            e.g,
              aaaaabcde    -> aaaaa bcde
              aaaaacdefghi -> aaaaa cdef    ghi
                                    2*len   +len

Functional Programming Language Implementation (see HomeRow.hs)
    Method 1: drop all matching characters with a recursive function.
        This leaves a list with length equal to number of non-equivalent chars.
        Apply Method 2 formula in the procedural section above.
    Method 2: find the first index where different chars occur (in forward or reverse direction).
        With the index, apply Method 1 formula in the procedural section above.
        This method is slower than Method 1 for long strings in Haskell because Haskell's (!!) operator is O(N).
        Which means, the recursive calls to find the index will be costly, especially if trying to find index at end with forward find and front index with reverse find.

-------------------------------------------------------------------------
---------------------------- MODULE COMMENTS ----------------------------
Program to find the minimum keystrokes required to make the first string identical to the second.
@author Vincent Zhang
@since 29 July 2021
@context Self-Learning Python 3
"""

s1, s2 = input(), input()
s1Len, s2Len = len(s1), len(s2)

i = 0
for _ in range(min(s1Len, s2Len)):
    if s1[i] != s2[i]:
        break
    i += 1

print(s1Len + s2Len - i - i)