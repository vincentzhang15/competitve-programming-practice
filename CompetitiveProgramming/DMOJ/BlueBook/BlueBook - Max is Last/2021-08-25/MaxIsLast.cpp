/*
--------------------------------------------------------------------------------
---------------------------- BlueBook - Max is Last ----------------------------
Given a list of numbers, print the max value last.

Sample Input
4
3
2.7
5.12
-0.63

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: list of numbers.

Sample Output
3.00
2.70
-0.63
5.12

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max, print the rest without max, print max.
E.g., by creating new list without max, iterating through list and not printing max.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Prints a list with the maxiumum value last.
@author Vincent Zhang
@since 25 August 2021
*/

#include <iostream>
#include <iomanip>

int n;
float max = -99999999, nums[103];

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
        std::cin >> nums[i];
        if(nums[i] > max)
        {
            max = nums[i];
        }
    }
    for(int i=0; i<n; i++)
    {
        if(nums[i] != max)
        {
            std::cout << std::fixed << std::setprecision(2) << nums[i] << '\n';
        }
    }
    std::cout << std::fixed << std::setprecision(2) << max << '\n';

    return 0;
}