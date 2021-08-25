import sys

def main():
    input = sys.stdin.readline
    maxVal = -1e6-1
    maxStr = "-1000001"
    for i in range(int(input())):
        s = input()
        a = float(s)
        if a > maxVal:
            maxStr = s
            maxVal = a
    sys.stdout.write(maxStr)
main()
