"""
NOTES

5 5 + 6 * 8 -
52.0

((5 + 5) * 6) - 8

if operator
a = pop()
b = pop()
b operator a


* / + - % ^

"""

import sys

def main():
    input = sys.stdin.readline

    data = input().split()
    stack = []
    for d in data:
        if d.isnumeric():
            stack.append(int(d))
        else:
            b = stack.pop()
            a = stack.pop()
            if d == "*":
                stack.append(a*b)
            elif d == '/':
                stack.append(a/b)
            elif d == '+':
                stack.append(a+b)
            elif d == '-':
                stack.append(a-b)
            elif d == '%':
                stack.append(a%b)
            else:
                stack.append(a**b)
    print(stack[0])
main()