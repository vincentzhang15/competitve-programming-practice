"""
########################################################################
############################ SYNTAX SUMMARY ############################
1. Find All Matches
    re.findall(regex, string)
    returns list

2. Regex Syntax
    "0+|1+":
        "0+": one or more 0s.
        "1+": one or more 1s.
        "|": logical or.

3. Remove Trailling Characters
    print: "1,,0.,a".rstrip(".,0a")
    output: "1"

###########################################################################
############################ Flip the Switches ############################
"n" distinct switches make up a security system. Switch state denoted by 0 (off) and 1 (on).
Goal: turn off security system by turnning off all switches.
Tool: can only flip the first k switches together, where "k" is decided by the program.
Output the minimum number of times the switches need to be flipped to turn off the security system.

Sample Input
4
1001

Sample Input Explanation
Line 1: number of characters in next line.
Line 2: string of switch states.

Sample Output
3

########################################################################
############################ SOLUTION LOGIC ############################
Count the number of adjacent state changes.
One approach is to use regular expression to count number of matches to groups of 0 and 1.
One adjustment in this approach is to remove any trailling 0s because they don't need to be flipped.

Example: 001100
    Correct: 2 steps, manual method.
        001100
        110000
        000000

    Incorrect: 3 steps, regex matching with no adjustment.
        001100
        Match 1: 00
        Match 2: 11
        Match 3: 00

    Correct: 2 steps, regex matching with adjustment (remove trailing 0).
        001100 --> 0011
        Match 1: 00
        Match 2: 11

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 13 July 2021
@context Learning Python 3
"""

# re module allows the use of regular expression. first line of input is not useful for this solution approach.
import re; input()
# Count all matches of one or more 0s and 1s based on input stripped of any trailling 0s.
print(len(re.findall("0+|1+", input().rstrip("0"))))