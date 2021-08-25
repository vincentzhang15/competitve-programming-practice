"""

5 3

15

"""

a, b = map(int, __import__("sys").stdin.readline().split())
print(max(a+b, abs(a-b), a*b))