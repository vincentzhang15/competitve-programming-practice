import sys

def main():
    input = sys.stdin.readline

    f, r = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(f)]

    for i in range(f):
        data[i] = [0] + data[i]
        for j in range(1, r+1):
            data[i][j] += data[i][j-1]
    
    q = int(input())
    for i in range(q):
        a, b, c = map(int, input().split())
        c -= 1
        print(data[c][b] - data[c][a-1])
main()