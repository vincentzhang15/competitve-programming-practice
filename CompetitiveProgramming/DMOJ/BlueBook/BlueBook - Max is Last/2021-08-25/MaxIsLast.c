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
@context Self-Learning C
*/

#include <stdio.h>

int n;
float max = -99999999;
float nums[103];

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    scanf("%d", &n);
    
    for(int i=0; i<n; i++)
    {
        scanf("%f", &nums[i]);
        if(nums[i] > max)
        {
            max = nums[i];
        }
    }

    for(int i=0; i<n; i++)
    {
        if(nums[i] != max)
        {
            printf("%.2f\n", nums[i]);
        }
    }
    printf("%.2f\n", max);

    return 0;
}