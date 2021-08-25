"""
# https://zaron3.medium.com/simple-formula-for-prime-numbers-fe72c268c81d

for i in range(0):
    c = i % 10
    if i == 0:
        print(3*i-1)
        print(3*i+1)
    elif i == 5:
        print(3*i-2)
        print(3*i+2)
    elif i == 2:
        print(3*i+1)
    elif i % 2 == 0:
        print(3*i-1)
    else:
        print(3*i-10)
"""

# PyPy 2: 97/100
print" ".join(`v`+'*'[[p.__setitem__(a,0)for a in p[v*v::v]]<0:p[v-2]|p[v+2]]for p in[range(input())]for v in p if v>1)

# PyPy 3: 86/100
# print(" ".join(str(v)+'*'[[p.__setitem__(a,0)for a in p[v*v::v]]==None:p[v-2]|p[v+2]]for p in[list(range(int(input())))]for v in p if v>1))
