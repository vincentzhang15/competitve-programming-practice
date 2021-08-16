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
@context Self-Learning C
*/

#include <stdio.h>
#include <string.h>

int isPrime[5001];

/**
 * Determine if the first 5000 numbers are prime.
 * @return void
 */
void sieveEratosthenes()
{
    memset(isPrime, 1, sizeof(isPrime));
    for(int i=2; i<5000; i++)
        if(isPrime[i])
            for(int j=2; i*j<5000; j++)
                isPrime[i*j] = 0;
}

/**
 * Solves the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful program termination
 */
int main(int argc, char *argv[])
{
    sieveEratosthenes();

    int n;
    scanf("%d", &n);

    for(int i=2, c=0; n; i++)
    {
        if(isPrime[i])
        {
            printf("%d ", i);
            n--;
            c++;
        }
        if(c == 10)
        {
            printf("\n");
            c = 0;
        }
    }

    return 0;
}