import sys

def main():
    input = sys.stdin.readline
    #month = [0,0,31,28,31,30,31,30,31,31,30,31,30,31]
    #for i in range(1, len(month)):
        #month[i] += month[i-1]
    month = [0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365]

    for _ in range(int(input())):
        y, m, d = map(int, input().split())
        if m>2 and (y%4==0 and y%100!=0 or y%400==0):
            print(1 + month[m] + d)
        else:
            print(month[m] + d)
main()