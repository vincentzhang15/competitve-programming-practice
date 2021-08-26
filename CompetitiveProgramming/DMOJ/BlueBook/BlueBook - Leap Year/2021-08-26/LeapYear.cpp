/*
------------------------------------------------------------------------------
---------------------------- BlueBook - Leap Year ----------------------------
Identify if a year is leap year. Year 0 is leap year.
A year is a leap year if the number of divisible by 4 and not 100 or 400.

Sample Input
4
0
4
100
400

Sample Output
1
1
0
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
return y % 4 == 0 and y % 100 != 0 or y % 400 == 0

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Identifies whether a year is a leap year.
@author Vincent Zhang
@since 26 August 2021
*/

#include <iostream>

int n, x;

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    while(n--)
    {
        std::cin >> x;
        std::cout << (x%4==0 && x%100!=0 || x%400==0) << '\n';
    }

    return 0;
}