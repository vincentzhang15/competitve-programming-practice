for i in range(10):
    # single test case
    wa, wb, wc, wd = map(int, input().split())
    n = int(input())
    
    nPass = 0
    for j in range(n):
        a, b, c, d = map(int, input().split())
        average = int(float(a*wa + b*wb + c*wc + d*wd)/100.0)
        if average >= 50:
            nPass += 1
    print(nPass)