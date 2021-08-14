/*
-------------------------------------------------------------------------------------------------
---------------------------- DWITE '09 R6 #2 - Round to power of two ----------------------------
Find the closest power of 2 for each of the 5 lines of input.
If a number is equally close to two powers of two, print the greater value.

Sample Input
0
1
2
3
5

Sample Output
1
1
2
4
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
2^x = y
x ln 2 = ln y
x = log_2(y)
lo = floor x
hi = lo + 1
Find closest.
Ensure to set log 0 to 0 as it is mathematically undefined.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the closest power of 2.
@author Vincent Zhang
@since 14 August 2021
*/

#include <iostream>
#include <math.h>

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

    for(int i=0; i<5; i++)
    {
        int x = 0;
        std::cin >> x;

        int lo = x == 0 ? 0 : (int)(log(x) / log(2));
        int hi = lo + 1;

        int dLo = (int)round(abs(pow(2, lo) - x));
        int dHi = (int)round(abs(pow(2, hi) - x));

        if(dLo < dHi)
            std::cout << (int)pow(2, lo) << '\n';
        else
            std::cout << (int)pow(2, hi) << '\n';
    }

    return 0;
}