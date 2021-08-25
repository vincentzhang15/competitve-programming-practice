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
*/

#include <iostream>

int n, a, b, c, d, e, f;
char ch;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing c++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    for(int i=0; i<n; i++)
    {
        std::cin >> ch;
        switch(ch)
        {
            case 'A': a++; break;
            case 'B': b++; break;
            case 'C': c++; break;
            case 'D': d++; break;
            case 'E': e++; break;
            case 'F': f++; break;
        }
    }
    std::cout << a << '\n';
    std::cout << b << '\n';
    std::cout << c << '\n';
    std::cout << d << '\n';
    std::cout << e << '\n';
    std::cout << f << '\n';
    std::cout << (n-a-b-c-d-e-f) << '\n';

    return 0;
}