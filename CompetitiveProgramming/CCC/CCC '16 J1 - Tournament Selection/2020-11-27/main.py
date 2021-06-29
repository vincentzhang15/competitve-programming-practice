def WLToInt(s):
    if s == "W":
        return 1
    return 0

a = input()
b = input()
c = input()
d = input()
e = input()
f = input()

summation = WLToInt(a) + WLToInt(b) + WLToInt(c) + WLToInt(d) + WLToInt(e) + WLToInt(f)


if summation == 1 or summation == 2:
    print("3")
elif summation == 3 or summation == 4:
    print("2")
elif summation == 5 or summation == 6:
    print("1")
else:
    print("-1")