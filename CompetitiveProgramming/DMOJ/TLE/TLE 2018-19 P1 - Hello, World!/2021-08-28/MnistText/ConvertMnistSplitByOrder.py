# Dataset from: https://github.com/halimb/MNIST-txt

import sys, collections

def main():
    input = sys.stdin.readline

    data = collections.defaultdict(list)

    count = 0
    print(1000)
    for i in range(1000):
    #while 1:
        line = input().strip()
        if line == "":
            break
            
        split = list(map(lambda x: int(x)/255, line.split(",")))
        key = round(split[0]*255)
        data[key].extend(split[1:])
        #print(key)

        idx = 1
        for i in range(len(data[key])):
            if idx == 28:
                print(data[key][i])
                idx = 0
            else:
                sys.stdout.write(str(data[key][i]) + " ")
            idx += 1

        count += 1
    #print(count)

    #for v in data:
        #print(v, len(data[v]))

main()