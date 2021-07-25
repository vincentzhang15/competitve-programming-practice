/*
#####################################################################################
############################ TLE '15 P1 - Power Rankings ############################
Output the rankings of names based on number of minutes viewing PowerPoints.
The ranking is ordered by 3 + students with a greater total time viewing PowerPoints.

Sample Input
5 3
EnochPoon
LiuJason
Nathanl3
AlexW
TT1103
3 4 2 1 0
1 3 4 2 0
5 1 7 4 0

Sample Input Explanation
L1: n p, number of names, number of PowerPoints.
L2 to Ln+1: names.
Ln+1+1 to Ln+1+p: t[0] t[1] ... t[n], time the ith student spends on a PowerPoint.

Sample Output
3. Nathanl3
4. EnochPoon
5. LiuJason
6. AlexW
7. TT1103

########################################################################
############################ SOLUTION LOGIC ############################
Pair time and name of each person.
Sort by time in reverse order.
Output starting from 3.
*/

/**
 * Program to find the "power rankings".
 * @author Vincent Zhang
 * @since 25 July 2021
 */
#include <iostream>
#include <vector>
#include <algorithm>

/**
 * Public class to store time sum and name.
 * @author Vincent Zhang
 * @since 25 July 2021
 */
struct Data
{
    int sum;
    std::string name;
}
info[101]; // Data info[101].

/**
 * Compare method to sort Data in reverse order.
 * @param a First person sum
 * @param b Second person sum
 * @return Whether first person sum > second person sum
 */
bool compare(Data a, Data b)
{
    return a.sum > b.sum;
}

/**
 * Main function to solve the problem.
 * @param argc Number of command-line arguments + 1 for program name
 * @param argv Program name and command-line arguments
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Store names.
    int n, p; std::cin >> n >> p;
    for(int i=0; i<n; i++)
    {
        std::string name; std::cin >> name;
        info[i].sum = 0;
        info[i].name = name;
    }

    // Store sum of times.
    for(int i=0; i<p; i++)
    {
        for(int j=0; j<n; j++)
        {
            int t; std::cin >> t;
            info[j].sum += t;
        }
    }

    // Output result.
    std::sort(info, info+n, compare);
    for(int i=0; i<n; i++)
        std::cout << i+3 << ". " << info[i].name << '\n';

    return 0;
}