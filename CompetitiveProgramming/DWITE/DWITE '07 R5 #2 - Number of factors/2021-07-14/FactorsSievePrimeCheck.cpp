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

The following code implements Method 1: prime check with Sieve of Eratosthenes algorithm.
*/

/**
 * Program find the number of valid prime factors.
 * @author Vincent Zhang
 * @since 14 July 2021
 */
#include <iostream>
#include <cstring>
using namespace std;

/**
 * Main function to solve the problem.
 * @return 0
 */
int main()
{
    const int MAX = 32;
    int isPrime[32+1];

    // Pre-compute primes up to max using Sieve of Eratosthenes algorithm.
    memset(isPrime, true, sizeof(isPrime));
    for(int i=2; i<=MAX/2; i++)
        if(isPrime[i])
            // Multiples of prime is not prime.
            for(int j=2; j<=MAX/i; j++)
                isPrime[i*j] = false;

    // Answer the question.
    for(int i=0; i<5; i++)
    {
        int count = 0;
        int n; cin >> n;

        for(int j=2; j<=n; j++)
            // Fully divide all prime factors.
            if(isPrime[j])
                while(n % j == 0)
                {
                    n /= j;
                    count++;
                }

        // This problem defines prime numbers itself as not a prime factor.
        cout << (count == 1 ? 0 : count) << '\n';
    }

    return 0;
}