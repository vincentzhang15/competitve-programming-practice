maxx = int(input())
start = int(input())
rate = int(input())

summ = 0
day = 0

while True:
    if summ > maxx:
        print(day-1)
        break
    
    newCases = pow(rate, day)*start
    summ += newCases
    day += 1