# Fastest Python 3 Submission.

import sys

def main():
    input = sys.stdin.readline

    isPrime = [1] * 65536
    isPrime[1] = 0
    for i in range(2, 65536//2):
        if isPrime[i]:
            for j in range(i*2, 65536, i):
                isPrime[j] = 0

    for v in [int(input()) for _ in range(int(input()))]: print(isPrime[v])
main()