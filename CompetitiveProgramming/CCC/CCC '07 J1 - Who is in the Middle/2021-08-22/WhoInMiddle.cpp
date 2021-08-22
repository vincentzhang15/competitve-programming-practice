/*
--------------------------------------------------------------------------------------------
---------------------------- CCC '07 J1 - Who is in the Middle? ----------------------------
Find the middle number of three numbers.

Sample Input
10
5
8

Sample Output
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
One way is to sort the list and output list[1].
Another way is to subtract max and min from the trio sum.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the middle number in three numbers.
@author Vincent Zhang
@since 22 August 2021
*/

#include <iostream>
#include <math.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments +1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and c++ standard streams allowing c++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int a, b, c;
    std::cin >> a >>b >> c;

    std::cout << (a+b+c - std::min(a,std::min(b, c)) - std::max(a, std::max(b, c))) << '\n';

    return 0;
}