/*
------------------------------------------------------------------------------
---------------------------- BlueBook - Direction ----------------------------
Given a direction in integer degrees N. 0 ≤ N < 360.
Print the closest cardinal direction.
Ties are broken by smaller directions.
Direction in increasing size are N, E, S, W.
I.e., choose N over E when deg <= 45
             N over W when deg >= 315

Sample Input
2
45
180

Sample Input Explanation
Line 1: T, number of tasks.
Line 2 to T+1: degrees.

Sample Output
N
S

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process conditions.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to print the closest cardinal direction.
@author Vincent Zhang
@since 03 August 2021
*/

#include <iostream>

/**
 * Main function to solve the program.
 * @return 0 Successful program termination
 */
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n;
    std::cin >> n;

    for(int i=0; i<n; i++)
    {
        int d;
        std::cin >> d;

        if(d <= 45 || d >= 315)
            std::cout << "N\n";
        else if(d <= 135)
            std::cout << "E\n";
        else if(d <= 225)
            std::cout << "S\n";
        else
            std::cout << "W\n";
    }

    return 0;
}