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
*/

import java.util.Scanner;

/**
 * Program to print the first "m" primes.
 * @author Vincent Zhang
 * @since 09 August 2021
 */
public class PrimesOnLine
{
    static boolean[] notPrime = new boolean[5001];

    /**
     * Pre-compute primes.
     * @return void
     */
    static void sieveEratosthenes()
    {
        for(int i=2; i<5000; i++)
        {
            if(!notPrime[i])
            {
                for(int j=2; i*j < 5000; j++)
                {
                    notPrime[i*j] = true;
                }
            }
        }
    }

    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        sieveEratosthenes();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for(int i=2, c=0; n>0; i++)
        {
            if(!notPrime[i])
            {
                System.out.print(i + " ");
                n--;
                c++;
            }
            if(c == 10)
            {
                System.out.println();
                c = 0;
            }
        }
    }
}