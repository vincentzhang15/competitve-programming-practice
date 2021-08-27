/*
-------------------------------------------------------------------------
---------------------------- BlueBook - Mode ----------------------------
Find mode of a set of positive non-zero integers <= 100.

Sample Input
2
3
4
4
-1

Sample Output
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max frequency, then sort all modes with the frequency.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the mode of a dataset.
@author Vincent Zhang
@since 27 August 2021
@context Self-Learning C
*/

#include <stdio.h>

int freq[103];
int final[103];
int x, max;

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    for(int i=0;; i++)
    {
        scanf("%d", &x);
        if(x == -1)
            break;
        freq[x]++;
    }

    // Find max frequency.
    for(int i=1; i<=100; i++)
        if(freq[i] > max)
            max = freq[i];
    // Store all max frequencies.
    for(int i=1; i<=100; i++)
        if(freq[i] == max)
            final[i] = i;
    // Print mode in ascending order.
    for(int i=1; i<=100; i++)
    {
        for(int j=0; j<103; j++)
        {
            if(final[j] == i)
            {
                printf("%d\n", i);
                break;
            }
        }
    }

    return 0;
}