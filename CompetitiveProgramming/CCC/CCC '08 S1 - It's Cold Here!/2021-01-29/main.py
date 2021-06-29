lowestCity = "ERROR"
lowestTemp = 201

while 1:
    city, tempString = input().split(" ")
    tempInt = int(tempString)
    
    if lowestTemp > tempInt:
        lowestTemp = tempInt
        lowestCity = city

    if city == "Waterloo":
        print(lowestCity)
        break