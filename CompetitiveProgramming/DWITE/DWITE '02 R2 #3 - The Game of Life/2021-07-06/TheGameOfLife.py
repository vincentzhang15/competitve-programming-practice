"""
KEY CONCEPTS SUMMARY
1. Summing a Nested List
    https://stackoverflow.com/questions/47927234/using-map-to-sum-the-elements-of-list

    {
        sum(map(sum, gameMap))
    }
    similar but NOT equivalent to:
    {
        x = []
        for i in gameMap:
            x.append(sum(i))
        sum(x)
    }
    "
    Sum needs a iterable to apply sum across.
    If you see the docs syntax goes this way sum(iterable[, start]).
    Since int is not an iterable you get that error.
    "

2. Python map()
    https://www.geeksforgeeks.org/python-map-function/
    "
    map() function returns a map object(which is an iterator)
    of the results after applying the given function to each item of a given
    iterable (list, tuple etc.)

    map(fun, iter)
    fun : It is a function to which map passes each element of given iterable.
    iter : It is a iterable which is to be mapped.

    NOTE : You can pass one or more iterable to the map() function.
    "

4. Clone a Nested List
    Use list slicing and list comprehension.
    updatedMap = [x[:] for x in gameMap]

5. Replace characters in a string.
    row = input().replace('.', '0').replace('X', '1')

6. Convert String to Integer List & Create Nested List
    gameMap = []
    gameMap.append(list(map(int, list(row))))
    {
        list(row): Convert string to character list.
        list(map(int, list(row))): Char list to Int list.
    }

7. Convert Integer List to String
    print(''.join(list(map(str, row))))
    {
        list(map(str, row)): convert integer list to string list.
        print(''.join(STR_LIST)): convert string list to string.
    }
"""

"""
DWITE '02 R2 #3 - The Game of Life

Simulate the game of life. A map contains live and dead cells. After each generation, cells may change states.
    - dead cell + 3          live neighbours --> live
    - live cell + 2 or 3 l   iive neighbours --> live
    - live cell + >=4 or <=1 live neighbours --> dead

Output number of live cells after 1st, 50th, 10th, 50th, 100th generation.

Sample Input:
10 10
..XX..XXXX
.X.XX.XX..
XX....X..X
X...XX..XX
X..X.X....
..........
.XXX.....X
.......XXX
......XX..
X.X.X.X...

Sample Input Explanation:
Line 1: r, c, rows and columns of the game map.
Line 2 to r+1: rows of the map. "X" is live cell. "." is dead cell.

Sample Output:
38
30
27
0
0

@author Vincent Zhang
@since 06 July 2021
@context Learning Python 3
"""

# Global variables
gameMap = [] # Stores the current state of the map
r = c = -1 # Rows and columns of the map
directions = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]] # Directions to check for neighbours

"""
Counts the number of live neighbours of a cell.
@param i Row    index of the cell to check
@param j Column index of the cell to check
@return Number of valid live neighbours
"""
def countNeighbours(i, j):
    neighbours = 0
    for direction in directions:
        # New row and column formed from moving in a direction.
        nr = i + direction[0]
        nc = j + direction[1]

        # Check if the new row and column is valid live neighbour, i.e., within the game board and live.
        if nr >= 0 and nr < r and nc >= 0 and nc < c and gameMap[nr][nc]:
            neighbours += 1
    return neighbours

"""
Finds and prints the number of live cells on the map by finding the sum of the nested list map.
@return void
"""
def printLiveCells():
    # Sum of a nested list. Sum each row of gameMap. Sum the sum of rows.
    print(sum(map(sum, gameMap)))

"""
Plays the game by cycling one generation.
@return void
"""
def cycleGame():
    global gameMap

    # Clone current state game map so data is not modifed before new map is completed.
    updatedMap = [x[:] for x in gameMap]

    # Follow game rules to update every cell.
    for i in range(r):
        for j in range(c):
            neighbours = countNeighbours(i, j)
            if not gameMap[i][j] and neighbours == 3:
                updatedMap[i][j] = 1
            elif gameMap[i][j] and (neighbours >= 4 or neighbours <= 1):
                updatedMap[i][j] = 0

    # Update the game map with the temporary map clone.
    gameMap = updatedMap

"""
Obtains input.
@return void
"""
def getData():
    global gameMap, r, c
    r, c = map(int, input().split())
    for i in range(r):
        # Use 0 and 1 to represent dead and live cells respectively so the map can be summed to obtain the number of live cells.
        row = input().replace('.', '0').replace('X', '1')
        # Create a nested list by adding lists to the game map list.
        gameMap.append(list(map(int, list(row))))

"""
Print the game map for a visual representation. (Not required by the question.)
@return void
"""
def printMap():
    print("=" * len(gameMap[0]), "MAP")
    for row in gameMap:
        # Convert integer list to string.
        print(''.join(list(map(str, row))))
    print()

"""
Control the flow of the program: input, process, output.
@return void
"""
def main():
    getData()
    #printMap()

    for i in range(1, 101):
        cycleGame()
        if i==1 or i==5 or i==10 or i==50 or i==100:
            #printMap()
            printLiveCells()

# Program can only be run from within this module.
if __name__ == "__main__": main()