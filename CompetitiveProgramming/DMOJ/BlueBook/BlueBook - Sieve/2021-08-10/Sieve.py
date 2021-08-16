"""
--------------------------------------------------------------------------
---------------------------- BlueBook - Sieve ----------------------------
For the first "N" numbers (1 <= n <= 500), print whether it is prime
denoted by "0" or "1", using the Sieve of Eratosthenes algorithm.

Sample Input
9

Sample Output
0
1
1
0
1
0
1
0
0

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Direct implementation.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to implement the Sieve of Eratosthenes algorithm.
@author Vincent Zhang
@since 10 August 2021
@context Self-Learning Python 3
"""

n = int(input())

isPrime = [1] * (n+1)

isPrime[0] = 0
isPrime[1] = 0
for i in range(2, n):
    if isPrime[i]:
        for j in range(2, n):
            if i * j <= n:
                isPrime[i*j] = 0
for i in range(1, n+1):
    print(isPrime[i])