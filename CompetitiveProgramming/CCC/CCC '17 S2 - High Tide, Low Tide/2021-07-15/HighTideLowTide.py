"""
##########################################################################################
############################ CCC '17 S2 - High Tide, Low Tide ############################
Given a series of scrambled low and high tide measurements, find the right order according to rules:
    1. Measurements alternate starting with low tide.
    2. All high tide > low tide.
    3. High tides increase. Low tides decrease.

Sample Input
8
10 50 40 7 3 110 90 2

Sample Input Explanation
Line 1: number of measurements.
Line 2: unordered measurements of low and high tide.

Sample Output
10 40 7 50 3 90 2 110

########################################################################
############################ SOLUTION LOGIC ############################
Sort tides.
Low tides = Reverse first half of tides (1 more measurement than latter half if odd number of tides)
High tides = latter half of tides.
Output tides alternating low and high.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 15 July 2021
@context Python 3 Autodidacticism
"""

# Fast input.
import sys; input = sys.stdin.readline

# Get input and sort tides.
n = int(input())
tides = list(map(int, input().split()))
tides.sort()

# Split the list to low and high tides.
mid = n-1 >> 1
lo = tides[mid::-1]
hi = tides[mid+1:]

# Make use of Python 3's list stack-like feature to concatenate the output string.
output = ""
while len(lo) != 0 or len(hi) != 0:
    if len(lo) != 0: output += str(lo.pop(0)) + " "
    if len(hi) != 0: output += str(hi.pop(0)) + " "

# Remove extra space at end.
print(output.rstrip())