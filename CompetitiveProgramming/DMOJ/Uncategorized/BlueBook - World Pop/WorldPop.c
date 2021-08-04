/*
------------------------------------------------------------------------------
---------------------------- BlueBook - World Pop ----------------------------
World population increases p% every year. Population was n in year y.
Estimate popluation in final year.

Sample Input
1.6
1987
5000000000
2087

Sample Input Explanation
Line 1: r, growth rate.
Line 2: y, start years.
Line 3: n, population at start year.
Line 4: e, end year.

Sample Output
24453487116

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find n * (r/100+1)^(e-y) rounded to nearest integer.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to estimate population.
@author Vincent Zhang
@since 04 August 2021
@context Self-Learning C
*/
#include <stdio.h>
#include <math.h>

/**
 * Solve the problem.
 * return 0 Successful program termination
 */
int main()
{
    double r; scanf("%lf", &r);
    double s; scanf("%lf", &s);
    double p; scanf("%lf", &p);
    double e; scanf("%lf", &e);

    double base = r/100.0+1;
    double power = e-s;
    double exp = pow(base, power);

    double estimate = p * exp;
    printf("%lu\n", (unsigned long)round(estimate));

    return 0;
}