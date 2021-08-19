/*
-------------------------------------------------------------------------------
---------------------------- BlueBook - Lower Case ----------------------------
Convert given strings to lowercase.

Sample Input
2
abCDefg
WEEEIPWNNOOBS~~?~?~??@#!#$%?$^?$%*

Sample Output
abcdefg
weeeipwnnoobs~~?~?~??@#~#$%?$^?$%*

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in lower case functions or loop through characters and check if uppercase.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to convert strings to lowercase.
@author Vincent Zhang
@since 19 August 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <ctype.h> // tolower()

int n;
char data[257];

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
        scanf("%s", data);
        for(char *p = data; *p; ++p)
            *p = tolower(*p);
        printf("%s\n", data);
    }

    return 0;
}