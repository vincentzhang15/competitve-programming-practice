/*
------------------------------------------------------------------------------
---------------------------- BlueBook - Leap Year ----------------------------
Identify if a year is leap year. Year 0 is leap year.
A year is a leap year if the number of divisible by 4 and not 100 or 400.

Sample Input
4
0
4
100
400

Sample Output
1
1
0
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
return y % 4 == 0 and y % 100 != 0 or y % 400 == 0

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Identifies whether a year is a leap year.
@author Vincent Zhang
@since 26 August 2021
@context Self-Learning C
*/

#include <stdio.h>

int n, x;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    scanf("%d", &n);

    while(n--)
    {
        scanf("%d", &x);
        printf("%d\n", x%4==0 && x%100!=0 || x%400==0);
    }

    return 0;
}