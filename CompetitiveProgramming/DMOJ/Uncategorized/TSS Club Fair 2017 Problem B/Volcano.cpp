/*
////////////////////////////////////////////////////////////////////////
//////////////////////////// SYNTAX SUMMARY ////////////////////////////
1. C++ upper_bound()
    upper_bound() returns an iterator pointing at the first element greater than the target value in the range [start, end).
    Subtract the array to get the index:
        int index = upper_bound(houses, houses+n, r*r)-houses

//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// TSS Club Fair 2017 Problem B ////////////////////////////
A volcano may erupt. Find how many houses will be destroyed in a list of radii.

Sample Input
4 3
2 2
-4 0
0 -5
-5 -5
2
4
6

Sample Input Explanation
Line 1: n q, number of houses, number of radii to check.
Line 2 to n+1: dx dy, house relative position to volcano.
Line n+1+1 to n+1+q: radii to check for number of houses in range.

Sample Output
0
2
3

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Process the house relative position. Store the house distance to volcano squared.
Sort the array of house distances squared.
Find the upper bound of each radii squared in the houses array.
*/

/**
 * Program to find the number of coordinates within radii.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
#include <iostream> // Cin/cout.
#include <algorithm> // sort(), upper_bound().
using namespace std;

// Use long long to store as squaring a million will not fit in int.
typedef long long ll;

/**
 * Main function to solve the problem.
 * @return 0
 */
int main()
{
    // Fast input.
    cin.sync_with_stdio(0);
    cin.tie(0);

    // Get quantities.
    ll n, q; cin >> n >> q;

    // Convert house relative position --> distance to volcano square --> store.
    ll houses[n];
    for(int i=0; i<n; i++)
    {
        ll dx, dy; cin >> dx >> dy;
        // Store radius squared so sqrt() and ceil() are not necessary.
        ll rs = dx*dx + dy*dy;
        houses[i] = rs;
    }

    // Sort for binary search upper_bound().
    sort(houses, houses+n);

    // Loop through radii.
    for(int i=0; i<q; i++)
    {
        ll r; cin >> r;
        // Index starts from 0 so the index will be the number of houses.
        cout << upper_bound(houses, houses+n, r*r)-houses << '\n';
    }

    return 0;
}