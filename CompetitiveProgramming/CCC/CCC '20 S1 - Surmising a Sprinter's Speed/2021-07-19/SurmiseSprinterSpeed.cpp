/*
###################################################################################################
############################ CCC '20 S1 - Surmising a Sprinter's Speed ############################
Find the max possible speed of a sprinter, given observations of their positions at various times.

Sample Input 1
3
0 100
20 50
10 120

Sample Input 1 Explanation
Line 1: n, number of observations.
Lin3 2...n+1: time position, observations.

Sample Output 1
7.0


Sample Input 2
5
20 -5
0 -17
10 31
5 -3
30 11

Sample Output 2
6.8

########################################################################
############################ SOLUTION LOGIC ############################
speed = distance / time
    distance = |displacement|
    displacement = pos2 - pos1
speed = |pos2 - pos1| / time
The max of speed will be the answer.
Ensure to sort the data structure by time as one cannot travel back in time in this question.
*/

/**
 * Program to find the max speed of a sprinter.
 * @author Vincent Zhang
 * @since 19 July 2021
 */
#include <iostream>
#include <algorithm>
#include <vector>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Normal termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Store time and position.
    int n; std::cin >> n;
    std::vector<std::pair<int, int>> timePos;
    for(int i=0; i<n; i++)
    {
        int time, pos; std::cin >> time >> pos;
        timePos.push_back({time, pos});
    }
    std::sort(timePos.begin(), timePos.end());

    // Find max.
    double max = -1;
    for(int i=0; i<n-1; i++)
    {
        double speed = (double)abs(timePos[i+1].second - timePos[i].second) / (timePos[i+1].first - timePos[i].first);
        if(speed > max)
            max = speed;
    }
    std::cout << max << '\n';

    return 0;
}