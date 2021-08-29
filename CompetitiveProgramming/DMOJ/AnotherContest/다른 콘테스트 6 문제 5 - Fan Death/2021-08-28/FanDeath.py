# https://www.acmicpc.net/problem/15633

def main():
    n = int(__import__("sys").stdin.readline())
    s = 0
    for i in range(1, int(n**0.5)+1):
        if n % i == 0:
            s += i
            if i*i != n:
                s += n//i
    print(s * 5 - 24)
main()