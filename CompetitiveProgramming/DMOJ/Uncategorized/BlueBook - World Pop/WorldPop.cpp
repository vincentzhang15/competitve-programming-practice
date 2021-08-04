/*
------------------------------------------------------------------------------
---------------------------- BlueBook - World Pop ----------------------------
World population increases p% every year. Population was n in year y.
Estimate popluation in final year.

Sample Input
1.6
1987
5000000000
2087

Sample Input Explanation
Line 1: r, growth rate.
Line 2: y, start years.
Line 3: n, population at start year.
Line 4: e, end year.

Sample Output
24453487116

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find n * (r/100+1)^(e-y) rounded to nearest integer.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to estimate population.
@author Vincent Zhang
@since 04 August 2021
*/

#include <iostream>
#include <math.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    double r; std::cin >> r;
    int s; std::cin >> s;
    long long p; std::cin >> p;
    int e; std::cin >> e;

    double v = p * std::pow(r/100+1, e-s);
    std::cout << std::fixed << (long long)std::round(v) << '\n';

    return 0;
}