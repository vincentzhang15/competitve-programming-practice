"""
VERDICT: Fastest PyPy3 Submission
1.50s

Next 5 Submissions
1.53s
1.55s
1.73s
1.81s
3.34s


INPUT
this is a very interesting sentence and you will agree
4
1 4 h
6 6 p
15 26 t
1 54 e


NOTES
 FREQUENCY---------
a 
b
c
d
e
|
|
"""

import sys

def main():
    input = sys.stdin.readline

    s = input().strip()
    ls = len(s)+1

    data = [[0]*ls for _ in range(26)]

    for i in range(1, ls):
        c = s[i-1]
        if c != ' ':
            idx = ord(c) - 97
            data[idx][i] += 1
    for i in range(26):
        for j in range(1, ls):
            data[i][j] += data[i][j-1]

    for _ in range(int(input())):
        a, b, c = input().strip().split()
        a = int(a)
        b = int(b)
        idx = ord(c) - 97
        print(data[idx][b]-data[idx][a-1])
main()