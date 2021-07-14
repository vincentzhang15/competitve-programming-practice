"""
#############################################################################################
############################ DWITE '07 R5 #2 - Number of factors ############################
Find the number of prime factors. A prime number itself has no factors defined within the scope of this problem.

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

The following code implements Method 4: indirect prime check, loop from [2, int(sqrt(n))].

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 14 July 2021
@context Learning Python 3
"""

for _ in range(5):
    # Store a copy of "n" for indirect prime checking.
    copy = n = int(input())
    count = 0
    
    # Count number of valid factors.
    for i in range(2, int(n**0.5)+1):
        while n % i == 0:
            n /= i
            count += 1
    
    # A composite number may have a prime factor > sqrt(n).
    if n != copy and n != 1: count += 1

    # Output.
    print(count)