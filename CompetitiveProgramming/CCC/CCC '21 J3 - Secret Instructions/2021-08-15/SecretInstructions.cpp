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
*/

#include <iostream>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{

    // Disable synchronization between C and c++ standard streams, allwoing c++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::string p;

    while(1)
    {
        std::string s;
        std::cin >> s;

        if(s.compare("99999") == 0)
            break;
        int sum = (int)(s[0]-'0') + (int)(s[1]-'0');

        if(sum ==0)
        {
            std::cout << p << " ";
        }
        else if(sum % 2 == 0)
        {
            std::cout << "right ";
            p = "right";
        }
        else
        {
            std::cout << "left ";
            p = "left";
        }
        std::cout << s.substr(2, 3) << '\n';
    }


    return 0;
}