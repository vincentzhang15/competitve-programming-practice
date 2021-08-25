def gcdEuclidean(a, b):
    if a == 0:
        return b
    return gcdEuclidean(b%a, a)

def main():
    for _ in range(int(input())):
        n, d = map(int, input().split())
        g = gcdEuclidean(n, d)
        n /= g
        d /= g

        reduced = d
        while reduced % 2 == 0: reduced/=2
        while reduced % 5 == 0: reduced/=5

        if reduced == 1:
            count = 0
            while n % d:
                n = n * 10 % d
                count += 1
            print(count)
        else:
            print(-1)
main()