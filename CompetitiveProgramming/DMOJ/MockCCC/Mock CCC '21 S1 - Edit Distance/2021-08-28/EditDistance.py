import sys

def main():
    input = sys.stdin.readline
    needle = input().strip()
    haystack = input().strip()

    ans = set()
    for i in range(len(haystack)):
        ans.add(haystack[:i] + haystack[i+1:])
        for j in needle:
            ans.add(haystack[:i] + j + haystack[i+1:])
    for i in range(len(haystack)+1):
        for j in needle:
            ans.add(haystack[:i] + j + haystack[i:])
    
    ans.remove(haystack)
    for v in sorted(ans):
        print(v)

main()