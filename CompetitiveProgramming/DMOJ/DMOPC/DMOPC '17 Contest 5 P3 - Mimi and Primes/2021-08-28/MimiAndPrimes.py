# https://stackoverflow.com/questions/11175131/code-for-greatest-common-divisor-in-python

# PyPy Submission

import sys, math

def gcdEuclidean(a, b):
    while b:
        a, b = b, a%b
    return a

def isPrime(i):
    if i <= 1:
        return False
    for j in range(2, int(math.sqrt(i))+1):
        if i % j == 0:
            return False
    return True


def main():
    input = sys.stdin.readline
    input()
    data = [*map(int, input().split())]
    gcd = __import__("functools").reduce(gcdEuclidean, data)

    """
    # "gcd" can go up to 1000000000000000, which is too large to create a list for sieve of Eratosthenes.
    MAX = gcd+1
    isPrime = [1]*MAX
    for i in range(2, MAX):
        if isPrime[i]:
            for j in range(2*i, MAX, i):
                isPrime[j] = 0
    for i in reversed(range(2, MAX)):
        if isPrime[i] and gcd % i == 0:
            for idx, val in enumerate(isPrime):
                print(idx, val)
            print(i)
            return
    print("DNE")
    """

    comp = 1
    for i in range(2, int(math.sqrt(gcd))+1):
        if gcd % i == 0:
            while gcd % i == 0 and i < math.sqrt(gcd) + 1:
                gcd /= i
            comp = i
    
    gcd = max(comp, gcd)
    if gcd == 1:
        print("DNE")
    else:
        print(int(gcd))
main()