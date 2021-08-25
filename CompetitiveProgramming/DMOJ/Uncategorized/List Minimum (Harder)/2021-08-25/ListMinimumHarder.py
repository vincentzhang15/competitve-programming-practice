def convertToInt(data):
    for idx, d in enumerate(data):
        val = 0
        if d.isnumeric():
            val = int(d)
        else:
            for i in range(len(d)):
                val = val*10 + ord(d[i])-97+1
        data[idx] = val
    return data

def convertToChar(data):
    for idx, d in enumerate(data):
        val = ""
        for i in str(d):
            val += chr(int(i)+97-1)
        data[idx] = val
    return data


# https://stackoverflow.com/questions/1097908/how-do-i-sort-unicode-strings-alphabetically-in-python
# https://stackoverflow.com/questions/2531952/how-to-use-a-custom-comparison-function-in-python-3
import locale, functools
locale.setlocale(locale.LC_ALL, "")

n = int(input())

#data = [[ord(v) for v in input()] for _ in range(n)]
data = [input() for _ in range(n)]

#data = convertToInt(data)
data.sort(key=functools.cmp_to_key(locale.strcoll))
#data = convertToChar(data)

for d in data:
    for v in str(d):
        if ord(v) > 128:
            print(d)
            break
    #print(str(d))

"""
for row in data:
    s = ""
    for col in row:
        s += chr(col)
    print(s)
"""