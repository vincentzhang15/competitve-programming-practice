def calc():
    if(data[0] > weight):
        return 0
    if(data[1]+data[0] > weight):
        return 1
    if(data[0] +  data[1] + data[2] > weight):
        return 2
        
    for i in range(0, cars-3):
        summ = data[i] + data[i+1] + data[i+2] + data[i+3]
        if summ > weight:
            return (i + 3)
    return (cars)
    
weight = int(input())
cars = int(input())

data = []
for i in range(cars):
    data.append(int(input()))
    

print(calc())