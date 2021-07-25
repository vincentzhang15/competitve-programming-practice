"""
#####################################################################################
############################ TLE '15 P1 - Power Rankings ############################
Output the rankings of names based on number of minutes viewing PowerPoints.
The ranking is ordered by 3 + students with a greater total time viewing PowerPoints.

Sample Input
5 3
EnochPoon
LiuJason
Nathanl3
AlexW
TT1103
3 4 2 1 0
1 3 4 2 0
5 1 7 4 0

Sample Input Explanation
L1: n p, number of names, number of PowerPoints.
L2 to Ln+1: names.
Ln+1+1 to Ln+1+p: t[0] t[1] ... t[n], time the ith student spends on a PowerPoint.

Sample Output
3. Nathanl3
4. EnochPoon
5. LiuJason
6. AlexW
7. TT1103

########################################################################
############################ SOLUTION LOGIC ############################
Pair time and name of each person.
Sort by time in reverse order.
Output starting from 3.

#########################################################################
############################ MODULE COMMENTS ############################
Program to determin the "power rankings".
@author Vincent Zhang
@since 25 July 2021
@context Python 3 Autodidacticism
"""

import sys
input = sys.stdin.readline

# Get pairs of time and name.
n, p = map(int, input().split())
data = [[0, input().strip()] for _ in range(n)]
for _ in range(p):
    row = list(map(int, input().split()))
    for i in range(len(row)):
        data[i][0] += row[i]

# Output reversed sorted list of data.
rank = 3
for i in reversed(sorted(data)):
    print(f"{rank}. {i[1]}")
    rank+=1