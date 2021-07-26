/*
###########################################################################################################
############################ TLE '16 Contest 6 (Mock CCC) S1 - Writing the CCC ############################
"The CS Nerd" solves problems in order of preference by problem type.
Input will first give a list of question prefernces in order.
The second part of the input will give the order of question types on the CCC (Canadian Chemistry Competition).
Output the order in which "the CS nerd" solves the problems according to the order of preference.

Sample Input
5
equilibrium
trivial
organic
lab
adhoc
7
trivial
organic
adhoc
equilibrium
trivial
lab
adhoc

Sample Input Explanation
L1: t, number of problem types.
L2 to Lt+1: problem types in order of preference.
Lt+1+1: n, number of questions on the CCC.
Lt+1+1 to Lt+1+n: questions types on the CCC in order that it appears on the contest.

Sample Output
4
1
5
2
6
3
7

########################################################################
############################ SOLUTION LOGIC ############################
Store prefernce order in a list/array to process later.
For fast output of order, a dict/map can be used in which the reference to the map would lead to the positions of all occurances of a problem type.
    dict = {type, [occurance position1, pos2, ...]}
*/

/**
 * Program to find the order to solve problems on a chemistry contest.
 * @author Vincent Zhang
 * @since 26 July 2021
 */
#include <iostream>
#include <vector>
#include <unordered_map>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char **argv)
{
    // Disable syncrhonization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);
    
    // Store the order of preference.
    int t; std::cin >> t;
    std::string order[t];
    std::unordered_map<std::string, std::vector<int>> data;
    for(int i=0; i<t; i++)
    {
        std::cin >> order[i];
    }

    // Store the order of questions.
    int n; std::cin >> n;
    for(int i=0; i<n; i++)
    {
        std::string choice; std::cin >> choice;
        data[choice].emplace_back(i+1);
    }

    // Output result.
    for(int i=0; i<t; i++)
    {
        for(int pos : data[order[i]])
        {
            std::cout << pos << '\n';
        }
    }

    return 0;
}