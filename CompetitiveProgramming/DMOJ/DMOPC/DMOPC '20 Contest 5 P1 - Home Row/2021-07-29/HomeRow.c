/*
////////////////////////////////////////////////////////////////////
//////////////////////////// C CONCEPTS ////////////////////////////
1. Double Evaluation
    https://stackoverflow.com/questions/39439181/what-is-double-evaluation-and-why-should-it-be-avoided
    "
        #define Max(a,b) (a < b ? b : a)
        int x(){ turnLeft();   return 0; }
        int y(){ turnRight();  return 1; }

        call with:
        auto var = Max(x(), y());

        turnRight() executes twice

        Max macro expands to:
        auto var = (x() < y() ? y() : x());

        1. evaluate:
            x() < y()
        2. take required branch (true in this case):
            calls y() 2nd time
    "

-------------------------------------------------------------------------------------------
---------------------------- DMOPC '20 Contest 5 P1 - Home Row ----------------------------
Given two strings, find the minimum keystrokes to change the first string to the second string.
Strings will always be lowercase alphabet characters.
Keystrokes available:
    1. Type a lowercase letter.
    2. Delete a letter from the end of the string.

Sample Input 1
adachi
shimamura

Sample Output
15

Sample Input 2
shinomiya
shirogane

Sample Output 2
12

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
A matching prefix is the only part of the first string that does not need to be changed.
Every subsequent character in the first string needs to be deleted from the string.
Every subsequent character in the second string needs to be added to the first string.

Procedural Programming Langage Implementation (see HomeRow.py .cpp .c .java)
    Step 1: loop through characters in both strings to find the length of the equal prefix.
    Step 2: calculate result.
        Method 1: len(s1)+len(s2) - 2 * number of non equivalent characters.
            e.g,
              aaaaabcde    -> aaaaa bcde
              aaaaacdefghi -> aaaaa cdef    ghi
              +len                  -2*len
        Method 2: 2*non equivalent chars + diff in string lengths
            e.g,
              aaaaabcde    -> aaaaa bcde
              aaaaacdefghi -> aaaaa cdef    ghi
                                    2*len   +len

Functional Programming Language Implementation (see HomeRow.hs)
    Method 1: drop all matching characters with a recursive function.
        This leaves a list with length equal to number of non-equivalent chars.
        Apply Method 2 formula in the procedural section above.
    Method 2: find the first index where different chars occur (in forward or reverse direction).
        With the index, apply Method 1 formula in the procedural section above.
        This method is slower than Method 1 for long strings in Haskell because Haskell's (!!) operator is O(N).
        Which means, the recursive calls to find the index will be costly, especially if trying to find index at end with forward find and front index with reverse find.

-------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ---------------------------
Program to find the minimum keystrokes required to make the first string identical to the second.
@author Vincent Zhang
@since 29 July 2021
@context Self-Learning C
*/

#include <stdio.h>
#include <string.h>

// Based on https://gcc.gnu.org/onlinedocs/gcc-4.9.2/gcc/Typeof.html#Typeof

#define min(a,b) ({ __typeof__ (a) _a = (a); __typeof__ (b) _b = (b); _a < _b ? _a : _b; })

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful termination
 */
int main(int argc, char *argv[])
{
    const int MAX = 1000001;

    char s1[MAX];
    char s2[MAX];
    scanf("%s", s1);
    scanf("%s", s2);
    int s1Len = strlen(s1);
    int s2Len = strlen(s2);

    int i = 0;
    for(; i<min(s1Len, s2Len); i++)
    {
        if(s1[i] != s2[i])
        {
            break;
        }
    }

    int ans = strlen(s1) + strlen(s2) - i - i;
    printf("%d\n", ans);

    return 0;
}