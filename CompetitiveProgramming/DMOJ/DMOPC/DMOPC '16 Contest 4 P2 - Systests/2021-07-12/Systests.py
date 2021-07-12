"""
#################################################################################
############################ PYTHON 3 SYNTAX SUMMARY ############################
1. Binary Search Lower Bound
    import bisect
    lower = bisect.bisect_left(fail, batch.a)

2. Sort List
    fail.sort()

3. Review List Unpacking
    batches = [Data(*(list(map(int, input().split())))) for _ in range(int(input()))]

###########################################################################################
############################ DMOPC '16 Contest 4 P2 - Systests ############################
Goal: find number of total points.
Two lists:
    1. Contains batches of interval and point sets.
    2. Contains values that determine if an interval's points are valid.

Sample Input:
3
1 5 100
20 21 10
1 18 1
2
2
5

Sample Input Explanation:
Line 1            : n, number of batches of interval and point sets.
Line 2    ...n+1  : a b p, lower bound, upper bound, points for that interval.
Line n+2          : f, number of integers that make intervals invalid.
Line n+2+1...n+2+f: if these integers are within an interval, the interval's points are invalid.

Sample Output:
10

########################################################################
############################ SOLUTION LOGIC ############################
Store both sets of data.
Sort the set of values that devalues an interavl.
Loop through every interval and point set.
    Use the binary search lower bound to find the lower bound of the left boundary in list 2.
    Compare to the upper bound without calling upper bound. If lower bound is equal to the result of upper bound, add points. Two cases:
        1. Lower bound points at the max value in the list. Add points.
        2. OR fail at lower bound is greater than upper bound in the interval and point set. Add points.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 12 July 2021
@context Learning Python 3
"""

# Use sys to spead up input. Use bisect to find the lower_bound() C++ alternative.
import sys, bisect
# Set input to fast input, so input() will execute sys.stdin.readline().
input = sys.stdin.readline

"""
Data class to store the points for each interval.
@author Vincent Zhang
@since 12 July 2021
@context Learning Python 3
"""
class Data:
    """
    Equivalent to the constructor method in Java. Initializes values upon instantiation.
    @param self The name of a reference variable used for the Data class; "self" can be named something else
    @param a Lower bound in interval
    @param b Upper bound in interval
    @param p Points of the interval
    @return void
    """
    def __init__(self, a, b, p):
        self.a = a
        self.b = b
        self.p = p

# Store two input lists.
batches = [Data(*(list(map(int, input().split())))) for _ in range(int(input()))]
fail = [int(input()) for _ in range(int(input()))]

# Sort list 2.
fail.sort()

# Calculate the points.
points = 0
# Loop through every interval and point set.
for batch in batches:
    # bisect.bisect_left(list, value) is an alternative to lower_bound() in C++.
    lower = bisect.bisect_left(fail, batch.a)
    # More efficient way of comparing lower_bound() with upper_bound() by comparing with upper_bound() result rather than calling upper_bound() (bisect.bisect_left()).
    if lower == len(fail) or fail[lower] > batch.b:
    # Equivalent alternative: "if lower == upper:", where "upper = bisect.bisect_left(fail, batch.b)"
        points += batch.p

# Output
print(points)