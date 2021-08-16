/*
------------------------------------------------------------------------
---------------------------- BlueBook - Min ----------------------------
Find the min of a list of real numbers.
1 <= Size of list <= 10 000
-1000 < Size of numbers < 1000
Output answer to two decimal places.

Sample Input
2
10.1
12.3

Sample Output
10.10

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in min function or loop through list.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the min of a list of real numbers.
@author Vincent Zhang
@since 11 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    int n;
    scanf("%d", &n);

    float min = 10000;
    for(int i=0; i<n; i++)
    {
        float f;
        scanf("%f", &f);

        if(f < min)
        {
            min = f;
        }
    }
    printf("%.2f\n", min);

    return 0;
}