/*
-----------------------------------------------------------------------------------
---------------------------- CCC '13 J1 - Next in line ----------------------------
Three children's age form an arithemtic sequence.
Given the ages of the youngest and middle child, find the age of the oldest.

Sample Input
12
15

Sample Output
18

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Let "a", "b", "c" be ages of the youngest, middle, and oldest child respectively.
c - b = b - a
c = b - a + b

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the age of the oldest child given the ages of the youngest and middle child.
@author Vincent Zhang
@since 20 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termiantion
 */
int main(int argc, char **argv)
{
    int a, b;
    scanf("%d %d", &a, &b);

    printf("%d", 2*b-a);

    return 0;
}