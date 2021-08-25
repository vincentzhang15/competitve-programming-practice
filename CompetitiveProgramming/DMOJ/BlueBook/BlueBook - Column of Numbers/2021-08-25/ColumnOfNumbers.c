/*
--------------------------------------------------------------------------------------
---------------------------- BlueBook - Column of Numbers ----------------------------
Prints a string of digits in reverse order, column-wise.

Sample Input
3467

Sample Output
7
6
4
3

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Reverse print.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Reverses a list of digits.
@author Vincent Zhang
@since 25 August 2021
@context Self-Learning C
*/

#include <stdio.h>

char num[1000000];
int n;

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    scanf("%s", num);
    for(; num[n] != '\0'; n++) {} // Find number of digits to reverse loop.
    for(int i = n-1; i>= 0; i--)
    {
        printf("%c\n", num[i]);
    }

    return 0;
}