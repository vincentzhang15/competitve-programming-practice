/*
#######################################################################################
############################ ECOO '16 R1 P3 - Railway Sort ############################
Find the minimum cost of applying "railway sort" on a permutation of integers from 1 to N.
The number of train cars is N, 1 <= N <= 1000. Each train car is numbered from 1 to N.
The train is moving right.
Railway sort only allows one operation: move any car to the end of the train.
The cost of such move is the number of cars that precede the car that is "shunted" out and reattached to the end of the train.
There will be 10 sets of data. Each set will contain two lines: number of cars and the train which is the permutation of cars.

Sample Input
5
3 5 1 4 2
10
2 4 6 8 10 1 3 5 7 9

Sample Input Explanation
Odd lines: number of cars.
Even lines: train containing the permutation of cars.
Note only 2 sets of sample data are shown here. Real test data will contain 10 sets of data.

Sample Output
12
67

########################################################################
############################ SOLUTION LOGIC ############################
The max numbered cart never needs to be moved since doing so will result in the need to reorder everything else.
Since we can pull any cart and move to left, we do not need to move cars that are already in order.
That is, cars that are already in ascending order up to the max numbered car, since we can pull cars in-between out and place at the end of the train.
After we find the lowest number that is in order, we loop from that number-1 to 1 to find where they are in the train and move to end of train. Sum their indices.

For example:
4 7 5 8 6 9 10 1 2 3
    Step 1: Find index of max.
        10 at index 6
    Step 2: Find the min value that does not need to be moved.
        index 6: 10, min = 10
        index 5:  9, min = 9
        index 4:  6, min = 9
        index 3:  8, min = 8
        index 2:  5, min = 8
        index 1:  7, min = 7
        index 0:  4, min = 7
    Step 3: min-1 will be the first car that needs to be placed at end of train.
        min = 6
    Step 4: Start looping from min to 1 to move trains to beginning, while summing indices (number of trains before a car is it index, thus, the cost of moving it).
        min = 6, index = 4, cost = 4, total =  4, order = 6 4 7 5 8 9 10 1 2 3
        min = 5, index = 3, cost = 4, total =  7, order = 5 6 4 7 8 9 10 1 2 3
        min = 4, index = 2, cost = 2, total =  9, order = 4 5 6 7 8 9 10 1 2 3
        min = 3, index = 9, cost = 9, total = 18, order = 3 4 5 6 7 8 9 10 1 2
        min = 2, index = 9, cost = 9, total = 27, order = 2 3 4 5 6 7 8 9 10 1
        min = 1, index = 9, cost = 9, total = 36, order = 1 2 3 4 5 6 7 8 9 10

Another method is to loop from the largest train to smallest train and if the current train index is greater than the next train index (i.e., smaller value train at higher position than larger value train)
then the smaller value train with the higher index (current train) needs to be place to the left side of the train list.
This method is similar in logic to the previous method because it also checks for the correct relative position from largest to smallest.
*/

/**
 * Program to find the minimum cost of sorting a list of numbers using "railway sort".
 * @author Vincent Zhang
 * @since 23 July 2021
 */
#include <iostream>
#include <vector>
#include <algorithm>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Agument vector, program name and command-line arguments
 * @return void
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    for(int t=0; t<10; t++)
    {
        // Store cars and find max index of cars.
        int maxIdx = -1;
        int max; std::cin >> max;
        std::vector<int> cars;
        for(int i=0; i<max; i++)
        {
            int car; std::cin >> car;
            cars.emplace_back(car);
            if(car == max)
                maxIdx = i;
        }

        // Find the value to start reordering from.
        for(int i=maxIdx-1; i>=0; i--)
            if(cars[i] == max-1)
                max--;

        // Find the total cost of reordering.
        int cost = 0;
        for(int i=max-1; i>0; i--)
        {
            int index = find(cars.begin(), cars.end(), i) - cars.begin();
            cost += index;
            cars.erase(cars.begin() + index);
            cars.insert(cars.begin(), i);
        }
        std::cout << cost << '\n';
    }
    
    return 0;
}