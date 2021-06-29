t1 = int(input())
t2 = int(input())

if t1 - t2 > t2: # output is 3
    print(3)
else: # output is > 3
    count = 4
    while 1:
        t3 = t1 - t2
        t4 = t2 - t3
        if t3 < t4:
            print(count)
            break
        count += 1
        t1 = t2
        t2 = t3