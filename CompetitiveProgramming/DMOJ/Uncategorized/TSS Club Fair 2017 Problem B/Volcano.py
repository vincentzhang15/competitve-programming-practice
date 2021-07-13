"""
############################################################################
############################ NEW SYNTAX SUMMARY ############################
1. Python Lambda Expression
    lambda a : a*a

######################################################################################
############################ TSS Club Fair 2017 Problem B ############################
A volcano may potentially erupt. Houses sorround the volcano.
Determine how many houses will be destroyed within a list of radii from the volcano.

Sample Input
4 3
2 2
-4 0
0 -5
-5 -5
2
4
6

Sample Input Explanation
Line 1: n q, number of houses, number of radii.
Line 2 to n+1: dx dy, relative position of a house from the volcano.
Line n+1+1 to n+1+q: different radii to output how many houses will be destroyed for each case.

Sample Output
0
2
3

########################################################################
############################ SOLUTION LOGIC ############################
Store processed houses. Houses processed by its distance to the volcano squared.
    Squared removes the need to sqrt() and ceil().
Sort the stored distance of houses.
Perform binary search upper bound to find the index of the upper bound of a house.
    The index will be the number of houses within the radius squared since index starts at 0.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 12 July 2021
@context Learning Python 3
"""

# Use sys for fast input. Use bisect for C++ upper_bound() equivalent.
import sys, bisect
# Use input() as sys.stdin.readline() for convenience.
input = sys.stdin.readline

n, q = map(int, input().split())

# Store the distance squared from volcano to house.
houses = [sum(map(lambda a : a*a, map(int, input().split()))) for i in range(n)]
"""
# Expanded version of the one liner above.
houses = []
for i in range(n):
    dx, dy = map(int, input().split())
    rs = dx*dx + dy*dy
    houses.append(rs)
"""

# Sort for binary search upper bound.
houses.sort()

# Find upper bound and output result.
for i in range(q):
    print(bisect.bisect_right(houses, int(input())**2))