/*
-------------------------------------------------------------------------
---------------------------- BlueBook - Cost ----------------------------
Determine the cost to mail a letter based on weight.

"
 0 ≤ N ≤ 30 costs 38 cents
30 < N ≤ 50 costs 55 cents
50 < N ≤ 100 costs 73 cents
if N > 100 then the base cost is 73 cents, plus 24 cents for every additional 50 grams or part thereof.
"

Sample Input
2
5
101

Sample Input Explanation
Line 1: number of tasks.
Line 2 to n+1: tasks.

Sample Output
38
97

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process each condition.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find mailling cost.
@author Vincent Zhang
@since 02 August 2021
*/

#include <iostream>
#include <math.h>

/**
 * Main function to solve the problem.
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

    int n; std::cin >> n;
    for(int i=0; i<n; i++)
    {
        int c; std::cin >> c;
        if(c <= 30) std::cout << "38\n";
        else if(c <= 50) std::cout << "55\n";
        else if(c <= 100) std::cout << "73\n";
        else std::cout << 73 + 24 * std::ceil((c-100)/50.0) << "\n";
    }

    return 0;
}