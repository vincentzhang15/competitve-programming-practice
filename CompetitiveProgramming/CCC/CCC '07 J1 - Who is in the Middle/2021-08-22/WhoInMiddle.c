/*
--------------------------------------------------------------------------------------------
---------------------------- CCC '07 J1 - Who is in the Middle? ----------------------------
Find the middle number of three numbers.

Sample Input
10
5
8

Sample Output
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
One way is to sort the list and output list[1].
Another way is to subtract max and min from the trio sum.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the middle number in three numbers.
@author Vincent Zhang
@since 22 August 2021
@context Self-Learning C
*/

#include <stdio.h>

#define min(a,b) ({ __typeof__ (a) _a = (a); __typeof__ (b) _b = (b); _a < _b ? _a : _b; })
#define max(a,b) ({ __typeof__ (a) _a = (a); __typeof__ (b) _b = (b); _a > _b ? _a : _b; })

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    printf("%d\n", a+b+c-min(a,min(b,c))-max(a,(max(b,c))));

    return 0;
}