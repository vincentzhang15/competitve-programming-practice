"""
https://www.geeksforgeeks.org/fast-doubling-method-to-find-the-nth-fibonacci-number/
https://stackoverflow.com/questions/9859115/how-to-find-binary-representation-for-nth-fibonacci-number
https://math.stackexchange.com/questions/297060/finding-the-binary-representation-of-the-nth-fibonacci-term
https://www.geeksforgeeks.org/matrix-exponentiation/
https://www.hackerearth.com/practice/notes/matrix-exponentiation-1/

F(2n) = F(n)[2F(n+1) – F(n)]
F(2n + 1) = F(n)  ^ ( 2 + F(n+1)2 )
"""

MAX = int(1e9+7)

n = bin(int(input()))[2:]

f0 = 0
f1 = 1

for nn in n:
    f00 = f0
    f11 = f1

    f0 = (f00 * (2 * f11 - f00)) % MAX
    f1 = (f00*f00 + f11*f11) % MAX

    if nn == '1':
        f00 = f0
        f11 = f1

        f0 = f11 % MAX
        f1 += f00 % MAX
print(f0)