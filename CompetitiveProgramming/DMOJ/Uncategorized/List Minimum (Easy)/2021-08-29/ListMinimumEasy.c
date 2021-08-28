/*
-----------------------------------------------------------------------------
---------------------------- List Minimum (Easy) ----------------------------
"Given a permutation of the integers 1 , 2 , … , N, output the permutation after it has been sorted."
Output "The sorted permutation on a single line."

Sample Input
3
2 1 3

Sample Output
1 2 3

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Notice the permutation of integers forms an arithmetic sequence with a common difference of 1.
Thus, output 1, 2...N.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Prints the sorted permutation of a list of integers.
@author Vincent Zhang
@since 28 August 2021
@context Self-Learning C
*/

#include <stdio.h>

int n;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    scanf("%d", &n);
    for(int i=1; i<=n; i++)
    {
        printf("%d ", i);
    }
    
    return 0;
}