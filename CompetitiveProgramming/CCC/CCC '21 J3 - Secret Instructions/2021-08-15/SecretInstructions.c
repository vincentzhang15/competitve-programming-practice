/*
------------------------------------------------------------------------------------------
---------------------------- CCC '21 J3 - Secret Instructions ----------------------------
Determine the direction of travel and number of steps given 5-digit numbers, e.g., 12345.

First two digits represent direction of turn.
    Sum odd: left
    Sum even: right
    Sum zero: previous direction
Last three digits is number of steps.
"99999": end program.

Sample Input
57234
00907
34100
99999

Sample Output
right 234
right 907
left 100

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Take input as string and extract first two digits.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to determine directions.
@author Vincent Zhang
@since 15 August 2021
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
    char p[6];
    while(1)
    {
        char s[6];
        scanf("%s", s);

        if
        (
               s[0] == '9'
            && s[1] == '9'
            && s[2] == '9'
            && s[3] == '9'
            && s[4] == '9'
        ) break;

        int sum = (int)(s[0]-'0') + (int)(s[1]-'0');
        if(sum % 2 == 1)
        {
            printf("left ");
            p[0] = 'l';
            p[1] = 'e';
            p[2] = 'f';
            p[3] = 't';
            p[4] = '\0';
        }
        else if(sum == 0)
        {
            printf("%s ", p);
        }
        else
        {
            printf("right ");
            p[0] = 'r';
            p[1] = 'i';
            p[2] = 'g';
            p[3] = 'h';
            p[4] = 't';
            p[5] = '\0';
        }

        printf("%c%c%c\n", s[2],s[3],s[4]);

    }

    return 0;
}