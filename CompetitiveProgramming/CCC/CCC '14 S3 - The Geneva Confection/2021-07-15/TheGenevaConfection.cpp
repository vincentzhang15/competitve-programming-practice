/*
////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '14 S3 - The Geneva Confection ////////////////////////////
Candies ordered 1 to "n" are dropped from a mountain top to a lake at the bottom.
Goal: drop the candies in an arithmetic progression where the common difference is 1.
This may or may not be possible.
To increase the possibility of successful ordering, there exists a branch between the top and bottom fo the mountain,
where candies may be stored in first in last out order.
Candies in the branch may be dispensed at any time.
Determine if candies can be dropped in increasing order.

Sample Input
2
4
2
3
1
4
4
4
1
3
2

Sample Input Explanation:
Line 1: t, number of tasks, i.e., repeat the problem "t" times (test for efficiency).
Line 2: n[0], number of candies in task 1.
Line 3 to n[0]+2: candies in task 1.
Line n[0]+2+1: number of candies in task 2.
etc.
Note dropping order is bottom to top of each task.

Sample Output
Y
N

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Store candies in branch with a stack.
Each candy can have 2 actions:
    1. Drop to lake.
    2. Drop to branch, to drop to lake later only if a later candy acts as a stepping stone for candies in the branch.

Since candies are numbered 1 to n, keep track of the value 1 to n at the lake.
Let "lake=0" be the initial value of the lake candy.
For each candy,
    1. If can be dropped to lake:
        lake + 1
        drop any candies in branch that can be dropped:
            for every valid candy: lake +1
    2. Candy cannot be dropped in lake:
        branch.push(candy)
*/

/**
 * Program to determine if arithmetic progression ordering is possible with a stack.
 * @author Vincent Zhang
 * @since 15 July 2021
 */
#include <iostream>
#include <stack>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of arguments + 1 for the program name
 * @param argv Argument vector, program name and command-line arguments
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    int tasks; std::cin >> tasks;
    while(tasks--)
    {
        // Get input.
        int nCandy; std::cin >> nCandy;
        int candies[nCandy]; for(int i=0; i<nCandy; i++) std::cin >> candies[i];

        // Important variables.
        std::stack<int> branch;
        int lake = 0;

        // Process each candy: drop or store in branch.
        for(int i=nCandy-1; i>=0; i--)
        {
            int candy = candies[i];

            // Attempt to drop candy to lake.
            if(candy == lake+1)
            {
                lake++;
                // When there is a change in the lake count, check the branch as it may be possible to drop candies from branch.
                while(!branch.empty() && branch.top() == lake+1)
                {
                    branch.pop();
                    lake++;
                }
            }
            else
                // When nothing can be dropped into the lake, add to branch.
                // A candy added to a branch means nothing can be dropped from the branch, thus, there is no need to check branch.
                branch.push(candy);
        }

        // Output.
        std::cout << (branch.empty() ? "Y" : "N") << '\n';
    }

    // Program successfully terminated if 0 is returned.
    return 0;
}