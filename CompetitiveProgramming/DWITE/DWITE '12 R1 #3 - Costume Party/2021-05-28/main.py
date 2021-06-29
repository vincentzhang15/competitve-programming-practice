for i in range(5):
    n = int(input())
    costumes = []
    output = ""
    for j in range(n):
        name, costume = input().split()
        if costume in costumes:
            output += name + " "
        else:
            costumes.append(costume)
    if len(output) == 0:
        print("SPOOKY")
    else:
        print(output[:len(output)-1])
