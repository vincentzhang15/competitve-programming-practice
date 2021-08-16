/*
------------------------------------------------------------------------------
---------------------------- BlueBook - Direction ----------------------------
Given a direction in integer degrees N. 0 ≤ N < 360.
Print the closest cardinal direction.
Ties are broken by smaller directions.
Direction in increasing size are N, E, S, W.
I.e., choose N over E when deg <= 45
             N over W when deg >= 315

Sample Input
2
45
180

Sample Input Explanation
Line 1: T, number of tasks.
Line 2 to T+1: degrees.

Sample Output
N
S

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process conditions.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to print the closest cardinal direction.
@author Vincent Zhang
@since 03 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    int n;
    scanf("%d", &n);

    for(int i=0; i<n; i++)
    {
        int d;
        scanf("%d", &d);

        if(d <= 45 || d >= 315)
            printf("N\n");
        else if(d <= 135)
            printf("E\n");
        else if(d <= 225)
            printf("S\n");
        else
            printf("W\n");
    }

    return 0;
}