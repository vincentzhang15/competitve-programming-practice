"""
A Plus B
Given a list of "a"'s and "b"'s, output the sum of each "a" "b" pair.

Sample Input:
2
1 1
-1 0

Sample Input Explanation:
Line 1: number of lines to follow.
Line 2 to n+1: "a" "b" pair to be summed.

Sample Output:
2
-1

@author Vincent Zhang
@since 03 July 2021
@context Learning Python 3 basic data structure syntax 
"""

# Define Pair class.
class Pair:
    # Equivalent to the constructor method in Java.
    def __init__(self, a, b):
        # "self" is customizable, i.e., "self" can be "abcd" instead. Corresponds to "this" in Java and C++.
        self.a = a
        self.b = b

n = int(input())
for i in range(n):
    # Integer.
    intA, intB = map(int, input().split())
    
    # String.
    string = str(intA) + ":" + str(intB)
    
    # Float
    floatA = float(string[:string.index(':')])
    floatB = float(string[string.index(':')+1:])

    # Dictionary
    dictionary = {}
    dictionary["1st"] = int(floatA)
    dictionary["2nd"] = int(floatB)

    # Set. Set does not allow dupplicates by definition.
    setA = set()
    setA.add(dictionary.get("1st"))
    setB = set()
    setB.add(dictionary.get("2nd"))

    # Pair class.
    dataPair = Pair(setA.pop(), setB.pop())

    # List.
    dataList = []
    dataList.append(dataPair.a)
    dataList.append(dataPair.b)

    # Tuples are immutable.
    dataTuple = (dataList[0], dataList[1])

    # Sum all elements in tuple.
    print(sum(dataTuple))