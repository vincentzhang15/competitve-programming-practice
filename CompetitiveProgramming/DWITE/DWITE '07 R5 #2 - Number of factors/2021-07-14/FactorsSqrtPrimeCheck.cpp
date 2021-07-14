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

The following code implements Method 2: prime check with square root.
*/

/**
 * Program finds the number of valid prime factors.
 * @author Vincent Zhang
 * @since 14 July 2021
 */
#include <iostream>
#include <math.h>
using namespace std;

/**
 * Main method to solve the problem.
 * @return 0
 */
int main()
{
    for(int i=0; i<5; i++)
    {
        int count = 0;
        int n; cin >>n;

        // Find factors.
        for(int j=2; j<= n; j++)
        {
            // Check if potential factor is prime.
            bool isPrime = true;
            for(int k=2; k<=sqrt(j); k++)
                if(j % k == 0)
                {
                    isPrime = false;
                    break;
                }
            
            // If is prime, check divisibility, and fully divide if possible.
            if(isPrime)
                while(n % j == 0)
                {
                    n /= j;
                    count++;
                }
        }

        // The problem defines a prime itself as not a prime factor.
        cout << (count == 1 ? 0 : count) << '\n';
    }

    return 0;
}