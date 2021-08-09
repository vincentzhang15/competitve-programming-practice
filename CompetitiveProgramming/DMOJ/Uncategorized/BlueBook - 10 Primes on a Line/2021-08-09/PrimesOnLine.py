"""
----------------------------------------------------------------------------------------
---------------------------- BlueBook - 10 Primes on a Line ----------------------------
Print the first "m" (5 <= m <= 500) primes, 10 to a line, interspersed by spaces.

Sample Input
5

Sample Output
2 3 5 7 11

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Pre-compute primes with the Sieve of Eratosthenes algorithm:
    Every multiple of a prime is not prime.
    Start with 2, 2 is prime.
    Mark all multiples of 2 as not prime.
    The first of all subsequent primes are prime and all multiples of such numbers are composites.

--------------------------------------------------------------------------
---------------------------- Program Comments ----------------------------
Program to print the first "m" primes.
@author Vincent Zhang
@since 09 August 2021
@context Self-Learning Python 3
"""

"""
Pre-computes primes with the Sieve of Eratosthenes algorithm.
@return List of values from 0 to 5000 inclusive, marked whether prime or not.
"""
def sieveEratosthenes():
    isPrime = [1]*5001
    for i in range(2, 5000):
        if isPrime[i]:
            for j in range(2, 5000):
                if i * j > 5000:
                    break
                isPrime[i*j] = 0
    return isPrime

"""
Solves the problem.
@return void
"""
def main():
    isPrime = sieveEratosthenes()
    n = int(input())
    i = 2
    count = 0
    while n > 0:
        if isPrime[i]:
            print(i, end=' ')
            count += 1
            n -= 1
        if count == 10:
            print()
            count = 0
        i += 1

# Run program only from this module.
if __name__ == "__main__": main()