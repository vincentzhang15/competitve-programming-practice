/*
-------------------------------------------------------------------------
---------------------------- BlueBook - Cost ----------------------------
Determine the cost to mail a letter based on weight.

"
 0 ≤ N ≤ 30 costs 38 cents
30 < N ≤ 50 costs 55 cents
50 < N ≤ 100 costs 73 cents
if N > 100 then the base cost is 73 cents, plus 24 cents for every additional 50 grams or part thereof.
"

Sample Input
2
5
101

Sample Input Explanation
Line 1: number of tasks.
Line 2 to n+1: tasks.

Sample Output
38
97

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process each condition.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find mailling cost.
@author Vincent Zhang
@since 02 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <math.h>

/**
 * Main function to solve the problem.
 * @return 0 Successful program termination
 */
int main()
{
    int n; scanf("%d", &n);
    for(int i=0; i<n; i++)
    {
        int c; scanf("%d", &c);
        if(c <= 30) printf("38\n");
        else if(c <= 50) printf("55\n");
        else if(c <= 100) printf("73\n");
        else printf("%d\n", (int) (73 + 24*ceil((c-100) /50.0) ) );
    }
    
    return 0;
}