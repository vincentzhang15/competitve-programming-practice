/*
-----------------------------------------------------------------------------------------
---------------------------- CCC '17 J1 - Quadrant Selection ----------------------------
Determine the quadrant in which a pair of non-zero integral coordinates lie.

Sample Input 1
12
5

Sample Output 1
1

Sample Input 2
9
-13

Sample Output 2
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check half of coordinate plane, e.g., upper half, when y > 0: x > 0, x < 0.
Only 2 cases remain, both y < 0:
    Check x < 0
    Else

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to identify the quadrant of a pair of coordinates.
@author Vincent Zhang
@since 21 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    int x, y;
    scanf("%d %d", &x, &y);

    if(x > 0)
    {
        if(y < 0)
            printf("4");
        else
            printf("1");
    }
    else
    {
        if(y < 0)
            printf("3");
        else
            printf("2");
    }


    return 0;
}