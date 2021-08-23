/*
-------------------------------------------------------------------------------------
---------------------------- CCC '21 J2 - Silent Auction ----------------------------
Find the name of the first bidder with the highest price.

Sample Input 1
3
Ahmed
300
Suzanne
500
Ivona
450

Sample Output 1
Suzanne

Sample Input 2
2
Ijeoma
20
Goor
20

Sample Output 2
Ijeoma

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find the max price.
Find the first name with the max price.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the first highest bidder.
@author Vincent Zhang
@since 23 August 2021
*/

#include <iostream>

int n;
int cp, mp = -1;
std::string cn, mn;

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    std::cin >> n;
    for(int i=0; i<n; i++)
    {
        std::cin >> cn >> cp;
        if(cp > mp)
        {
            mp = cp;
            mn = cn;
        }
    }
    std::cout << mn << '\n';

    return 0;
}