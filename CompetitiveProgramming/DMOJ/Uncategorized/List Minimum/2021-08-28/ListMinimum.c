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
@context Self-Learning C
*/

#include <stdio.h>

int n, data[53];

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    scanf("%d", &n);
    for(int i=0; i<n;i++)
        scanf("%d", &data[i]);
    
    // "n" number of numbers need to be outputted.
    for(int i=0; i<n; i++)
    {
        int min = 1001;
        int idx = -1;
        // Find the minimum.
        for(int j=0; j<n; j++)
        {
            if(data[j] < min)
            {
                min = data[j];
                idx = j;
            }
        }

        data[idx] = 1001;
        printf("%d\n", min);
    }

    return 0;
}