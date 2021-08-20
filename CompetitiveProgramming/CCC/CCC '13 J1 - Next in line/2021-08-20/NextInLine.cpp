/*
-----------------------------------------------------------------------------------
---------------------------- CCC '13 J1 - Next in line ----------------------------
Three children's age form an arithemtic sequence.
Given the ages of the youngest and middle child, find the age of the oldest.

Sample Input
12
15

Sample Output
18

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Let "a", "b", "c" be ages of the youngest, middle, and oldest child respectively.
c - b = b - a
c = b - a + b

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the age of the oldest child given the ages of the youngest and middle child.
@author Vincent Zhang
@since 20 August 2021
*/

#include <iostream>

/**
 * Solves the problem.
 * @return Successful program termiantion
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int a, b;
    std::cin >> a >> b;
    std::cout << (b-a+b);

    return 0;
}