/*
-------------------------------------------------------------------------------------
---------------------------- CCC '21 J2 - Silent Auction ----------------------------
Find the name of the first bidder with the highest price.

Sample Input 1
3
Ahmed
300
Suzanne
500
Ivona
450

Sample Output 1
Suzanne

Sample Input 2
2
Ijeoma
20
Goor
20

Sample Output 2
Ijeoma

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find the max price.
Find the first name with the max price.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the first highest bidder.
@author Vincent Zhang
@since 23 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <string.h>

int n;
int curPrice, maxPrice = -1;
char curName[1000], maxName[1000];

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    scanf("%d", &n);
    for(int i=0; i<n; i++)
    {
        scanf("%s", curName);
        scanf("%d", &curPrice);
        if(curPrice > maxPrice)
        {
            maxPrice = curPrice;
            strcpy(maxName, curName);
        }
    }
    printf("%s\n", maxName);

    return 0;
}