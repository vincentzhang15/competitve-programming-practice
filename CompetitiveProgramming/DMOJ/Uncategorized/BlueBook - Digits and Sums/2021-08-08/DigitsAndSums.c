/*
------------------------------------------------------------------------------------
---------------------------- BlueBook - Digits and Sums ----------------------------
Output all three-digit numbers between "m" and "n" inclusive such that
the cube of the digits of the three digit-number is equal to the number itself.
Output on new lines.

100 <= m <= n <= 999, where m <= n.

Sample Input
100 200

Sample Input Explanation
m n

Sample Output
153

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Calculate each number individually.
Extract each digit and find their sum:
    ones digit = num % 10
    tens digit = num / 10 % 10
              OR num % 100 / 10
    hundreds digit = num / 100 % 10
                  OR num % 1000 / 100 (redundant version of the former)

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find all three digit numbers between a range whose sum of digits cubed is equal to itself.
@author Vincent Zhang
@since 08 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <math.h>

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and caommand-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    int m, n;
    scanf("%d %d", &m, &n);

    for(int i=m; i<=n; i++)
    {
        int d1 = i % 10;
        int d2 = i / 10 % 10;
        int d3 = i / 100 % 10;
        int sum = pow(d1, 3) + pow(d2, 3) + pow(d3, 3);

        if(sum == i)
        {
            printf("%d\n", i);
        }
    }

    return 0;
}