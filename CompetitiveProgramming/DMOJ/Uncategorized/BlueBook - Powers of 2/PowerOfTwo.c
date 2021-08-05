/*
--------------------------------------------------------------------------------
---------------------------- BlueBook - Powers of 2 ----------------------------
Find smallest power of two >= input integer.

Sample Input
200

Sample Output

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
log_2(input) yields the exponent to raise 2 to, to get "input".
Because:
    log_2(input) = a <==> 2^a = input
Thus, the smallest power of 2 >= input is the ceiling of log_2().

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the smallest power of 2 >= input integer.
@author Vincent Zhang
@since 05 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <math.h>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    int n;
    scanf("%d", &n);
    printf("%d", (int)ceil(log(n)/log(2)));

    return 0;
}