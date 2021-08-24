/*
---------------------------------------------------------------------------------
---------------------------- BlueBook - Times Tables ----------------------------
Create a times table for "n" from 1 to n.

Sample Input
5

Sample Output
5 X 1 = 5
5 X 2 = 10
5 X 3 = 15
5 X 4 = 20
5 X 5 = 25

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop from 1 to n and multiply.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Creates a column in a times table.
@author Vincent Zhang
@since 24 August 2021
*/

#include <iostream>

int n;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    for(int i=1; i<=n; i++)
    {
        std::cout << n << " X " << i << " = " << n*i << '\n';
    }

    return 0;
}