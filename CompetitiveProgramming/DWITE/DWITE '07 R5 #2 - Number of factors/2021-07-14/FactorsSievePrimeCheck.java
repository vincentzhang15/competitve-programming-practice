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

The following code implements Method 1: prime check with Sieve of Eratosthenes.
*/

import java.util.Scanner;
import java.util.Arrays;

/**
 * Find the number of prime "factors" of five integers.
 * @author Vincent Zhang
 * @since 14 July 2021
 */
public class FactorsSievePrimeCheck
{
    // Global declarations and initializations.
    private static final int MAX = 32;
    private static boolean[] isPrime = new boolean[MAX+1];
    
    /**
     * Compute the primes up to and including MAX using the Sieve of Eratosthenes algorithm.
     * @return void
     */
    private static void computePrimes()
    {
        Arrays.fill(isPrime, true);
        for(int i=2; i<=MAX/2; i++)
            if(isPrime[i])
                // Multiple of prime is not prime.
                for(int j=2; j<=MAX/i; j++)
                    isPrime[i*j] = false;
    }

    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        // Pre=compute primes.
        computePrimes();

        // Find factors.
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++)
        {
            int n = sc.nextInt();
            int count = 0;
            for(int j=2; j<=MAX; j++)
                // Fully divide every prime.
                if(isPrime[j])
                    while(n % j == 0)
                    {
                        n /= j;
                        count++;
                    }
            // A prime will have 1 prime factor: itself.
            // The question does not define a prime itself as a factor so output "0".
            System.out.println(count==1 ? 0 : count);
        }

        sc.close();
    }
}