/*
-----------------------------------------------------------------------------------
---------------------------- BlueBook - Exact Divisors ----------------------------
Print all exact divisors of a number in any order. Includes 1 and N.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check every number from 1 to N. O(N) with loop.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find all exact divisors of a number.
@author Vincent Zhang
@since 17 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments
 * @return 0 Successful program termintaion
 */
int main(int argc, char *argv[])
{
    int n;
    scanf("%d", &n);

    for(int i=1; i<=n; i++)
    {
        if(n%i == 0)
            printf("%d\n", i);
    }

    return 0;
}