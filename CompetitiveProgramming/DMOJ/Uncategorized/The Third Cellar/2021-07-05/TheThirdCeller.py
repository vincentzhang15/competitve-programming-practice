"""
KEY CONCEPTS SUMMARY
1. Sieve of Eratosthenes
    Assume all numbers within a range is prime.
    0, 1 are not prime.
    Start from 2, for every prime, it's multiples greater than itself are not prime.

2. Process Section of List
    sum(isPrime[a:b])
"""

"""
NEWLY LEARNT CONCEPTS SUMMARY
https://stackoverflow.com/questions/24578896/python-built-in-sum-function-vs-for-loop-performance
1. Python sum()
    sum() is faster than looping since sum() loops in C code entirely rather than bytecode.
    "The C code makes sure not to create new Python objects if it can keep the sum in C types instead; this works for int and float results."
"""

"""
The Third Cellar
Find the # of primes within each left-closed right-opened interval.

Sample Input:
2
1 1000
1000 4000

Sample Input Explanation:
Line 1: n, # of lines to follow. n < 20.
Line 2 to n+1: "a" "b", interval to find the # of primes. a, b < 1 000 000.

Sample Output:
168
382

@author Vincent Zhang
@since 05 July 2021
@context Learning Python 3
"""

# Global variables.
MAX = 1000000
isPrime = [1 for i in range(MAX)]

"""
Compute the primes using the Sieve of Eratosthenes algorithm. Store primes in "isPrime" by index.
@return void
"""
def computePrimes():
    isPrime[0] = isPrime[1] = 0
    for i in range(2, MAX):
        if isPrime[i]:
            # Every multiple of a prime > the prime itself is not prime.
            for j in range(2, MAX):
                if i*j >= MAX: break
                isPrime[i*j] = 0

"""
Controls program flow: initialization, input, process, output.
@return void
"""
def main():
    # Pre-compute primes.
    computePrimes()

    # Answer the question.
    n = int(input())
    for i in range(n):
        a, b = map(int, input().split())

        # sum() is faster than loop as sum() loops in C code rather than bytecode.
        print(sum(isPrime[a:b]))

# Run program only when the program is ran from this module.
if __name__ == "__main__": main()