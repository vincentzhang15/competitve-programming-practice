# Dataset from: https://github.com/halimb/MNIST-txt

import sys, collections

def main():
    input = sys.stdin.readline

    data = collections.defaultdict(list)

    count = 0
    while 1:
        line = input().strip()
        if line == "":
            break
            
        split = list(map(lambda x: int(x)/255, line.split(",")))
        key = round(split[0]*255)
        data[key].append(split[1:])

        count += 1


    key = 0
    print(len(data[key]))
    for val in data[key]:
        idx = 1
        for i in range(len(val)):
            if idx == 28:
                print(val[i])
                idx = 0
            else:
                sys.stdout.write(str(val[i]) + " ")
            idx += 1


    #print(count)

    #for v in data:
        #print(v, len(data[v]))

main()