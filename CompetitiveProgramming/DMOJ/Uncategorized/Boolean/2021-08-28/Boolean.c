/*
-----------------------------------------------------------------
---------------------------- Boolean ----------------------------
Evaluate a boolean expression.

Sample Input 1
not not True

Sample Output 1
True

Sample Input 2
not not not False

Sample Output 2
True

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Count the number of "not". Even number will cancel out. Only need to apply one negation if odd.
Another way is to XOR while taking input, and compare initial assumed value with final True/False.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Evaluates a boolean expression.
@author Vincent Zhang
@since 28 August 2021
@context Self-Learning C
*/

#include <stdio.h>

char word[6];

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    int count = 0;
    while(1)
    {
        scanf("%s", word);
        if(word[0] == 'n')
        {
            count++;
        }
        else
        {
            if(count == 0)
                printf("%s", word);
            else if(count % 2 == 0)
            {
                if(word[0] == 'T')
                    printf("True");
                else
                    printf("False");
            }
            else
            {
                if(word[0] == 'F')
                    printf("True");
                else
                    printf("False");
            }
            break;
        }

    }

    return 0;
}