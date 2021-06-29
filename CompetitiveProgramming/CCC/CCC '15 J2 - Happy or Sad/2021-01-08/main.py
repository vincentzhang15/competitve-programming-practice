s1 = input()
s2 = s1

h = 0;
s = 0;

while 1:
    i = s1.find(":-)")
    if i == -1:
        break
    
    h += 1
    s1 = s1[i+3:]

while 1:
    i = s2.find(":-(")
    if i == -1:
        break
    
    s += 1
    s2 = s2[i+3:]

if h > s:
    print("happy")
elif s > h:
    print("sad")
elif h == 0:
    print("none")
else:
    print("unsure")
