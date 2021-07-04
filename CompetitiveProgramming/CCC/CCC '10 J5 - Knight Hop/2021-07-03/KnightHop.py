"""
KEY CONCEPTS SUMMARY
1. Nested List: Use List Comprehension
CORRECT: dist = [[MAX_INT]*8 for _ in range(8)]
INCORRECT: dist = [[MAX_INT]*8]*8

2. List pop()
queue = []
queue.pop(0) <-- pop top, i.e., at index 0
queue.pop() <-- pop bottom
queue.append() <-- push bottom

3. Breadth-First Search (BFS)
Add start position to queue. Set distance of starting position to 0.
While queue not empty.
    Get next positions by adding to current position coordinates.
    If have not visited position.
        Add position to queue.
        Update steps took to reach position in grid.
        If destination has been visited, output steps taken.
"""

"""
CCC '10 J5 - Knight Hop
Find the minimum number of moves for a chess knight to move from one square to another.

Sample Input 1:
2 1
3 3

Sample Input 1 Explanation:
Line 1: "x" and "y" coordinates of the starting position of the knight
Line 2: "x" and "y" coordinates of the ending   position of the knight

Sample Output 1:
1

Sample Input 2:
4 2
7 5

Sample Output 2:
2

@author Vincent Zhang
@since 04 July 2021
@context Learning Python 3
"""

"""
Coord class to store the coordinate pair.
@author Vincent Zhang
@since 04 July 2021
"""
class Coord:
    """
    Java equivalent constructor method to set up variable values when an instance of Coord is created.
    @param self Define the name that should refer to contents of the class
    @param x The x-coordinate
    @param y The y-coordinate
    @return void
    """
    def __init__(self, x, y):
        self.x = x
        self.y = y

# Global variables
MAX_INT = 2**31-1
start = Coord(-1, -1)
end = Coord(-1, -1)
dist = [[MAX_INT]*8 for _ in range(8)] # [[MAX_INT]*8]*8 does not work.

"""
Performs the BFS algorithm to search for the minimum number of steps to move the knight from start to end.
@return void
"""
def bfs():
    # Declare and initialize a queue as a List with "start" as the starting coordinate.
    queue = [start]
    # Set the number of steps it takes to reach the starting position from the starting position to 0.
    dist[start.x][start.y] = 0

    # while queue is not empty.
    while len(queue) != 0:
        current = queue.pop(0) # Pop at front of queue. pop() pops at the back. Should really use "dequeue()" in the context of queues as "push" "pop" is stack notation.
        x = current.x
        y = current.y

        # Knights have 8 possible directions to move in.
        dir = [[-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2], [-1, -2], [-2, -1]]

        # Try to move in every possible direction.
        for d in dir:
            # Coordinates for the next potential move.
            r = x + d[0]
            c = y + d[1]

            # If coordinates are valid and have not been visited and visiting the square will take less moves than it's current number of moves.
            if r >= 0 and r < 8 and c >= 0 and c < 8 and dist[x][y]+1 < dist[r][c]:
                # Moves it takes to move to current position from last position is last position + 1.
                dist[r][c] = dist[x][y]+1

                # Add current position to queue.
                queue.append(Coord(r, c))
                
                # Search complete once the ending position has been visited.
                if dist[end.x][end.y] != MAX_INT:
                    print(dist[end.x][end.y])
                    return

"""
Main method to control flow: input, and process and output.
@return void
"""
def main():
    global start, end
    y1, x1 = map(int, input().split())
    y2, x2 = map(int, input().split())
    start = Coord(x1-1, y1-1)
    end = Coord(x2-1, y2-1)
    bfs()

# Will always be true when program is run from within this module.
if __name__ == "__main__": main()