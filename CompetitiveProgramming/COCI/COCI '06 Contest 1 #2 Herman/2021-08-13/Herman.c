/*
--------------------------------------------------------------------------------------
---------------------------- COCI '06 Contest 1 #2 Herman ----------------------------
In Taxicab Geometry, distance between two points is defined as:
    d = |x1-x2| + |y1-y2|

Find the area of a Taxicab circle given its radius.

Sample Input 1
1

Sample Output 1
3.141593
2.000000

Sample Output 1 Explanation
Line 1: area of Euclidean geometry circle.
Line 2: area of Taxicab geometry circle.

Sample Input 2
21

Sample Output
1385.442360
882.000000

Sample Input 3
42

Sample Output
5541.769441
3528.000000

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Euclidean Circle Area
A = PI*r^2
  = PI * r * r

Taxicab Circle Area
A = sqrt(r^2 + r^2)^2
  = 2*r^2
  = 2 * r * r

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the area of a circle in Euclidean and Taxicab geometry.
@author Vincent Zhang
@since 13 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    int r;
    scanf("%d", &r);

    const double PI = 3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798;
    printf("%f\n%f", PI*r*r, 2.0*r*r);

    return 0;
}