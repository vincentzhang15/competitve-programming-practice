def works(s):
    stack = []
    for c in s:
        if c=='(':
            stack.append("(")
        if c==')':
            if len(stack) == 0:
                return False
            stack.pop()
    
    return len(stack) == 0

    
n = int(input())
for i in range(n):
    print("YES") if works(input()) else print("NO")
