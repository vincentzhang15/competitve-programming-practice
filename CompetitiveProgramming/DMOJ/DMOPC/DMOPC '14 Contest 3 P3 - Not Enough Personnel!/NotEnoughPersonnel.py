"""
########################################################################################################
############################ DMOPC '14 Contest 3 P3 - Not Enough Personnel! ############################
A business is hiring new employees who will learn alongside a veteran employee.
Each new employee has a skill and adaptability value.
A veteran must be at least the same skill level as a new employee and at most the same skill level + adaptability value.
If multiple veterans qualify, then the one with the closest value should be chosen. Break any additional ties with inupt order.
If there are no matches then output "No suitable teacher!".

Sample Input 1
5
Kanie 1000
Moffle 800
Sento 950
Macaron 550
Tirami 500
3
930 20
400 150
790 15

Sample Input 1 Explanation
Line 1: n, number of veterans.
Line 2 to n+1: veteran name and skill level.
Line n+1+1, q, number of new employees.
Line n+1+1+1 to n+1+1+q: skill level and adaptability of new employees.

Sample Output 1
Sento
Tirami
Moffle

Sample Input 2
4
Muse 203
Sylphy 202
Koboli 202
Salama 999
2
200 1
200 3

Sample Output 2
No suitable teacher!
Sylphy

########################################################################
############################ SOLUTION LOGIC ############################
Store the veterans name and skill in a 2d list or two 1d lists as sorting is not required so order is preserved.
Loop through every new employee and find the veteran with the closest skill level
by checking if skill is within range and if skill differance is less than the existing difference.

#########################################################################
############################ MODULE COMMENTS ############################
Program to match new employees with veteran employees.
@author Vincent Zhang
@since 24 July 2021
@context Self-learning Python 3
"""

import sys

# Fast input.
input = sys.stdin.readline

# Store veteran name and skill in 2d list where skill is int.
veteran = [ list( map( lambda x: x if x[0].isalpha() else int(x), input().strip().split() ) )  for _ in range(int(input())) ]

# Find match.
for _ in range(int(input())):
    skill, adaptability = map(int, input().split())
    dist, name = int(1e6), ""
    for vet in veteran:
        # Veteran within range and with minimum distance in skill with new employee.
        if vet[1] >= skill and vet[1] <= skill+adaptability and vet[1] - skill < dist:
            dist = vet[1] - skill
            name = vet[0]
    print(name) if name else print('No suitable teacher!')