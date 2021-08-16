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
@context Self-Learning C
*/

#include <stdio.h>

/**
 * Solves the problem.
 * @return 0 Successful program termination
 */
int main()
{
    int n;
    scanf("%d", &n);

    int isPrime[n+1];
    for(int i=0; i<n+1; i++)
        isPrime[i] = 1;
    isPrime[1] = 0;

    for(int i=2; i<n; i++)
    {
        if(isPrime[i])
            for(int j=2; i*j <= n; j++)
            {
                isPrime[i*j] = 0;
            }
    }

    for(int i=1; i<=n; i++)
    {
        printf("%d\n", isPrime[i]);
    }

    return 0;
}