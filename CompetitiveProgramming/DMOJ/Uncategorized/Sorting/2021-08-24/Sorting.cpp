/*
-----------------------------------------------------------------
---------------------------- Sorting ----------------------------
Sort a list <=100 of integers <= 32000 in ascending order.

Sample Input
4
4
3
2
1

Sample Output
1
2
3
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built in sorting method.
Or write own sorting method.
O(N^2) selection sort will work.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Sorts a list of integers.
@author Vincent Zhang
@since 24 August 2021
*/

#include <iostream>
#include <algorithm>

int n, data[103];

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    for(int i=0; i<n; i++)
    {
        std::cin >> data[i];
    }
    std::sort(data, data+n);

    for(int i=0; i<n; i++)
    {
        std::cout << data[i] << '\n';
    }

    return 0;
}