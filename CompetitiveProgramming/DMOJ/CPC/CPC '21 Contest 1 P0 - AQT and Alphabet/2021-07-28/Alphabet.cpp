/*
#################################################################################################
############################ CPC '21 Contest 1 P0 - AQT and Alphabet ############################
Find the first letter of the lowercase alphabet not in the input string.
The only line of input string will always contain 5 characters.

Sample Input
zdeac

Sample Input Explanation
L1: 5 characters of the lowercase alphabet.

Sample Output
b

########################################################################
############################ SOLUTION LOGIC ############################
In general, compare input string against alphabet.
Optimization: only first 6 letters of alphabet need to be checked since there are always 5 letters in input string.

Method 1 - Implemented using Haskell in Alphabet.hs:
    Subtract the input string from the lowercase alphabet and output the first character of the result.
Method 2 - Implemented using Python 3 in Alphabet.py:
    Construct a list of lowercase alpha characters not in input string, then output first element in list.
Method 3 - Implemented using C++ in Alphabet.cpp:
    Record occurance of each input string character in an array of length 26, then output the first element without a record.
Method 4 - Implemented using Java in Alphabet.java:
    Loop through integer value of alphabet and check if integer value exists in an array of integer value of the input string (char[]).
Method 5 - Implemented using C in Alphabet.c:
    Loop through characters of alphabet and check if character exists in input string.

#########################################################################
############################ PROGRAM COMMENTS ###########################
Program to find the first lowercase alpha character not in a given string.
@author Vincent Zhang
@since 28 July 2021
*/

#include <iostream>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of arguments +1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    std::string s; std::cin >> s;

    // Record occurance of char.
    int a[26];
    for(char c : s)
    {
        a[c-97] = 1;
    }

    // Find first unrecorded value.
    for(int i=0; i<6; i++)
    {
        if(a[i] != 1)
        {
            std::cout << (char)(i + 97) << '\n';
            break;
        }
    }

    return 0;
}