# Input --> split by " " --> list
data = list(input().split(" "))

# var = list[0] --> loop from list[1]
var = int(data[0])

i = 1
while 1:
    # if P or M calc accordingly
    if data[i] == "P":
        var += int(data[i+1])
    elif data[i] == "M":
        var -= int(data[i+1])
    else:
        # if list[i] = "=" break
        print(var)
        break
    i += 2
