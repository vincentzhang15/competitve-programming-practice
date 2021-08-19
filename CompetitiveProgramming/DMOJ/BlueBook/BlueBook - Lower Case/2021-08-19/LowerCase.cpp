/*
-------------------------------------------------------------------------------
---------------------------- BlueBook - Lower Case ----------------------------
Convert given strings to lowercase.

Sample Input
2
abCDefg
WEEEIPWNNOOBS~~?~?~??@#!#$%?$^?$%*

Sample Output
abcdefg
weeeipwnnoobs~~?~?~??@#~#$%?$^?$%*

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in lower case functions or loop through characters and check if uppercase.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to convert strings to lowercase.
@author Vincent Zhang
@since 19 August 2021
*/

#include <iostream>

int n;
char s[257];

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    for(int i=0; i<n; i++)
    {
        std::cin >> s;
        for(char *p = s; *p; ++p)
            *p = tolower(*p);
        std::cout << s << '\n';
    }
    return 0;
}