/*
////////////////////////////////////////////////////////////////////////////////
//////////////////////////// Alex and Animal Rights ////////////////////////////
A map contains walls '#', monkeys 'M', and empty spaces '.'.
Find the number of cages that contain monkeys.
A cage is monkeys or empty space enclosed by walls in all cardinal directions.
The map will gaurenteed to be enclosed by walls along its borders.

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
Line 1: r c, number of rows and columns in the map. 3 <= r <= 35. 3 <= c <= 50.
Line 2 to r+1: map.

Sample Output
6

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
The following solution implements a uses depth-first serach with recursion to visit all cells in a cage that contains monkey(s).
First the monkey locations are found.
Then, every monkey's cage is fully visited, marking all other monkeys in the same cage as visited.
Thus, yielding the number of distinct cages with monkeys.

See AlexAndAnimalRightsDFS.py for DFS impementation with stack.
See AlexAndAnimalRightsBFS.java for BFS implementation.
*/

/**
 * Program to find the number of cages that contain monkeys.
 * @author Vincent Zhang
 * @since 22 July 2021
 */
#include <iostream>
#include <stack>
#include <utility> // pair.

// Global declarations.
char map[35][50];
bool visited[35][50] = {false};
int cages = 0;
int dir[] = {1, 0, -1, 0, 1}; // Cell movement directions.

/**
 * Depth-first search to visit all cells in the a cage that contains a monkey.
 * @param x1 X-coordinate of the monkey position
 * @param y2 Y-coordinate of the monkey position
 * @param first Whether dfs() was called from the while loop in main()
 * @return void
 */
void dfs(int x1, int y1, bool first)
{
    if(visited[x1][y1]) return;
    if(first) cages++;
    visited[x1][y1] = true;
    
    for(int i=0; i < 4; i++)
    {
        int x2 = x1 + dir[i];
        int y2 = y1 + dir[i+1];

        // No need to check if (x2, y2) is in map as a monkey position because the map is gaurenteed to be enclosed by walls along its edges.
        if(map[x2][y2] != '#')
            dfs(x2, y2, false);
    }
}

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Store map and find monkey locations.
    std::stack<std::pair<int, int>> monkeys;
    int r, c; std::cin >> r >> c; std::cin.ignore();
    for(int i=0; i<r; i++)
    {
        std::string s; std::getline(std::cin, s);
        for(int j=0; j<c; j++)
        {
            char c = s[j];
            map[i][j] = c;
            if(c == 'M')
                monkeys.push(std::pair<int, int>(i, j));
        }
    }

    // Visit every cell in every cage for every monkey.
    while(!monkeys.empty())
    {
        dfs(monkeys.top().first, monkeys.top().second, true);
        monkeys.pop();
    }
    std::cout << cages << '\n';

    return 0;
}