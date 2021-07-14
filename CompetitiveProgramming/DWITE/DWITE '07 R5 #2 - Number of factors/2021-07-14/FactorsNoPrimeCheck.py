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

The following code implements Method 3: no prime check, loop from [2, n).

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 14 July 2021
@context Learning Python 3
"""

"""
Function to count the number of valid prime factors.
@param n The number to find the factors for.
@return The number of valid prime factors
"""
def factors(n):
    # 2 is an exception to the factor finding process since factor checking must start at 2
    # and 2 is not a prime factor by itself as defined by this question.
    if n == 2: return 0

    # Find the number of factors.
    count = 0
    for i in range(2, n):
        # No need to check if value is prime if fully divided.
        while n % i == 0:
            n /= i
            count += 1
    return count

# Input, process, output.
for _ in range(5): print(factors(int(input())))