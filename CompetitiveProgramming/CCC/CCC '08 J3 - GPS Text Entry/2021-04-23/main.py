grid = [
['A', 'B', 'C', 'D', 'E', 'F'],
['G', 'H', 'I', 'J', 'K', 'L'],
['M', 'N', 'O', 'P', 'Q', 'R'],
['S', 'T', 'U', 'V', 'W', 'X'],
['Y', 'Z', ' ', '-', '.', '_']
]

s = input()
total = 0
x, y = 0, 0
for i in s: # i: char at index 0 to len(s)-1
    for j in range(5):
        if i in grid[j]:
            r = j
            c = grid[j].index(i)
            total += abs(r-x) + abs(c-y)
            x = r
            y = c
total += abs(4-x) + abs(5-y)

print(total)