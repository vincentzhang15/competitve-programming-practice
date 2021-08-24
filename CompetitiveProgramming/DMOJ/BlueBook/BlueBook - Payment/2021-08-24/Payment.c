/*
----------------------------------------------------------------------------
---------------------------- BlueBook - Payment ----------------------------
Find the occurance frequency of integers (0 <= n <= 1000000) in each of the following ranges.
<= 9999
> 9999 && d <= 19999
> 19999 && d <= 29999
> 29999 && d <= 39999
> 39999 && d <= 49999
> 49999 && d <= 1000000

Output frequency count in order of the 6 intervals.
Line will be terminated by -1.

Sample Input
1
9999
10001
1000000
29999
-1

Sample Output
2
1
1
0
0
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Filter with a series of conditions.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Counts occurance freqeuncy in 6 ranges.
@author Vincent Zhang
@since 24 August 2021
@context Self-Learning C
*/

#include <stdio.h>

int a, b, c, d, e, f, n;

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments +1 for program name
 * @param argv Argument vecotr, program name and command-lien arguments
 * @return 0 Succesful program termination
 */
int main(int argc, char **argv)
{
    while(1)
    {
        scanf("%d", &n);

        if(n == -1) break;
        else if(n <= 9999) a++;
        else if(n <= 19999) b++;
        else if(n <= 29999) c++;
        else if(n <= 39999) d++;
        else if(n <= 49999) e++;
        else f++;
    }

    printf("%d\n%d\n%d\n%d\n%d\n%d\n", a, b, c, d, e, f);

    return 0;
}