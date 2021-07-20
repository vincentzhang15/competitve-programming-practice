"""
###################################################################################
############################ CCCHK '08 J3 - Phone book ############################
Find the most frequently called person.
Ties are broken by a lower numerical phone number.

Sample Input
5
Mary 26000404
Susan 92132122
May 21232132
Ann 62343244
Peter 21321322
8
92132122
62343244
62343244
26000404
21321322
21232132
62343244
92132122

Sample Input Explanation
Line 1: n, number of contacts.
Line 2 to n+1: name number, in the contact list.
Line n+1+1: d, number of numbers that have been dialed.
Line n+1+1+1 to n+1+1+d: dialed numbers.

Sample Output
Ann

########################################################################
############################ SOLUTION LOGIC ############################
Store phonebook in dictionary to get O(1) name lookup by number.
Store frequency. Find max frequency. Find least value in max frequency.


#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 20 July 2021
@context Self-learning Python 3
"""

import sys

# Store contacts info.
c, f = {}, {}
for _ in range(int(sys.stdin.readline())):
    name, num = sys.stdin.readline().split()
    c[num], f[num] = name, 0

# Store frequency.
for _ in range(int(sys.stdin.readline())): f[sys.stdin.readline().strip()] += 1

# Output highest frequency and lowest numerical value.
maxx = max(f.values())
sys.stdout.write(c[min( [num for num in f if f[num] == maxx] )])
