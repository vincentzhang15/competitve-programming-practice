/*
----------------------------------------------------------------------------------------
---------------------------- BlueBook - 10 Primes on a Line ----------------------------
Print the first "m" (5 <= m <= 500) primes, 10 to a line, interspersed by spaces.

Sample Input
5

Sample Output
2 3 5 7 11

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Pre-compute primes with the Sieve of Eratosthenes algorithm:
    Every multiple of a prime is not prime.
    Start with 2, 2 is prime.
    Mark all multiples of 2 as not prime.
    The first of all subsequent primes are prime and all multiples of such numbers are composites.

--------------------------------------------------------------------------
---------------------------- Program Comments ----------------------------
Program to print the first "m" primes.
@author Vincent Zhang
@since 09 August 2021
*/

#include <iostream>
#include <cstring>

bool isPrime[5001];

/**
 * Pre-compute primes.
 * @return void
 */
void sieveEratosthenes()
{
    memset(isPrime, true, sizeof(isPrime));
    for(int i=2; i<5000; i++)
    {
        if(isPrime[i])
        {
            for(int j=2; i*j < 5000; j++)
            {
                isPrime[i*j] = false;
            }
        }
    }
}

/**
 * Solve the problem.
 * @return 0 Successful program termination
 */
int main()
{
    sieveEratosthenes();
    
    // Disable synchronization between C and c++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin straem from cout stream to disable automatic flushing after each IO operation on the other stream.
    std::cin.tie(nullptr);

    int n;
    std::cin >> n;

    for(int i=2, c=0; n; i++)
    {
        if(isPrime[i])
        {
            std::cout << i << " ";
            n--;
            c++;
        }
        if(c == 10)
        {
            std::cout << '\n';
            c = 0;
        }
    }

    return 0;
}