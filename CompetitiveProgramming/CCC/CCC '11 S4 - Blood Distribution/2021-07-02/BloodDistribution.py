"""
CCC '11 S4 - Blood Distribution
Program to determine the max number of bags of blood that can be distributed.

Blood requirements:
O   | O
A   | A, O
B   | B, O
AB  | A, B, O
Rh- | Rh-
Rh+ | Rh-, Rh+

Sample Input:
5 5 3 1 2 11 5 12
2 4 9 2 3 9 7 3

Sample Input Explanation:
Line 1: 8 integers representing available units of          blood of a certain type in order: O-, O+, A-, A+, B-, B+, AB-, AB+
Line 2: 8 integers representing number of patients who need blood of a certain type in order: O-, O+, A-, A+, B-, B+, AB-, AB+

Sample Output:
33

@author Vincent Zhang
@since 02 July 2021
@context Learning Python 3
"""

# Global variables declaration and initialization.
total = 0
supplies = []
demands = []

"""
Performs the distribution calculation based on the demand and supply of selected blood types.
@param idxD Stands for indexDemand: the index for the demanded blood bags in the list "demands"
@param idcS Stands for indicesSupply: the indices for the available supplied blood bags in the list "supplies"
@return void 
"""
def distribute(idxD, idcS):
    # Required to write to global variables.
    global total, supplies, demands

    # Attempt to fulfill all outstanding demands.
    while demands[idxD] > 0:
        # Loop through the avaiable supply indices.
        for idxS in idcS:
            # Total supply at current index.
            supply = supplies[idxS]
            # If demand > supply, give all supply. If supply < demand, fullfill all demand.
            give = min(supply, demands[idxD])

            # Update statistics.
            total += give
            supplies[idxS] -= give
            demands[idxD] -= give

            # No more blood bags left if the last supply set is distributed, i.e., all O- blood bags distributed.
            if idxS == idcS[-1]:
                break
        # If did not break continue. Continue at end of loop does not skip any calculation code.
        else:
            continue
        # If did break from inner loop, break outer loop.
        break

"""
Controls the flow of the program: input, process, output.
@return void
"""
def main():
    global supplies, demands
    # Input line of integers as a list.
    supplies = list(map(int, input().split()))
    demands = list(map(int, input().split()))

    # Process.
    # Parameter 1: demand index allows distribute() to find the current number of demands.
    # Parameter 2: non-commutative list of indices to locate which supply sets can be taken from for each demand.
    distribute(0, [0])
    distribute(1, [1, 0])
    distribute(2, [2, 0])
    distribute(3, [3, 2, 1, 0])
    distribute(4, [4, 0])
    distribute(5, [5, 4, 1, 0])
    distribute(6, [6, 4, 2, 0])
    distribute(7, [7, 6, 5, 4, 3, 2, 1, 0])

    print(total)

# Will always be true when the program is run from this module, i.e., not imported into another module.
if __name__ == "__main__": main()