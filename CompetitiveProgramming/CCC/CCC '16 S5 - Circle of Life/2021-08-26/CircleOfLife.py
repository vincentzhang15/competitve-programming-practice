import sys

def main():
    input = sys.stdin.readline

    n, t = map(int, input().split())
    a = list(map(int, list(input().rstrip())))
    b = a[:]

    for i in reversed(range(50)):
        if (t >> i) & 1:
            p1 = (1 << i) % n
            p2 = (n-p1) % n
            for j in range(n):
                b[j] = a[(j+p1)%n] ^ a[(j+p2)%n]
            a = b[:]
    
    for v in a:
        print(v, end="")
    print()

main()