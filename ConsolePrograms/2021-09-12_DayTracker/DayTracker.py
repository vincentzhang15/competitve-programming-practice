"""
Program to log daily activity to track how much time is spent on a task.

@author Vincent Zhang
@since 12 September 2021
"""

import datetime

def printResult(data):
    data.append((datetime.datetime.now().strftime("%H:%M"), ""))
    for i in range(len(data)-1):
        h1 = int(data[i][0].split(':')[0])
        m1 = int(data[i][0].split(':')[1])
        h2 = int(data[i+1][0].split(':')[0])
        m2 = int(data[i+1][0].split(':')[1])
        
        t1 = datetime.timedelta(hours=h1, minutes=m1)
        t2 = datetime.timedelta(hours=h2, minutes=m2)

        duration = str(t2-t1).split(":")
        print(f"{data[i][0]}    {duration[0]}H {duration[1]}    {data[i][1]}")


data = []
while 1:
    task = input("What are you doing rignt now? 'QUIT' to exit, 'TIME' to print: ")
    if task.upper() == 'QUIT':
        break
    elif task.upper() == 'TIME':
        printResult(data[:])
        continue

    # https://stackoverflow.com/questions/415511/how-to-get-the-current-time-in-python
    start = datetime.datetime.now().strftime("%H:%M")
    data.append((start, task))
print()
print("TASKS")
printResult(data)