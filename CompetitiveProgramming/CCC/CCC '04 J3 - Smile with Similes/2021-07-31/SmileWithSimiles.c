/*
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// C DYNAMIC MEMORY ////////////////////////////////
1. stdlib.h malloc calloc free
    https://www.programiz.com/c-programming/c-dynamic-memory-allocation
    See code below.

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
@context Self-Learning C
*/

#include <stdio.h>
#include <stdlib.h>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 */
int main(int argc, char *argv[])
{
    int n; scanf("%d", &n);
    int m; scanf("%d", &m);

    // Allocate requested memory and return pointer to it.
    char **a = malloc(n * sizeof(char *));
    char **b = malloc(m * sizeof(char *));

    // calloc: allocate space for one elements.
    for(int i=0; i<n; i++) { char *d = calloc(1, 100); scanf("%100s", d); a[i] = d; }
    for(int i=0; i<m; i++) { char *d = calloc(1, 100); scanf("%100s", d); b[i] = d; }

    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            printf("%s as %s\n", a[i], b[j]);

    // Dynamically allocated memory with malloc and calloc takes up space that needs to be manually freed.
    for(int i=0; i<n; i++) free(a[i]); free(a);
    for(int i=0; i<m; i++) free(b[i]); free(b);

    return 0;
}