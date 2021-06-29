for i in range(5):
    a = input()
    b = input()
    minn = min(len(a), len(b))
    
    total = 0
    for j in range(minn):
        if a[j] == b[j]:
            total += 1
        else:
            break
    print(total)