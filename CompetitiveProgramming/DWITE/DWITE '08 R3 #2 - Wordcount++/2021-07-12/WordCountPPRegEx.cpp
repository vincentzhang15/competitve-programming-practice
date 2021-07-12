/*
////////////////////////////////////////////////////////////////////////
//////////////////////////// SYNTAX SUMMARY ////////////////////////////
1. C++ Regular Expression: Count Matches
    https://stackoverflow.com/questions/8283735/count-number-of-matches
    https://www.ibm.com/docs/en/zos/2.3.0?topic=types-sregex-iterator

    // ptrdiff_t is a signed integer storing the result of two pointer subtraction.
    ptrdiff_t const matches
    (
        // std::distance() finds the number of elements between two iterators.
        distance
        (
            // sregex_iterator() is a typedef over regex_iterator for iterators of type string::const_iterator.
            // regex_iterator() iterates through matches in string.
            sregex_iterator(s.begin(), s.end(), pattern),
            sregex_iterator()
        )
    );

///////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// DWITE '08 R3 #2 - Wordcount++ ////////////////////////////
Given five lines of input, find the number of words that are at least four characters in length.
A word is any consecutive sequence of alpha (uppercase and lowercase) characters.

Sample Input
DWITE question number two: Wordcount++
Note how "two:" does not count.
For simplicity - "don't" is two words, split by apostrophe.

That was a blank line above.

Sample Output
4
3
4
0
4

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Match words with regular expression string. Match by 2 rules:
    1. alpha.
    2. at least 4 consecutive alpha characters.
*/

/**
 * Program to count the number of valid words per line.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
#include <iostream>
#include <regex>
using namespace std;

/**
 * Main function to solve the problem.
 * @return 0
 */
int main()
{
    // Fast input.
    cin.sync_with_stdio(0);
    cin.tie();

    // Regex pattern.
    regex const pattern("[a-zA-Z]{4,}");

    // Loop through the 5 lines.
    for(int i=0; i<5; i++)
    {
        string s; getline(cin, s);

        // ptrdiff_t is a signed integer storing the result of two pointer subtraction.
        ptrdiff_t const matches
        (
            // std::distance() finds the number of elements between two iterators.
            distance
            (
                // sregex_iterator() is a typedef over regex_iterator for iterators of type string::const_iterator.
                // regex_iterator() iterates through matches in string.
                sregex_iterator(s.begin(), s.end(), pattern),
                sregex_iterator()
            )
        );
        // Output.
        cout << matches << '\n';
    }
}