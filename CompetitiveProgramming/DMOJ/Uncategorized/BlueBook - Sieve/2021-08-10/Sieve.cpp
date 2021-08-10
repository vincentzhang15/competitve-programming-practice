/*
--------------------------------------------------------------------------
---------------------------- BlueBook - Sieve ----------------------------
For the first "N" numbers (1 <= n <= 500), print whether it is prime
denoted by "0" or "1", using the Sieve of Eratosthenes algorithm.

Sample Input
9

Sample Output
0
1
1
0
1
0
1
0
0

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Direct implementation.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to implement the Sieve of Eratosthenes algorithm.
@author Vincent Zhang
@since 10 August 2021
*/

#include <iostream>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    // Disable synchronization between C and C++ standard streams, allowing c++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int n;
    std::cin >> n;

    int isPrime[n+1];
    for(int i=0; i<n+1; i++)
        isPrime[i] = 1;
    isPrime[1] = 0;

    for(int i=2; i<=n; i++)
    {
        if(isPrime[i])
            for(int j=2; i*j <= n; j++)
            {
                isPrime[i*j] = 0;
            }
    }

    for(int i=1; i<=n; i++)
    {
        std::cout << isPrime[i] << '\n';
    }

    return 0;
}