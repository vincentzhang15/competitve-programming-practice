"""
8 849
281
"""

def main():
    a, b = map(int, __import__("sys").stdin.readline().split())

    # "a" prime factors.
    pFactors = []
    freq = [0 for _ in range(a+1)]

    for i in range(2, int(a**0.5)+1):
        if a % i == 0:
            pFactors.append(i)
        while a % i == 0:
            a //= i
            freq[i] += 1    
    if a != 1:
        pFactors.append(a)
        freq[a] += 1


    # Find n
    n = 9999999999
    for pFact in pFactors:
        c = 0
        x = pFact
        while b // x != 0:
            c += b // x
            x *= pFact
        nn = c // freq[pFact]
        n = min(n, nn)
    print(n)

main()

