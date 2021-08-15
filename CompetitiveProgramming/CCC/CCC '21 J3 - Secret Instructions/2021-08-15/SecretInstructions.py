"""
------------------------------------------------------------------------------------------
---------------------------- CCC '21 J3 - Secret Instructions ----------------------------
Determine the direction of travel and number of steps given 5-digit numbers, e.g., 12345.

First two digits represent direction of turn.
    Sum odd: left
    Sum even: right
    Sum zero: previous direction
Last three digits is number of steps.
"99999": end program.

Sample Input
57234
00907
34100
99999

Sample Output
right 234
right 907
left 100

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Take input as string and extract first two digits.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to determine directions.
@author Vincent Zhang
@since 15 August 2021
"""

import sys

"""
Solves the problem.
@return void
"""
def main():
    input = sys.stdin.readline
    p = None
    while 1:
        line = input().strip()
        if line == "99999":
            break
        sum = int(line[0]) + int(line[1])
        if sum == 0:
            print(f"{p} {line[2:]}")
        elif sum % 2 == 0:
            print(f"right {line[2:]}")
            p = "right"
        else:
            print(f"left {line[2:]}")
            p = "left"
main()