"""
#############################################################################################
############################ DWITE '07 R5 #2 - Number of factors ############################
Given 5 integers, separated by new lines, output the number of prime factors.
If number is prime, output 0.

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
General logic:
    loop through each of the 5 lines:
        loop through factors (different methods):
            divide fully by factor
            count number of valid factors

Method 1 (prime check with Sieve of Eratosthenes algorithm):
    pre-compute primes up to and including 32.
    For each of the 5 numbers, loop through the pre-computed primes:
        while n is divisible by prime:
            divide, add counter

Method 2 (prime check with square root):
    loop through factors from [2, 32] for every "n":
        for every [2, 32], check if it is prime by checking divisibility up to int(sqrt(n)):
            if prime: while "n" is divisible:
                divide, add counter

Method 3 (no prime check, loop from [2, n) ):
    loop through each number and loop through factors from [2, n)
        fully divide by every divisible factor
    
    By divividing fully from 2, the remaning divisible factors will always be prime.
    This method shares concepts with the Sieve of Eratosthenes algorithm:
        i.e., every multiple of a prime is not prime.
        A multiple of a prime is in the form p * k, where p is the prime, and k is the factor
        p * k = p * p * ... * p * p, k times.
        Thus, by dividing fully starting from 2, all subsequent divisible values must be prime.
        (There are no multiples of primes after checking that number)
            e.g., after checking 2 fully, there will be no multiple of 2 remaining in "n", thus, 4, 6, 8,.. will never become factors of "n"
    
    The boundary is [2, n) and NOT [2, int(sqrt(n))+1] because:
        1. 2 is the first prime.
        2. within the scope of this problem, "n" itself is not a factor.
        3. there may be prime in upper half of int(sqrt(n))
            e.g, 26 = 2*13 while int(sqrt(26)) = 5, looping from [2, int(sqrt(n))+1] will lose a factor
                A fix for when the range is [2, int(sqrt(n))+1], is to check if n is 1 and n is not prime (check not prime by comparing with "n" at input-time) at the end.
                This would make +1 to the upper bound redundant as a check is performed anyway.
                This is a nice segue to Method 4.

Method 4 (indirect prime check, loop from [2, int(sqrt(n))] ):
    Loop n, through 5 input:
        Loop i, [2, int(sqrt(n))]:
            While n divisible by i:
                divide n, count+1
        if (n != original input "n" and not n != 1, i.e., n not prime): count + 1
            Why? See Proof 1 below.
        print count
    
    Proof 1 (Proof by Contradiction) - A composite natural number "n" can have at most one prime factor > sqrt(n):
        Let "n" be a composite natural number.
        Let "a" be a prime factor of "n".
        Let "b" be a prime factor of "n".
        Let "c" be a factor of "n".

        a * b = n / c
        Suppose both "a" and "b" > sqrt(n), then,
        >sqrt(n) * >sqrt(n) = n / c
        >n = n / c
        This shows the proposition to be absurd.
        Thus, a composite natural number "n" can have at most one prime factor above sqrt(n).

The following code implements Method 1: prime check with Sieve of Eratosthenes.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 14 July 2021
@context Learning Python 3
"""

import sys

# Global variables.
MAX = 32
isPrime = [1] * (MAX+1) # Index starts at 0 so +1 to set right-closed bound at 32.

"""
Perform activities before taking any input.
@return void
"""
def init():
    computePrimes()

"""
Use the Sieve of Eratosthenes algorithm to pre-compute primes.
@return void
"""
def computePrimes():
    global isPrime
    for i in range(2, MAX//2 + 1):
        if isPrime[i]:
            # Every multiple of a prime is not prime.
            for j in range(2, MAX // i + 1):
                isPrime[i*j] = 0

"""
Find all the prime "factors" as defined by the question, i.e., a prime number itself and 1 are not factors in this problem.
@return void
"""
def primeFactors(n):
    # This problem states that a prime number itself is not a factor.
    if isPrime[n]:
        return 0
    
    # Count the number of prime factors.
    count = 0
    for i in range(2, MAX+1):
        if isPrime[i]:
            while n % i == 0:
                n /= i
                count += 1
    return count

"""
Main method to control program flow: compute primes, input, process, output.
@return void
"""
def main():
    # Pre-compute primes.
    init()

    for _ in range(5):
        # Input, process, output.
        print(primeFactors(int(sys.stdin.readline())))

# main() will only run when code is run within this module, i.e., not imported.
if __name__ == "__main__": main()
