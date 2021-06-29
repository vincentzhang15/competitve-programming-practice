from fractions import Fraction

n = int(input())
data = list(map(int, input().split()))

a = data[0]
for i in range(1, len(data)):
    s = str(Fraction(a, data[i]))
    if s.find('/') == -1:
        s += "/1"
    print(s)