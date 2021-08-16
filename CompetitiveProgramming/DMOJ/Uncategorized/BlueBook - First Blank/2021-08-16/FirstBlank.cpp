/*
--------------------------------------------------------------------------------
---------------------------- BlueBook - First Blank ----------------------------
Find the position of the first occurance of a space. Output 0 if there are no spaces in a line.

Sample Input
2
 2
22

Sample Input Explanation
Line 1: n, number of strings.
Line 2 to n+1: strings to find the position of the first space.

Sample Output
1
0

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
For languages whose built index function returns -1, one can directly output the returned value + 1.
Extra processing required for languages that do not always return integers, e.g., Haskell.
Alternatively, use a for loop through the strings.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find the first position of a space.
@author Vincent Zhang
@since 16 August 2021
*/

#include <iostream>
#include <string>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n;
    std::cin >> n;
    std::cin.ignore();

    for(int i=0; i<n; i++)
    {
        std::string haystack;
        std::getline(std::cin, haystack);
        std::string needle = " ";
        std::size_t found  = haystack.find(needle);

        if(found == std::string::npos)
            std::cout << 0 << '\n';
        else
            std::cout << found+1 << '\n';
    }

    return 0;
}