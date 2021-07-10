/*
DMOPC '17 Contest 1 P1 - Fujō Neko

A grid contains objects, denoted by "X", that can see vertically and horizontally.
Check if a coordinate pair is under the sight-line of any object.

Sample Input:
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
Line 1: r c, number of rows and columns in the grid.
Line 2 to r+1: the grid.
Line r+2: q, number of coordinates to check.
Line r+3 to r+3+q: c r, column and row coordinates corresponding to a cell on the grid.

Sample Output:
N
Y
Y
Y

This solution will use the two string array approach. See FujoNeko.py for details.

@author Vincent Zhang
@since 10 July 2021
*/

#include <bits/stdc++.h>
using namespace std;

/**
 * Main method ot run the program.
 * @return void
 */
int main()
{
    // Sync input streams for fast input.
    cin.sync_with_stdio(0);
    cin.tie(0);

    // Inputs and initializations.
    int r, c; cin >> r >> c; cin.ignore();
    string rows[r], cols[c];
    for(int i=0; i<c; i++)
        cols[i] = "";

    // Get grid.
    for(int i=0; i<r; i++)
    {
        // Get row.
        string line;
        getline(cin, line);

        // Store rows.
        rows[i] = line;


        // Store columns.
        for(int j=0; j<c; j++)
            cols[j] += line[j];
    }

    // Process queries.
    int queries; cin >> queries;
    for(int i=0; i<queries; i++)
    {
        int col, row; cin >> col >> row;

        // If any of row or column contain "X" then that coordinate is visible.
        cout << ((rows[row-1].find("X") != string::npos || cols[col-1].find("X") != string::npos) ? "Y" : "N") << endl;
    }

    return 0;
}