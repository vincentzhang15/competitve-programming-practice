/*
------------------------------------------------------------------------------------------
-------------------------------- BlueBook - Pop Explosion --------------------------------
Population increases rate "r" percent each year.
Population in starting year "s" is "A".
Find year "e" in which population reaches "e".

Sample Input
5.5 24000000 1980 100000000

Sample Input Explanation
r A s B

Sample Output
2007

--------------------------------------------------------------------------------
-------------------------------- SOLUTION LOGIC --------------------------------
Rearrage population projection for ending year.
B = A * (r/100+1) ^ (e-s)
ln(B/A) = (e-s) ln(r/100+1)
e = ln(B/A)/ln(r/100+1) + s
e = log_(r/100+1)(B/A) + s (if language supports log base)

----------------------------------------------------------------------------------
-------------------------------- PROGRAM COMMENTS --------------------------------
Program to find the year of a population projection.
@author Vincent Zhang
@since 07 August 2021
*/

#include <iostream>
#include <math.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    double r, a, s, b;
    std::cin >> r >> a >> s >> b;
    double e = log(b/a)/log(r/100+1) + s;
    std::cout << round(e) << '\n';

    return 0;
}