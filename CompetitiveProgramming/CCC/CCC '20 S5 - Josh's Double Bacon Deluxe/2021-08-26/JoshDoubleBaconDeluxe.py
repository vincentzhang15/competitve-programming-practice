import sys

def main():
    input = sys.stdin.readline

    MAX = 1000003

    n = int(input())
    #data = [int(input()) for _ in range(n)]
    data = list(map(int, input().split()))
    prev = [0]*MAX
    for i, v in enumerate(data):
        prev[v] = i
    prev[data[0]] = 0

    prob, temp = [0]*MAX, [0]*MAX
    if data[-1] == data[0]:
        temp[n-1], prob[n-1] = 1, 1
    
    for i in range(n-2, -1, -1):
        if prev[data[i]] == i:
            prob[i] = (temp[i+1]+1) / (n-i)
        else:
            prob[i] = prob[prev[data[i]]]
            if data[i] == data[0]:
                prob[i] = 1
        temp[i] = temp[i+1]+prob[i]
    print(prob[0])

main()