n = int(input())

values = list(map(int, input().split()))

average = 0;
for value in values:
    average += value
average /= n

count = 0;
for value in values:
    if value > average:
        count+=1

print("Winnie should take the risk") if count/n > 0.5 else print("That's too risky")