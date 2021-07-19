"""
###################################################################################################
############################ CCC '20 S1 - Surmising a Sprinter's Speed ############################
Find the max possible speed of a sprinter, given observations of their positions at various times.

Sample Input 1
3
0 100
20 50
10 120

Sample Input 1 Explanation
Line 1: n, number of observations.
Lin3 2...n+1: time position, observations.

Sample Output 1
7.0


Sample Input 2
5
20 -5
0 -17
10 31
5 -3
30 11

Sample Output 2
6.8

########################################################################
############################ SOLUTION LOGIC ############################
speed = distance / time
    distance = |displacement|
    displacement = pos2 - pos1
speed = |pos2 - pos1| / time
The max of speed will be the answer.
Ensure to sort the data structure by time as one cannot travel back in time in this question.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 19 July 2021
@context Self-Learning Python 3
"""

import sys; input = sys.stdin.readline
n = int(input())

# Store time and position in a list of tuples and sort the list will sort by tuple[0].
timePos = [ tuple(map(int, input().split())) for _ in range(n)]; timePos.sort()

# Speed is distance / time where distance is abs(pos2-pos1).
speed = [ abs(timePos[i+1][1]-timePos[i][1]) / (timePos[i+1][0]-timePos[i][0]) for i in range(n-1) ]

print(max(speed))