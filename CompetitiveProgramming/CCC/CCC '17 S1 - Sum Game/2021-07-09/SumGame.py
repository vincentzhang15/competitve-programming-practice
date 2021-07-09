"""
CCC '17 S1 - Sum Game

Given two integer lists both of length "n", find the largest number of items
(from the first item to "k")
such that the sum of the itmes from each list is equal.

Sample Input 1:
3
1 3 3
2 2 6

Sample Output 1:
2

Sample Output 1 Explanation:
The sum of the first 2 items from each list is the largest number of items such that the sum from each list is equal.

Sample Input 2:
3
1 2 3
4 5 6

Sample Output 2:
0

Sample Input 3:
4
1 2 3 4
1 3 2 4

Sample Output 3:
4

@author Vincent Zhang
@since 09 July 2021
@context Learning Python 3
"""

# Get input.
n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

# First find the sum of each list to easily obtain the max number of items in each list that produces the same sum.
sumA = sum(a)
sumB = sum(b)

# Loop through the lists and subtract item value from each sum until sums are equal.
for i in range(n-1, -2, -1):
    # If sum is equal, print and program ends. -2 ending point is the base case since sums at loop number (n+1)  will always be 0.
    if sumA == sumB:
        print(i+1)
        break

    # If sum is not equal, subtract from sum.
    sumA -= a[i]
    sumB -= b[i]