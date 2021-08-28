/*
----------------------------------------------------------------------
---------------------------- List Minimum ----------------------------
Given a list of numbers, remove the minimum from the list until the list is empty.

Sample Input
3
5
8
2

Sample Output
2
5
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Problem description is the definition of selection sort in ascending order.
Therefore, it sufices to sort with built-in function if avaiable.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Outputs a list of numbers in ascending order.
@author Vincent Zhang
@since 28 August 2021
*/

#include <iostream>

int n, data[53];

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

    std::cin >> n;
    for(int i=0; i<n;i++)
        std::cin >> data[i];
    
    for(int i=0; i<n; i++)
    {
        int min = 1001;
        int idx = -1;

        for(int j=0; j<n; j++)
        {
            if(data[j] < min)
            {
                min = data[j];
                idx = j;
            }
        }

        data[idx] = 1001;
        std::cout << min << '\n';
    }

    return 0;
}