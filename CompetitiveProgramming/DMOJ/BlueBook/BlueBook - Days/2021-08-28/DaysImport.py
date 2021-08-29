import sys, datetime

def main():
    input = sys.stdin.readline
    day = datetime.date
    for _ in range(int(input())):
        y, m, d = map(int, input().split())
        if y == 0:
            y = 4
        print( (day(y, m, d) - day(y, 1, 1)).days+1 )
main()