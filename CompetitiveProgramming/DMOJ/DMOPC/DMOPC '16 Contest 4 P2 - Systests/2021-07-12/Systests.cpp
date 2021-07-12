/*
////////////////////////////////////////////////////////////////////////////////
//////////////////////////// KEY C++ SYNTAX SUMMARY ////////////////////////////
1. C++ Class Definition
    class Data
    {
        public:
        int a, b, p;
    };
    Data batches[n];
    for(int i=0; i<n; i++)
        cin >> batches[i].a >> batches[i].b >> batches[i].p;

    Data d;
    d.a = 1;
    d.b = 2;
    d.c = 3;

2. Sort Array
    sort(fails, fails + nFails);

3. lower_bound() & upper_bound()
    if(
        lower_bound(fails, fails + nFails, batch.a) == 
        upper_bound(fails, fails + nFails, batch.b)
    )

///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// DMOPC '16 Contest 4 P2 - Systests ////////////////////////////
A list of intervals each have an associated point value.
A list of integers have values such that if the value falls within an interval (including endpoints), the point value does not count.
Find the total number of points given these two lists.

Sample Input:
3
1 5 100
20 21 10
1 18 1
2
2
5

Sample Input Explanation:
Line 1: n, number of interval and point batches.
Line 2 to n+1: a b p, the lower, upper bound, and point value.
Line n+2: f, the number of integers in the second list.
Line n+3 to n+2+f: the integers that will devalue an interval.

Sample Output:
10

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Store the batches of interval and points.
Store the values that will cause an interval to lose its points.
Sort the latter list of values.
Loop through the batches of interval and points.
For every interval, find the binary search lower and upper bound in the latter list of values.
Compare the lower and upper bound.
Equal value means the interval is unaffected.
Sum the valid points.
*/

/**
 * Program to find the total points of a set of data according to rules.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
#include <bits/stdc++.h>
using namespace std;

/**
 * Class to store three values for easy access.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
class Data
{
    public:
    int a, b, p;
};

/**
 * Main method to solve the problem.
 * @return 0
 */
int main()
{
    // Speed up input.
    cin.sync_with_stdio(0);
    cin.tie(0);

    // Store the first list of data.
    int n; cin >> n;
    Data batches[n];
    for(int i=0; i<n; i++)
        cin >> batches[i].a >> batches[i].b >> batches[i].p;

    // Store the second list of data.
    int nFails; cin >> nFails;
    int fails[nFails];
    for(int i=0; i<nFails; i++)
        cin >> fails[i];
    
    // Sort the second list to perform the binary search lower and upper bound on.
    sort(fails, fails + nFails);

    // Process.
    int totalPoints = 0;
    for(Data batch : batches)
        // Check every interval in the list and if the interval is valid, add its points.
        if(lower_bound(fails, fails + nFails, batch.a) == upper_bound(fails, fails + nFails, batch.b))
            totalPoints += batch.p;

    // Output.
    cout << totalPoints << '\n';
}