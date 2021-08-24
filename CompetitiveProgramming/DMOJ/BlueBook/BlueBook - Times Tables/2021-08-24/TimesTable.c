/*
---------------------------------------------------------------------------------
---------------------------- BlueBook - Times Tables ----------------------------
Create a times table for "n" from 1 to n.

Sample Input
5

Sample Output
5 X 1 = 5
5 X 2 = 10
5 X 3 = 15
5 X 4 = 20
5 X 5 = 25

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop from 1 to n and multiply.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Creates a column in a times table.
@author Vincent Zhang
@since 24 August 2021
@context Self-Learning C
*/

#include <stdio.h>

int n;

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    scanf("%d", &n);

    for(int i=1; i<=n; i++)
    {
        printf("%d X %d = %d\n", n, i, n*i);
    }

    return 0;
}