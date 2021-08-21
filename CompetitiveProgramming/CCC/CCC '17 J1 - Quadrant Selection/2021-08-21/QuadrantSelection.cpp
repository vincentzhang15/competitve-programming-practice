/*
-----------------------------------------------------------------------------------------
---------------------------- CCC '17 J1 - Quadrant Selection ----------------------------
Determine the quadrant in which a pair of non-zero integral coordinates lie.

Sample Input 1
12
5

Sample Output 1
1

Sample Input 2
9
-13

Sample Output 2
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check half of coordinate plane, e.g., upper half, when y > 0: x > 0, x < 0.
Only 2 cases remain, both y < 0:
    Check x < 0
    Else

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to identify the quadrant of a pair of coordinates.
@author Vincent Zhang
@since 21 August 2021
*/

#include <iostream>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int x, y;
    std::cin >> x >> y;

    if(y > 0)
    {
        if(x > 0)
            std::cout << 1;
        else
            std::cout << 2;
    }
    else
    {
        if(x < 0)
            std::cout << 3;
        else
            std::cout << 4;
    }

    return 0;
}