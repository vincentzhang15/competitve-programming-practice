"""
CCC '18 J3 - Are we there yet?

Take inspiration from probability. P(X>=3)=1-P(P<3). Here, 3 represents index in prefix sum array and 1 represents value at last index of prefix sum array.
So distance from index 3 to end is simply value at end index - value at index 3.

@author Vincent Zhang
@since 24 June 2022
@context Programming practice
"""

import sys

def main():
    input = sys.stdin.readline
    output = sys.stdout.write

    data = list(map(int, input().split()))
    for i in range(1, len(data)):
        data[i] += data[i-1]
    data.insert(0, 0)

    for i in range(5):
        for j in range(5):
            print(abs(data[j]-data[i]), end=" ")
        print()

if __name__=="__main__":
    main()