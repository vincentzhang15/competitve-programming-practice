"""
---------------------------------------------------------------------------
---------------------------- BlueBook - Voting ----------------------------
Find the ballot count for candidates denoted by letters A-F.
Find the number of spoiled ballots.
First line of input will contain number of votes.

Sample Input
5
A
B
C
B
%

Sample Output
1
2
1
0
0
0
1

Sample Output Explanation
Lines 1-6: votes for candidate A-F.
Line 7: number of spoiled votes.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
An iterative approach might loop and cout.
Another method is to group the letters, store in a list of tupples (letter, frequency).
Then lookup the frequency for "A" to "F".

In both cases, spoiled ballots can be obtained from subtraction of valid ballots from total ballots.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Counts ballots.
@author Vincent Zhang
@since 25 August 2021
"""

n = int(input())
data = [input() for _ in range(n)]
a = data.count("A")
b = data.count("B")
c = data.count("C")
d = data.count("D")
e = data.count("E")
f = data.count("F")
print(a)
print(b)
print(c)
print(d)
print(e)
print(f)
print(n-a-b-c-d-e-f)