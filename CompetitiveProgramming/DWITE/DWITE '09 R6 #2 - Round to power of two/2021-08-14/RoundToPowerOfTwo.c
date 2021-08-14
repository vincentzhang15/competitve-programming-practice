/*
-------------------------------------------------------------------------------------------------
---------------------------- DWITE '09 R6 #2 - Round to power of two ----------------------------
Find the closest power of 2 for each of the 5 lines of input.
If a number is equally close to two powers of two, print the greater value.

Sample Input
0
1
2
3
5

Sample Output
1
1
2
4
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
2^x = y
x ln 2 = ln y
x = log_2(y)
lo = floor x
hi = lo + 1
Find closest.
Ensure to set log 0 to 0 as it is mathematically undefined.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the closest power of 2.
@author Vincent Zhang
@since 14 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <stdlib.h> // abs
#include <math.h> // log

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    for(int i=0; i<5; i++)
    {
        int x;
        scanf("%d", &x);

        int lo = x == 0 ? 0 : (int)(log(x)/log(2));
        int hi = lo + 1;

        double dLo = abs((int)round(pow(2, lo) - x));
        double dHi = abs((int)round(pow(2, hi) - x));

        if(dLo < dHi)
            printf("%d\n", (int)pow(2, lo));
        else
            printf("%d\n", (int)pow(2, hi));
    }

    return 0;
}