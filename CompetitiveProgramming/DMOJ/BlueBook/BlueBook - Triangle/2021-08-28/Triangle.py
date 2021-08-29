import math

def main():
    for i in range(int(__import__("sys").stdin.readline())):
        for j in range(i+1):
            print(math.comb(i, j), end=" ")
        print()
main()