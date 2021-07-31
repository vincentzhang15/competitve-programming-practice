/*
#########################################################################################
############################ CCC '04 J3 - Smile with Similes ############################
Create similes with a list of adjectives and a list of nouns.
Order of output does not matter.

Sample Input
3
2
Easy
Smart
Soft
pie
rock

Sample Input Explanation
L1: n, number of adjectives.
L2: m, number of nouns.
L2+1 to L2+n: list of adjectives.
L2+n+1 to L2+n+m: list of nouns.

Sample Output
Easy as pie
Easy as rock
Smart as pie
Smart as rock
Soft as pie
Soft as rock

########################################################################
############################ SOLUTION LOGIC ############################
Loop through adjectives and nouns in nested loop and print.

Haskell Solution Logic:
    Store entire list of input.
    Match adjectives generator with nouns generator.
        Adj generator: first n items in entire list excluding first two lines.
        Noun generator: last m items in entire list. First m of reversed list.

##########################################################################
############################ PROGRAM COMMENTS ############################
Program creates similes with adjectives and nouns.
@author Vincent Zhang
@since 31 July 2021
*/

#include <iostream>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of arguments + 1 for program name
 * @param argv Argument vector, command-line arguments and program name
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    int n; std::cin >> n;
    int m; std::cin >> m;
    
    std::string a[n]; for(int i=0; i<n; i++) std::cin >> a[i];
    std::string b[m]; for(int i=0; i<m; i++) std::cin >> b[i];

    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            std::cout << a[i] << " as " << b[j] << '\n';

    return 0;
}