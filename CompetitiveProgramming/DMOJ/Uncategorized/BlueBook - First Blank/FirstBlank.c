/*
--------------------------------------------------------------------------------
---------------------------- BlueBook - First Blank ----------------------------
Find the position of the first occurance of a space. Output 0 if there are no spaces in a line.

Sample Input
2
 2
22

Sample Input Explanation
Line 1: n, number of strings.
Line 2 to n+1: strings to find the position of the first space.

Sample Output
1
0

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
For languages whose built index function returns -1, one can directly output the returned value + 1.
Extra processing required for languages that do not always return integers, e.g., Haskell.
Alternatively, use a for loop through the strings.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the first position of a space.
@author Vincent Zhang
@since 16 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <string.h> // strstr()

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    int n;
    scanf("%d", &n);

    char s[1000];
    fgets(s, 100, stdin);
    for(int i=0; i<n; i++)
    {
        fgets(s, 100, stdin);
        char *found = strstr(s, " ");
        if(found == NULL)
        {
            printf("0\n");
        }
        else
        {
            printf("%d\n", (int)(found-s)+1);
        }
    }

    return 0;
}