/*
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '17 S2 - High Tide, Low Tide ////////////////////////////
Order unordered high and low tide measurements using rules:
    1. Low and high tide alternate, starting with low.
    2. High tides are always greater than low tides.
    3. High tides only become higher. Low tides only become lower.
Output the tides in the right order.

Sample Input
8
10 50 40 7 3 110 90 2

Sample Input Explanation
Line 1: number of tide measurements.
Line 2: unordered high and low tides.

Sample Output
10 40 7 50 3 90 2 110

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Sort the tides.
Split lower half of tides to lo tides (contains 1 more tide value if odd number of tides).
Upper half = high tide.
Output accordingly.
*/

/**
 * Program to place tide measurements in the right order.
 * @author Vincent Zhang
 * @since 15 July 2021
 */
#include <iostream>
#include <algorithm>
#include <vector>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 If successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Get input and sort tides.
    int n; std::cin >> n;
    int tides[n];
    for(int i=0; i<n; i++)
        std::cin >> tides[i];
    std::sort(tides, tides+n);

    // Split array.
    int mid = (n-1) >> 1; // Right shift by 1 is equivalent to integer divide by 2. (e.g., in base 10, 101/10 = 10.1, casting to int is 10 which is shifting to the right one place. Same aplies in binary.)
    std::vector<int> lo;
    std::vector<int> hi;
    for(int i=mid; i>=0; i--) lo.push_back(tides[i]);
    for(int i=mid+1; i<n; i++) hi.push_back(tides[i]);

    // Output result.
    std::string output = "";
    for(size_t i=0; i<lo.size(); i++)
    {
        output += std::to_string(lo[i]) + " ";
        if(i < hi.size())
            output += std::to_string(hi[i]) +" ";
    }
    std::cout << output.substr(0, output.length()-1) << '\n';

    // Successful termination will return 0.
    return 0;
}