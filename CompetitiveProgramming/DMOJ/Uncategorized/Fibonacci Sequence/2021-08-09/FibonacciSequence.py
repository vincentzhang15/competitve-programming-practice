"""
https://math.stackexchange.com/questions/297060/finding-the-binary-representation-of-the-nth-fibonacci-term
"""

n = bin(int(input()))[2:]
MAX = int(1e9+7)

f0 = 0
f1 = 1

for k in range(len(n)-1):
    f0 *= f0 % MAX
    f1 *= f1 % MAX

    cur = n[k]
    nxt = n[k+1]

    f3 = (4*f1 - f0) % MAX
    if cur == '0':
        f3 += 2
    else:
        f3 -= 2
    
    f1 = (f1 + f0) % MAX
    f2 = (f3 - f1) % MAX

    if nxt == '0':
        f0 = f1 % MAX
        f1 = f2 % MAX
    else:
        f0 = f2 % MAX
        f1 = f3 % MAX

print(f1 % MAX)
