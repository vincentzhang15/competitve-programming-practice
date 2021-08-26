/*
---------------------------------------------------------------------------
---------------------------- BlueBook - Grades ----------------------------
Determine the grade letter given an integer that is an element of (-1000, 1000)
    "
    A 	80 - 100
    B 	70 - 79
    C 	60 - 69
    D 	50 - 59
    F 	0 - 49
    X 	Anything else…
    "

Sample Input
3
10
99
101

Sample Output
F
A
X

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
If statements.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Find the grade leter of a grade value.
@author Vincent Zhang
@since 26 August 2021
@context Self-Learning C
*/

#include <stdio.h>

int n, x;

/**
 * Solves the problem.
 * @param argc Argument count, number of command-lien arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    scanf("%d", &n);
    while(n--)
    {
        scanf("%d", &x);
        if(x >= 80 && x <= 100)
            printf("A");
        else if(x >= 70 && x <= 79)
            printf("B");
        else if(x >= 60 && x <= 69)
            printf("C");
        else if(x >= 50 && x <= 59)
            printf("D");
        else if(x >= 0 && x <= 49)
            printf("F");
        else
            printf("X");
        printf("\n");
    }

    return 0;
}