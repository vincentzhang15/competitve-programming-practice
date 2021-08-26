/*
-------------------------------------------------------------------------------
---------------------------- BlueBook - Power Base ----------------------------
Given x, p, find "x" raised to the power "p" rounded to 2 decimal places.

Sample Input
3
2.0 4
4.0 2
3.0 3

Sample Output
16.00
16.00
27.00

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop and find power.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Evaluates an exponentiation.
@author Vincent Zhang
@since 26 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <math.h>

int n;
float x, p;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    scanf("%d", &n);

    for(int i=0; i<n; i++)
    {
        scanf("%f %f", &x, &p);
        printf("%.2f\n", pow(x, p));
    }

    return 0;
}