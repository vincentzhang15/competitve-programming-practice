"""
#########################################################################################
############################ CCC '04 J3 - Smile with Similes ############################
Create similes with a list of adjectives and a list of nouns.
Order of output does not matter.

Sample Input
3
2
Easy
Smart
Soft
pie
rock

Sample Input Explanation
L1: n, number of adjectives.
L2: m, number of nouns.
L2+1 to L2+n: list of adjectives.
L2+n+1 to L2+n+m: list of nouns.

Sample Output
Easy as pie
Easy as rock
Smart as pie
Smart as rock
Soft as pie
Soft as rock

########################################################################
############################ SOLUTION LOGIC ############################
Loop through adjectives and nouns in nested loop and print.

Haskell Solution Logic:
    Store entire list of input.
    Match adjectives generator with nouns generator.
        Adj generator: first n items in entire list excluding first two lines.
        Noun generator: last m items in entire list. First m of reversed list.

#########################################################################
############################ MODULE COMMENTS ############################
Program creates similes with adjectives and nouns.
@author Vincent Zhang
@since 31 July 2021
@context Self-Learning Python 3
"""

n, m = int(input()), int(input())
a = [input() for _ in range(n)]
b = [input() for _ in range(m)]

for aa in a:
    for bb in b:
        print(f"{aa} as {bb}")