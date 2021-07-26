"""
###########################################################################################################
############################ TLE '16 Contest 6 (Mock CCC) S1 - Writing the CCC ############################
"The CS Nerd" solves problems in order of preference by problem type.
Input will first give a list of question prefernces in order.
The second part of the input will give the order of question types on the CCC (Canadian Chemistry Competition).
Output the order in which "the CS nerd" solves the problems according to the order of preference.

Sample Input
5
equilibrium
trivial
organic
lab
adhoc
7
trivial
organic
adhoc
equilibrium
trivial
lab
adhoc

Sample Input Explanation
L1: t, number of problem types.
L2 to Lt+1: problem types in order of preference.
Lt+1+1: n, number of questions on the CCC.
Lt+1+1 to Lt+1+n: questions types on the CCC in order that it appears on the contest.

Sample Output
4
1
5
2
6
3
7

########################################################################
############################ SOLUTION LOGIC ############################
Store prefernce order in a list/array to process later.
For fast output of order, a dict/map can be used in which the reference to the map would lead to the positions of all occurances of a problem type.
    dict = {type, [occurance position1, pos2, ...]}

#########################################################################
############################ MODULE COMMENTS ############################
Program to find the order of solving problems.
@author Vincent Zhang
@since 26 July 2021
@context Self-learning Python 3
"""

import sys

"""
Main function to solve the problem.
@return void
"""
def main():
    # Fast input.
    input = sys.stdin.readline

    # Store input.
    order = [] # Order of preference.
    data = {} # Order of occurance.

    # Store order of preference and initialize order of occurance.
    for _ in range(int(input())):
        choice = input().strip()
        order.append(choice)
        data[choice] = []

    # Store order of occurance.
    for i in range(int(input())):
        choice = input().strip()
        data[choice].append(i+1)

    # Output result.
    for choice in order:
        for pos in data[choice]:
            print(pos)
main()