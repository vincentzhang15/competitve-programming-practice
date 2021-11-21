s = input()

for i in range(97, 97+6):
    if chr(i) not in s:
        print(chr(i))
        break
