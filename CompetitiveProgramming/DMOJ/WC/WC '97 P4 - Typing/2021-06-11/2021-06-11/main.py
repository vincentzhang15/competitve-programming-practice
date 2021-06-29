def calc():
    alpha = [False] * 26
    line = input()
    for c in line:
        c = c.lower();
        if not c.isalpha() or alpha[ord(c)-ord('a')]:
            return False
        alpha[ord(c)-ord('a')] = True
    
    for b in alpha:
        if not b:
            return False
    return True

n = int(input())

for i in range(n):
    print("OK.") if calc() else print("Nope.")
