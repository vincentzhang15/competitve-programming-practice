/*
//////////////////////////////////////////////////////////////////////
//////////////////////////// KEY CONCEPTS ////////////////////////////
1. scan(x) Macro For Integers
    See code below.

####################################################################################
############################ CCC '21 S1 - Crazy Fencing ############################
Find the area of a fence made of trapezoid wood pieces where adjacent wood edge heights are equal.

Sample Input 1
3
2 3 6 2
4 1 1

Sample Input 1 Explanation
L1: n, number of wood pieces.
L2: h1...hn+1, left and right heights of wood pieces.
L3: w1...wn, width of wood pieces.

Sample Output 1
18.5

Sample Input 2
4
6 4 9 7 3
5 2 4 1

Sample Output 2
75

########################################################################
############################ SOLUTION LOGIC ############################
Visualizing sample input 1:
              6
              |
              |
          3   |
2         |   |   2
|         |   |   |
| _ _ _ _ | _ | _ |
     4      1   1

Sum the trapezoid areas.
Sum = i=0 Σ n-1 ( w_i + w_i+1 ) * h_i / 2
Sum = 0.5 * ( i=0 Σ n-1 ( w_i + w_i+1 ) * h_i )

i.e., divide by two last since (with Input 1):
(2+3)*4/2 + (3+6)*1/2 + (6+2)*1/2
= (1/2) * [(2+3)*4 + (3+6)*1 + (6+2)*1]

In general this solution process involves 2 steps:
    Step 1: sum of (w_i + w_i+1) * h_i.
        Method 1: loop.
        Method 2:
            Step 1: Add all heights without first element with all heights without last element.
            Step 2: Multiply result by all widths.
            Step 3: Apply sum function.
            Useful for solving with Haskell.
    Step 2: divide sum by 2.
        Note: C++ will convert to scientific notation when a 7-digit number is divided by 2.0.
        Method 1: direct division.
        Method 2: int division/truncate/bitshift and check parity.
*/

/**
 * Program to find the area of a fance.
 * @author Vincent Zhang
 * @since 27 July 2021
 * @context Self-Learning C
 */
#include <stdio.h>

// Take integer input (only works with ASCII chars '0'-'9' DEC 48-57).
#define scan(x)\
    do\
    {\
        while\
        (\
            /* Filter out all characters before ASCII '0' at DEC 48. */\
            (x=getchar())<'0'\
            /* getchar() returns input char as unsigned char cast to int or EOF. */\
        );\
        \
        /* Character is '0' or after, e.g., alphanumeric chars. */\
        for\
        (\
            /* Relative position to '0', DEC 48. */\
            x -= '0';\
            /* Subsequent characters are after '0' on ASCII table. */\
            '0' <= ( _=getchar() );\
            x =\
                /* x(2^3) + x(2) = x(8+2) = 10*x */\
                ( x<<3 ) + ( x<<1 )+\
                _-'0'\
        );\
    }\
    while(0)
char _; // Next digit.

/**
 * Main function to solve the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Declarations.
    const int MAX = 10001;
    int n, w, h[MAX];

    scan(n);

    // Get heights.
    for(int i=0; i<=n; i++)
    {
        scan(h[i]);
    }

    // Get widths at the same time as calculating area*2.
    int areaTimes2 = 0;
    for(int i=0; i<n; i++)
    {
        scan(w);
        areaTimes2 += (h[i] + h[i+1]) * w;
    }

    // Output area.
    printf("%f\n", areaTimes2/2.0);

    return 0;
}