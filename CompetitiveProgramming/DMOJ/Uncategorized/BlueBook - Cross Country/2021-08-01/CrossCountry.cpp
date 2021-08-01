/*
----------------------------------------------------------------------------------
---------------------------- BlueBook - Cross Country ----------------------------
Given a two digit code, output one of the following corresponding results.
If a code does not exist output "invalid code".

Code 	Output
MG 	    midget girls
MB 	    midget boys
JG 	    junior girls
JB 	    junior boys
SG 	    senior girls
SB 	    senior boys

Sample Input
JG

Sample Output
junior girls

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Store codes in a map or check cases with if-else.

-------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ---------------------------
Program to output the matching result of a code if it exists.
@author Vincent Zhang
@since 01 August 2021
*/

#include <iostream>
#include <unordered_map>

/**
 * Main function to solve the problem.
 * @return 0 Successful program termination.
 */
int main()
{
    std::unordered_map<std::string, std::string> d = {
            {"MG", "midget girls"},
            {"MB", "midget boys"},
            {"JG", "junior girls"},
            {"JB", "junior boys"},
            {"SG", "senior girls"},
            {"SB", "senior boys"}
        };
    
    std::string s; std::cin >> s;
    std::unordered_map<std::string, std::string>::iterator it = d.find(s);

    if(it == d.end())
        std::cout << "invalid code";
    else
        std::cout << d[s];

    return 0;
}