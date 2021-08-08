/*
------------------------------------------------------------------------------------
---------------------------- BlueBook - Digits and Sums ----------------------------
Output all three-digit numbers between "m" and "n" inclusive such that
the cube of the digits of the three digit-number is equal to the number itself.
Output on new lines.

100 <= m <= n <= 999, where m <= n.

Sample Input
100 200

Sample Input Explanation
m n

Sample Output
153

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Calculate each number individually.
Extract each digit and find their sum:
    ones digit = num % 10
    tens digit = num / 10 % 10
              OR num % 100 / 10
    hundreds digit = num / 100 % 10
                  OR num % 1000 / 100 (redundant version of the former)

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find all three digit numbers between a range whose sum of digits cubed is equal to itself.
@author Vincent Zhang
@since 08 August 2021
*/

#include <iostream>
#include <math.h>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and c++ standard streams, allowing c++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int m, n;
    std::cin >> m >> n;

    for(int i=m; i<=n; i++)
    {
        if(pow(i%10, 3) + pow(i/10%10, 3) + pow(i/100%10, 3) == i)
        {
            std::cout << i << '\n';
        }
    }

    return 0;
}