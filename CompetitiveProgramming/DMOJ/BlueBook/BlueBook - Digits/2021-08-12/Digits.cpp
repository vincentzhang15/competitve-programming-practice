/*
---------------------------------------------------------------------------
---------------------------- BlueBook - Digits ----------------------------
Find number of digits of each number. Negative sign is not a digit.

Sample Input
4
123
1
-12
0

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: numbers.

Sample Output
3
1
2
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find absolute value of every number then its string length.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the number of digits in a list of numbers.
@author Vincent Zhang
@since 12 August 2021
*/

#include <iostream>
#include <string>

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

    int n;
    std::cin >> n;

    for(int i=0; i<n; i++)
    {
        int x;
        std::cin >> x;
        std::string s = std::to_string(abs(x));
        std::cout << s.length() << '\n';
    }

    return 0;
}