"""
----------------------------------------------------------------------------------
---------------------------- ECOO '21 P2 - DNA Derren ----------------------------
Given a DNA genome sequence (string composed of 'A' 'C' 'T' 'G' characters),
output the order such that vowel and consonant alternate.
Add a space if two adjacent letters are both consonants/vowels.

Sample Input 1
ACTGAGCA

Sample Output 1
AC T GAG CA

Sample Input 2
AAAAGCGCTA

Sample Output 2
A A A AG C G C TA

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop through the string and process a pair of characters each time.

Loop through string:
    Method 1:
        Use for loop from 0 to DNA genome sequence length-1.
        Note: add an extra space at the end of input string to allow the last char to be processed without adding endpoint case.
    Method 2 (for Haskell):
        Recursive call and remove a character each time.

Processing pair characters:
    Method 1: output directly.
    Method 2: store data to char list/list/array. (See DNADerren.hs .py .c).

-------------------------------------------------------------------------
---------------------------- MODULE COMMENTS ----------------------------
Program to space out a DNA genome sequence.
@author Vincent Zhang
@since 30 July 2021
@context Self-Learning Python 3
"""

"""
Main function to solve the problem.
@return void
"""
def main():
    s = input() + " "
    print("".join( [s[i] if s[i] == 'A' and s[i+1] != 'A' or s[i] != 'A' and s[i+1] == 'A' else s[i] + ' ' for i in range(len(s)-1)] ))
main()