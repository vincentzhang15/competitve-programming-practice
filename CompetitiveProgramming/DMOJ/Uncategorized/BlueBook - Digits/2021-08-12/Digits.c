/*
---------------------------------------------------------------------------
---------------------------- BlueBook - Digits ----------------------------
Find number of digits of each number. Negative sign is not a digit.

Sample Input
4
123
1
-12
0

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: numbers.

Sample Output
3
1
2
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find absolute value of every number then its string length.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the number of digits in a list of numbers.
@author Vincent Zhang
@since 12 August 2021
@context Self-Learning Haskell
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Arugment vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    int n;
    scanf("%d", &n);

    for(int i=0; i<n; i++)
    {
        int x;
        scanf("%d", &x);
        x = abs(x);
        char s[1000001];
        sprintf(s, "%d", x);
        printf("%lu\n", strlen(s));
    }

    return 0;
}