/*
------------------------------------------------------------------------
---------------------------- BlueBook - Min ----------------------------
Find the min of a list of real numbers.
1 <= Size of list <= 10 000
-1000 < Size of numbers < 1000
Output answer to two decimal places.

Sample Input
2
10.1
12.3

Sample Output
10.10

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in min function or loop through list.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the min of a list of real numbers.
@author Vincent Zhang
@since 11 August 2021
*/

#include <iostream>
#include <iomanip>

/**
 * Solves the problem.
 * @return 0 Succesful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int n;
    std::cin >> n;

    float min = 100000;

    for(int i=0; i<n; i++)
    {
        float f;
        std::cin >> f;
        if(f < min)
            min = f;
    }
    std::cout << std::fixed << std::setprecision(2) << min << '\n';

    return 0;
}