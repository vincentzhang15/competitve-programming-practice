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
*/

#include <iostream>

std::string word;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    int count = 0;
    while(1)
    {
        std::cin >> word;
        if(word[0] == 'n')
        {
            count++;
        }
        else
        {
            if(count % 2 == 0)
                std::cout << word << '\n';
            else
            {
                if(word[0] == 'F')
                    std::cout << "True" << '\n';
                else
                    std::cout << "False" << '\n';
            }
            break;
        }

    }

    return 0;
}