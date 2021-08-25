/*
---------------------------------------------------------------------------
---------------------------- BlueBook - Voting ----------------------------
Find the ballot count for candidates denoted by letters A-F.
Find the number of spoiled ballots.
First line of input will contain number of votes.

Sample Input
5
A
B
C
B
%

Sample Output
1
2
1
0
0
0
1

Sample Output Explanation
Lines 1-6: votes for candidate A-F.
Line 7: number of spoiled votes.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
An iterative approach might loop and cout.
Another method is to group the letters, store in a list of tupples (letter, frequency).
Then lookup the frequency for "A" to "F".

In both cases, spoiled ballots can be obtained from subtraction of valid ballots from total ballots.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Counts ballots.
@author Vincent Zhang
@since 25 August 2021
@context Self-Learning C
*/

#include <stdio.h>

int n, a, b, c, d, e, f;
char line[4];

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments +1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    scanf("%d", &n);

    for(int i=0; i<n; i++)
    {
        scanf("%s", line);

        switch(line[0])
        {
            case 'A': a++; break;
            case 'B': b++; break;
            case 'C': c++; break;
            case 'D': d++; break;
            case 'E': e++; break;
            case 'F': f++; break;
        }
    }
    printf("%d\n%d\n%d\n%d\n%d\n%d\n%d\n", a, b, c, d, e, f, n-a-b-c-d-e-f);

    return 0;
}