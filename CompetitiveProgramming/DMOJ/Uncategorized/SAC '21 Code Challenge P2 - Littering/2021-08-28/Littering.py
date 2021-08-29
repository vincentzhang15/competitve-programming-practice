# Fastest Python 3 Submission

import sys

def main():
    input = sys.stdin.readline
    a, b = map(int, input().split())
    data = [*map(int, input().split())]
    data.sort()
    print(sum(data[-b:]))
main()