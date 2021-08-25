def main():
    while 1:
        s = input()
        if s == "0":
            break
        data = s.split()
        stack = []
        for d in reversed(data):
            if d == '+' or d == '-':
                result = stack.pop() + " " + stack.pop() + " " + d
                stack.append(result)
            else:
                stack.append(d)
        print(stack.pop())
main()