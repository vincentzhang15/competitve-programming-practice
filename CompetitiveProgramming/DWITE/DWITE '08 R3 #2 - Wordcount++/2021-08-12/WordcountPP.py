import sys

def main():
    input = sys.stdin.readline
    for _ in range(5):
        s = input()
        w = 0
        c = 0
        for i in range(0, len(s)):
            if not s[i].isalpha():
                if c > 3:
                    w += 1
                c = 0
            else:
                c += 1
        print(w)
main()