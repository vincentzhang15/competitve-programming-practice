/*
///////////////////////////////////////////////////////////////
///////////////////// C INPUT ENTIRE LINE /////////////////////
    char l1[1000];
    scanf(" %[^\n]s",l1);

    https://stackoverflow.com/questions/39431924/what-does-n-mean-in-c
    "
        [...]: it matches a nonempty sequence of characters from the scanset (a set of characters given by ...).
        ^ means that the scanset is "negated": it is given by its complement.
        ^\n: the scanset is all characters except \n.
        Furthermore fscanf (and scanf) will read the longest sequence of input characters matching the format.
    "

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
@context Self-Learning C
*/

#include <stdio.h>
#include <ctype.h>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    char l1[1000];
    scanf(" %[^\n]s",l1);
    char c = l1[0];

    char l2[1000];
    scanf(" %[^\n]s",l2);
    printf("%s\n", l2);

    int count = 0;
    for(int i=0; l2[i] != '.'; i++)
    {
        if(tolower(l2[i]) == c)
            count++;
    }
    printf("%d\n", count);

    return 0;
}