import sys

def main():
    input = sys.stdin.readline
    input()
    x, y = map(int, input().rstrip().split())

    s = 0
    for _ in range(int(input().rstrip())):
        a, b = map(int, input().rstrip().split())
        v = min(y, b) - max(x, a) + 1
        s += v * (not((v>>31) & 0x1))
        # If v > 0, not 0 = 1
        # If v = 0, 0 * 1 = 0
        # If v < 0, not 1 = 0
        # Right shift 31, 32 bit int MSB to LSB pos, & 0x1
    print(s)
main()