/*
-----------------------------------------------------------------------------
---------------------------- BlueBook - Multiple ----------------------------
Given two positive integers, "a", "b", determine if "a" is a mulitple of "b".
Output "yes" or "no".

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
if a % b == 0
    "yes"
else
    "no"

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to check if "a" is a mulitple of "b".
@author Vincent Zhang
@since 18 August 2021
*/

#include <iostream>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int a, b;
    std::cin >> a >> b;

    std::cout << (a%b == 0 ? "yes" : "no");

    return 0;
}