"""
#############################################################################################
############################ DWITE '07 R5 #2 - Number of factors ############################
Find the number of prime factors. A prime number itself has no factors.

Sample Input
3
4
5
12
32

Sample Input Explanation
Line 1 to 5: n, 2 <= n <= 32.

Sample Output
0
2
0
3
5

########################################################################
############################ SOLUTION LOGIC ############################
See FactorsSievePrimeCheck.py for details.

The following code implements Method 2: prime check by square root.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 14 July 2021
@context Learning Python 3
"""

MAX = 32

for _ in range(5):
    n = int(input())
    count = 0

    # Count number of valid prime factors.
    for i in range(2, MAX):
        # Check if "i" is prime.
        isPrime = 1
        # Check up to and including the square root of "i".
        for j in range(2, int(i**0.5) +1):
            if i % j == 0:
                isPrime  = 0
                break
        # If "i" is prime, fully divide "n" with "i".
        while isPrime and n % i == 0:
            n /= i
            count += 1
    
    # When i=2, count == 1, since 2 is prime.
    print(0) if count == 1 else print(count)