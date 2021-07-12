"""
######################################################################################
############################ PYTHON REGEX & REGEX PATTERN ############################
1. Get List of Matches
    import re
    newList = re.findall("REGEX PATTERN", STRING TO SEARCH IN)

2. Match Alpha
    "[a-zA-Z]"

3. Match by Minimum Occurance
    "{n,}" <-- previous match occures at least n times.

4. Match Alpha & Minimum Occurance
    "[a-zA-Z]{4,}" match words where alpha characters consecutively appear at least 4 times.

#######################################################################################
############################ DWITE '08 R3 #2 - Wordcount++ ############################
Count number of words with length > 3 for each of the 5 lines of input.

Sample Input
DWITE question number two: Wordcount++
Note how "two:" does not count.
For simplicity - "don't" is two words, split by apostrophe.

That was a blank line above.

Sample Output
4
3
4
0
4

########################################################################
############################ SOLUTION LOGIC ############################
Match words with regular expression. Two regex conditions must be satisfied:
    1. is alpha.
    2. at least 4 consecutive alpha characters.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 12 July 2021
@context Learning Python 3
"""

# Use sys for fast input. Use re for regular expression.
import sys, re

# For each of the 5 lines of input, print the list of valid words that regex matches.
for _ in range(5): print(len(re.findall("[a-zA-Z]{4,}", sys.stdin.readline())))