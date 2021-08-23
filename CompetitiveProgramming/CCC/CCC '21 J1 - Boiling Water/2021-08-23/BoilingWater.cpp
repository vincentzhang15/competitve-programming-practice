/*
------------------------------------------------------------------------------------
---------------------------- CCC '21 J1 - Boiling Water ----------------------------
Find the atmospheric temperature of boiling water at different altitudes given by the temperature of boiling water.

P = 5 * B - 400

Sample Input 1:
99

Sample Input 1 Explanation:
B

Sample Output 1:
95
1

Sample Output 1 Explanation:
Line 1: P
Line 2: 1 when p < 100, 0 when p == 100, -1 when p > 100

Sample Input 2
102

Sample Output 2
110
-1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Substitute in equation. If statements.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the atmospheric pressure given temperature of boiling water.
@author Vincent Zhang
@since 23 August 2021
*/

#include <iostream>

int b, p;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and c++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> b;
    p = b * 5 - 400;

    std::cout << p << '\n';
    std::cout << (p>100?-1:(p==100?0:1)) << '\n';

    return 0;
}