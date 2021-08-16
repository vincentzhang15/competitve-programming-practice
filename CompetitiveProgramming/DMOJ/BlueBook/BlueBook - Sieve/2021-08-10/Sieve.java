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
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to implement the Sieve of Eratosthenes algorithm.
 * @author Vincent Zhang
 * @since 10 August 2021
 */
public class Sieve
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = -1;
        try
        {
            n = Integer.parseInt(br.readLine());
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }

        int[] isPrime = new int[n+1];
        for(int i=2; i<n+1; i++)
            isPrime[i] = 1;
        
        for(int i=2; i<=n; i++)
        {
            for(int j=2; i*j<=n; j++)
            {
                isPrime[i*j] = 0;
            }
        }

        for(int i=1; i<=n; i++)
        {
            System.out.println(isPrime[i]);
        }
    }
}