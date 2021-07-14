/*
/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// DWITE '07 R5 #2 - Number of factors ////////////////////////////
Find the number of prime factors. A prime number itself has no factors defined within the scope of this problem.

Sample Input
3
4
5
12
32

Sample Input Explanation
Line 1 to 5: n, 2 <= n <= 32.

Sample Output
0
2
0
3
5

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
See FactorsSievePrimeCheck.py for details.

The following code implements Method 4: indirect prime check, loop from [2, int(sqrt(n))].
*/

/**
 * Program finds the number of valid prime factors.
 * @author Vincent Zhang
 * @since 14 July 2021
 */
#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    for(int i=0; i<5; i++)
    {
        int count = 0;

        // Create a copy to indirectly check for prime later.
        int n, copy; cin >> n; copy = n;

        // Find factors.
        for(int j=2; j<=sqrt(n); j++)
            while(n % j == 0)
            {
                n /= j;
                count++;
            }
        
        // If not prime: a prime > sqrt(n) will remain the same as input.
        // A prime <= sqrt(n) will be 1.
        // A composite with all prime factors < sqrt(n) will be 1.
        // This leaves composites with a prime factor > sqrt(n).
        // There will be at most 1 prime factor > sqrt(n). See Proof 1 in FactorsSievePrimeCheck.py for more details.
        if(n != copy && n != 1)
            count++;
        
        // Output.
        cout << count << '\n';
    }

    return 0;
}