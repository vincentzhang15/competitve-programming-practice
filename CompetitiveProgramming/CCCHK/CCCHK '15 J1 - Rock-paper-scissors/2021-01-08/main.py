n = int(input())

a = list(input().split())
b = list(input().split())

sumA = 0;
sumB = 0;

for i in range(0, len(a)):
    if (a[i] == "rock" and b[i] == "scissors") or (a[i] == "scissors" and b[i] == "paper") or (a[i] == "paper" and b[i] == "rock"):
        sumA += 1
    elif (b[i] == "rock" and a[i] == "scissors") or (b[i] == "scissors" and a[i] == "paper") or (b[i] == "paper" and a[i] == "rock"):
        sumB += 1

print(sumA, sumB)