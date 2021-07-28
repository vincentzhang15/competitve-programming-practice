/*
//////////////////////////////////////////////////////////////////////////
//////////////////////////// C SYNTAX SUMMARY ////////////////////////////
1. Input a String
    char s[5];
    scanf("%s", s);

2. Output a Character
    printf("%c\n", c);

3. Check If String Contains character
    char *pos = strchr(s, c);
    if(pos == NULL) {}

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
@context Self-Learning C
*/

#include <stdio.h>
#include <string.h>

int main()
{
    // Input string.
    char s[5];
    scanf("%s", s);

    // ASCII 'a' to 'f' at 102.
    for(int i=97; i<103; i++)
    {
        char c = (char)i;
        char *pos = strchr(s, c);

        if(pos == NULL)
        {
            printf("%c\n", c);
            break;
        }
    }

    return 0;
}