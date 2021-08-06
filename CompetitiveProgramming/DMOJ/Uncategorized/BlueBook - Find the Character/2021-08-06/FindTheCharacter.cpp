/*
---------------------------------------------------------------------------------------
---------------------------- BlueBook - Find the Character ----------------------------
Count the number of occurances of a character in a string. Case insensitive.
String sentence will always terminate with a period.

Sample Input 1
o
Why so serious son.

Sample Input 1 Explanation
Line 1: character to find.
Line 2: string in which to find the character.

Sample Output 1
Why so serious son.
3

Sample Output 1 Explanation
Line 1: output the input string.
Line 2: number of canse insensitive occurances of input char in input string.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Directly count. Make character lower case or upper case to count once.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to count occurances of a character in a string.
@author Vincent Zhang
@since 06 August 2021
*/

#include <iostream>

int main(int argc, char **argv)
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    char c; std::cin >> c; std::cin.ignore();
    std::string s; std::getline(std::cin, s);
    std::cout << s << '\n';

    int count = 0;
    for(size_t i=0; i<s.length(); i++)
    {
        if(std::tolower(s[i]) == std::tolower(c))
            count++;
    }
    std::cout << count << '\n';

    return 0;
}