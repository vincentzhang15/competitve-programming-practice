/*
----------------------------------------------------------------------------
---------------------------- BlueBook - Payment ----------------------------
Find the occurance frequency of integers (0 <= n <= 1000000) in each of the following ranges.
<= 9999
> 9999 && d <= 19999
> 19999 && d <= 29999
> 29999 && d <= 39999
> 39999 && d <= 49999
> 49999 && d <= 1000000

Output frequency count in order of the 6 intervals.
Line will be terminated by -1.

Sample Input
1
9999
10001
1000000
29999
-1

Sample Output
2
1
1
0
0
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Filter with a series of conditions.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Counts occurance freqeuncy in 6 ranges.
@author Vincent Zhang
@since 24 August 2021
*/

#include <iostream>

int a, b, c, d, e, f, n;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing c++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    while(1)
    {
        std::cin >> n;

        if(n == -1) break;
        else if(n <= 9999) a++;
        else if(n <= 19999) b++;
        else if(n <= 29999) c++;
        else if(n <= 39999) d++;
        else if(n <= 49999) e++;
        else f++;
    }

    std::cout << a << '\n' << b << '\n' << c << '\n' << d << '\n' << e << '\n' << f << '\n';

    return 0;
}