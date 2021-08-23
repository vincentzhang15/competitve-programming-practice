"""
------------------------------------------------------------------------------------
---------------------------- CCC '21 J1 - Boiling Water ----------------------------
Find the atmospheric temperature of boiling water at different altitudes given by the temperature of boiling water.

P = 5 * B - 400

Sample Input 1:
99

Sample Input 1 Explanation:
B

Sample Output 1:
95
1

Sample Output 1 Explanation:
Line 1: P
Line 2: 1 when p < 100, 0 when p == 100, -1 when p > 100

Sample Input 2
102

Sample Output 2
110
-1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Substitute in equation. If statements.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the atmospheric pressure given temperature of boiling water.
@author Vincent Zhang
@since 23 August 2021
"""

"""
Solves the problem.
@return void
"""
def main():
    b = int(__import__("sys").stdin.readline())
    p = b * 5  - 400
    print(p)
    print(-1 if p > 100 else 0 if p == 100 else 1)
main()