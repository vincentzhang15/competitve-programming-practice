def calc():
    n = int(input())
    data = [0]*101
    
    for j in range(n):
        value = int(input())
        data[value] += 1

    maxx = -1
    for j in data:
        if maxx < j:
            maxx = j

    if maxx > n//2:
        print("verified")
        return
        
    nMaxx = 0
    for j in data:
        if j == maxx:
            nMaxx += 1
            
    print("unverified") if nMaxx == 1 else print("unknown")
        
for i in range(5):
    calc()