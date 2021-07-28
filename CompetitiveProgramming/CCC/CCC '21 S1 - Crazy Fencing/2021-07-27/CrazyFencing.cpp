/*
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
 */
#include <iostream>
#include <iomanip>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Allocate memory for heights and widths.
    int n; std::cin >> n;
    int h[n+1];
    int w[n];

    // Store heights and widths.
    for(int i=0; i<=n; i++)
    {
        std::cin >> h[i];
    }
    for(int i=0; i<n; i++)
    {
        std::cin >> w[i];
    }

    // Find the sum * 2.
    int sumTimes2 = 0;
    for(int i=0; i<n; i++)
    {
        sumTimes2 += (h[i] + h[i+1]) * w[i];
    }

    // Half the sum and ensure output does not convert to scientific notation with 7-digit int sum.
    std::cout << std::fixed << std::setprecision(1) << sumTimes2 / 2.0 << '\n';

    return 0;
}