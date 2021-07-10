/*
DMOPC '17 Contest 1 P1 - Fujō Neko
A 2D grid contains objects denoted by "X" that see horizontally and vertically.
Given a list of coordinates, print "Y" if the coordinate is under the line of sight of at least one object, "N" otherwise.

Sample Input 1:
4 5
X....
....X
.....
..X..
4
2 3
4 4
1 1
5 4

Sample Input Explanation:
Line 1: r, c, number of rows and columns of the grid.
Line 2 to r+1: the map where "X" is an object and "." is an empty cell.
Line r+2: q, number of queries.
Line r+3 to r+3+q: col, row, coordinates to check if it is under the line of sight.

Sample Output
N
Y
Y
Y

See FujoNeko.py for more details.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Solves the problem of determining whether a cell in a grid is visible to the vertical and horizontal lines of sight of any static cell positions on the grid.
 * @author Vincent Zhang
 * @since 09 July 2021 
 */
public class FujoNeko
{
    /**
     * Main method to solve the problem.
     * @param args
     * @throws IOException
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);

        // Process map data by marking cell as true if the cell can be seen by someone.
        boolean[][] map = new boolean[r][c];
        for(int i=0; i<r; i++)
        {
            // Loop through every row.
            String row = br.readLine();
            for(int j=0; j<c; j++)
            {
                // Mark row and column as visible if the current character is "X".
                char chr = row.charAt(j);
                if(chr == 'X')
                {
                    // The redundancy of this method can be reduced by using two 1D arrays.
                    for(int a=0; a<r; a++) map[a][j] = true; // Entire    row can be visible.
                    for(int b=0; b<c; b++) map[i][b] = true; // Entire column can be visible.
                }
            }
        }

        /*
        // Print map for visualization.
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
                System.out.print(map[i][j]?"X":".");
            System.out.println();
        }
        */

        // Answer the questions about whether the person is in the line of sights.
        int queries = Integer.parseInt(br.readLine());
        for(int i=0; i<queries; i++)
        {
            line = br.readLine().split(" ");
            int col = Integer.parseInt(line[0]);
            int row = Integer.parseInt(line[1]);
            System.out.println(map[row-1][col-1] ? "Y" : "N");
        }
    }
}
