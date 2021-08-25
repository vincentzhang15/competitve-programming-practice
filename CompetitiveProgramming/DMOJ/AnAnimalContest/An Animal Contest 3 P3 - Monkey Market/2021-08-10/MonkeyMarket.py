"""
3
4 2 2

"""

import sys, collections

def main():
    input = sys.stdin.readline
    n = int(input())
    q = collections.deque(sorted(list(map(int, input().split()))))
    data = []

    while q:
        data.append(q.popleft())
        if q:
            data.append(q.pop())
    
    print(*data, sep=" ")
    print("BS"*(n//2) + "E"*(n%2))
main()