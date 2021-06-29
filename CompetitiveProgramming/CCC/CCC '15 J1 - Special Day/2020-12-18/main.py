def doQuestion(month, day):
    if month < 2:
        print("Before")
        return
    elif month == 2:
        if day < 18:
            print("Before")
            return
        elif day == 18:
            print("Special")
            return
    print("After")
    return

month = int(input())
day = int(input())

doQuestion(month, day)