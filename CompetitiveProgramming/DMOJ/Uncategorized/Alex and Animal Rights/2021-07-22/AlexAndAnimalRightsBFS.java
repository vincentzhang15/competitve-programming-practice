/*
////////////////////////////////////////////////////////////////////////////////
//////////////////////////// Alex and Animal Rights ////////////////////////////
In a map there are three symbols:
    #: Wall.
    M: Monkey.
    .: Empty space.
Find the number of cages that contain monkeys.
A cage is enclosed by wall cells in the cardinal directions (non-ordinal directions).
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
Line 1: r c, number of rows and columns of the map.
Line 2 to r+1: the map.

Sample Output
6

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
The following solution performs a breadth-first search for all cells in a cage that contains monkeys, and marking the cells as visited.
During input-time, monkey locations are recorded.
Then, every monkey that has not been visited is processed by searching for all non wall cells in a cage.
When the search is complete all cells in a cage have been marked as visited.

Note: this problem can also be solved using DFS.
See AlexAndAnimalRightsDFS.py and AlexAndAnimalRightsDFS.cpp.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Program to count the number of cages that contain monkeys in a map using BFS.
 * @author Vincent Zhang
 * @since 22 July 2021
 */
public class AlexAndAnimalRightsBFS
{
    /**
     * Class to represent positions in the map.
     * @author Vincent Zhang
     * @since 22 July 2021
     */
    static class Coord
    {
        int r, c;
        /**
         * Initialize row and column coordinates upon instantiation.
         * @param r Row coordinate
         * @param c Column coordinate
         */
        public Coord(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }

    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException BufferedReader exception
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int r = Integer.parseInt(dimensions[0]);
        int c = Integer.parseInt(dimensions[1]);

        // Populate map. Store monkeys.
        char[][] map = new char[r][c];
        ArrayList<Coord> monkeys = new ArrayList<>();
        for(int i=0; i<r; i++)
        {
            String line = br.readLine();
            for(int j=0; j<c; j++)
            {
                char chr = line.charAt(j);
                map[i][j] = chr;
                if(chr == 'M')
                    monkeys.add(new Coord(i, j));
            }
        }

        // Count the number of cages that contain monkeys.
        int total = 0;
        boolean[][] visited = new boolean[r][c];
        for(Coord monkey : monkeys)
        {
            int i = monkey.r;
            int j = monkey.c;

            // If monkey has not been visited, it is in a new cage.
            if(!visited[i][j])
            {
                visited[i][j] = true;

                // Find monkey next positions.
                Queue<Coord> q = new LinkedList<>();
                q.add(new Coord(i, j));
                // After iterating, an empty queue indicates an entire cage with monkey(s) has been marked visited.
                while(!q.isEmpty())
                {
                    int x1 = q.peek().r;
                    int y1 = q.peek().c;
                    q.remove();

                    // Attempt to move in each cardinal direction.
                    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                    for(int a=0; a<d.length; a++)
                    {
                        // New position.
                        int x2 = x1 + d[a][0];
                        int y2 = y1 + d[a][1];

                        // If new position is in the board, not visited, and not a wall, place in queue.
                        if(x2 >= 0 && x2 < r && y2 >=0 && y2 < c && !visited[x2][y2] && map[x2][y2] != '#')
                        {
                            q.add(new Coord(x2, y2));
                            visited[x2][y2] = true;
                        }
                    }
                }
                total++;
            }
        }
        System.out.println(total);
    }
}