/*
-----------------------------------------------------------------------------------
---------------------------- BlueBook - Exact Divisors ----------------------------
Print all exact divisors of a number in any order. Includes 1 and N.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check every number from 1 to N. O(N) with loop.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find all exact divisors of a number.
@author Vincent Zhang
@since 17 August 2021
*/

#include <iostream>

/**
 * Solves the problem.
 * @return 0
 */
int main()
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int n;
    std::cin >> n;

    for(int i=1; i<=n; i++)
    {
        if(n%i == 0)
            std::cout << i << '\n';
    }
    
    return 0;
}