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
@context Self-Learning C
*/

#include <stdio.h>

int n;
int data[103];

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    scanf("%d", &n);
    for(int i=0; i<n; i++)
    {
        scanf("%d", &data[i]);
    }

    // Selection sort.
    for(int i=0; i<n; i++)
    {
        int min = 32003;
        int idx = -1;
        for(int j=0; j<n; j++)
        {
            if(data[j] < min)
            {
                min = data[j];
                idx = j;
            }
        }
        printf("%d\n", min);
        data[idx] = 32003;
    }

    return 0;
}