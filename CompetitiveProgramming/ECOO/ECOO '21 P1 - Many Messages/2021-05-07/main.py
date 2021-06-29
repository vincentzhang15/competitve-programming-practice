def calc(check, a, n, t):
    for i in range(3):
        if t <= check:
            print(check)
            return
        check += n
    print("Who knows...")
    return
    
a = int(input())
n = int(input())
t = int(input())

check = a + n
calc(check, a, n, t)
