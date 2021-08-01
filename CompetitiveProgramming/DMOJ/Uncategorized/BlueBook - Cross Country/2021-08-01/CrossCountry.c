/*
----------------------------------------------------------------------------------
---------------------------- BlueBook - Cross Country ----------------------------
Given a two digit code, output one of the following corresponding results.
If a code does not exist output "invalid code".

Code 	Output
MG 	    midget girls
MB 	    midget boys
JG 	    junior girls
JB 	    junior boys
SG 	    senior girls
SB 	    senior boys

Sample Input
JG

Sample Output
junior girls

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Store codes in a map or check cases with if-else.

-------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ---------------------------
Program to output the matching result of a code if it exists.
@author Vincent Zhang
@since 01 August 2021
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Main function to solve the problem.
 * @return 0 Successful program termination.
 */
int main()
{
    char s[2]; scanf("%2s", s);
    
    if(s[0] == 'M' && s[1] == 'G') printf("midget girls");
    else if(s[0] == 'M' && s[1] == 'B') printf("midget boys");
    else if(s[0] == 'J' && s[1] == 'G') printf("junior girls");
    else if(s[0] == 'J' && s[1] == 'B') printf("junior boys");
    else if(s[0] == 'S' && s[1] == 'G') printf("senior girls");
    else if(s[0] == 'S' && s[1] == 'B') printf("senior boys");
    else printf("invalid code");

    return 0;
}