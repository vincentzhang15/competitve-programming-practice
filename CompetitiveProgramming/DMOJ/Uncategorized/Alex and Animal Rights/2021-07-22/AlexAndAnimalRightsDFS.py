"""
################################################################################
############################ Alex and Animal Rights ############################
Find the number of cages that contain monkeys in a map.
    '#' denotes a wall.
    '.' denotes an empty cell.
    'M' denotes a monkey.
A cage is any emtpy cell or monkey enclosed by walls in all cardinal directions.
Map will always be enclosed by walls.

Sample Input
9 10
##########
##M#.M.#.#
#MM####..#
#M#.#.#..#
##..#.#.M#
#..##..#M#
##M#######
#.#MM#.M.#
##########

Sample Input Explanation
Line 1: r c, number of rows and columns in the map.
Line 2 to r+1, map.

Sample Output
6

########################################################################
############################ SOLUTION LOGIC ############################
Mark all cages with monkeys as visited using DFS.
Keep count of cages.
The following depth-first search implementation uses a stack to visit all cells in a cage.

See AlexAndAnimalRightsDFS.cpp for DFS implementation with recursion.
See AlexAndAnimalRightsBFS.java for BFS implementation.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 22 July 2021
@context Self-Learning Python 3
"""

r, c = map(int, input().split()) # Dimensions
map = [list(input()) for _ in range(r)]
visited = [[False for j in range(c)] for i in range(r)]
dir = [1, 0, -1, 0, 1] # Directions
cages = 0

for i in range(r):
    for j in range(c):
        # Every non visited monkey is in a distinct cage.
        if not visited[i][j] and map[i][j] == 'M':
            stack = [(i, j)]
            while stack:
                x1, y1 = stack.pop()
                for d in range(4):
                    x2 = x1 + dir[d]
                    y2 = y1 + dir[d+1]
                    if x2>=0 and y2>=0 and x2<r and y2<c and not visited[x2][y2] and map[x2][y2] != '#':
                        visited[x2][y2] = True
                        stack.append((x2, y2))
            cages += 1
print(cages)