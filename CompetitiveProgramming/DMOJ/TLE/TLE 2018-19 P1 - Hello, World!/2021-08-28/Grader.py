list1 = []
list2 = []
with open("out.txt", 'rb') as f:
   for line in f:
       list1.append(line.strip())
with open("set1.out", 'rb') as f:
   for line in f:
       list2.append(line.strip())

match = 0
for i in range(len(list1)):
    if list1[i] == list2[i]:
        match += 1
print(match)