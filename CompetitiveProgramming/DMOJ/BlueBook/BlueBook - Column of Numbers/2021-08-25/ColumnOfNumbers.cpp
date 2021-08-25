/*
--------------------------------------------------------------------------------------
---------------------------- BlueBook - Column of Numbers ----------------------------
Prints a string of digits in reverse order, column-wise.

Sample Input
3467

Sample Output
7
6
4
3

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Reverse print.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Reverses a list of digits.
@author Vincent Zhang
@since 25 August 2021
*/

#include <iostream>
#include <algorithm>

std::string line;

/**
 * Solves the problem.
 * @return 0
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> line;
    std::reverse(line.begin(), line.end());

    for(char c : line)
        std::cout << c << '\n';

    return 0;
}