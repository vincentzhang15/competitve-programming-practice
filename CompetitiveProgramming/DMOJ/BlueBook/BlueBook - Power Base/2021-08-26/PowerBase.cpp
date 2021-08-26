/*
-------------------------------------------------------------------------------
---------------------------- BlueBook - Power Base ----------------------------
Given x, p, find "x" raised to the power "p" rounded to 2 decimal places.

Sample Input
3
2.0 4
4.0 2
3.0 3

Sample Output
16.00
16.00
27.00

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop and find power.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Evaluates an exponentiation.
@author Vincent Zhang
@since 26 August 2021
*/

#include <iostream>
#include <iomanip>
#include <math.h>

int n;
float x, p;

/**
 * Solves the problem.
 * @param argc Arugment count, number of command-line arguments +1 for program name
 * @param argv Argument vector, program name nad command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    // Disable synchronization between C and c++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    while(n--)
    {
        std::cin >> x >> p;
        std::cout << std::fixed << std::setprecision(2) << std::pow(x, p) << '\n';
    }

    return 0;
}