/*
-----------------------------------------------------------------------------
---------------------------- BlueBook - Multiple ----------------------------
Given two positive integers, "a", "b", determine if "a" is a mulitple of "b".
Output "yes" or "no".

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
if a % b == 0
    "yes"
else
    "no"

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to check if "a" is a mulitple of "b".
@author Vincent Zhang
@since 18 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguemnts
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    int a, b;
    scanf("%d %d", &a, &b);
    if(a % b == 0)
        printf("yes");
    else
        printf("no");

    return 0;
}