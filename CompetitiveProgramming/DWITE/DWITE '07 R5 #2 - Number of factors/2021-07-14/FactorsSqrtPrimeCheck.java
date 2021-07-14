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

import java.util.Scanner;

/**
 * Program finds the number of valid prime factors.
 * @author Vincent Zhang
 * @since 14 July 2021
 */
public class FactorsSqrtPrimeCheck
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++)
        {
            int count = 0;
            int n = sc.nextInt();

            // Find factors.
            for(int j=2; j <= n; j++)
            {
                // Check if "j" is prime.
                boolean isPrime = true;
                for(int k=2; k <= Math.sqrt(j); k++)
                    if(j % k == 0)
                    {
                        isPrime = false;
                        break;
                    }
                
                // If is prime and divisible then is factor. Divide fully.
                if(isPrime)
                    while(n % j == 0)
                    {
                        n /= j;
                        count++;
                    }
            }

            // A prime itself is not a prime factor within the scope of this problem.
            System.out.println(count == 1 ? 0 : count);
        }
        sc.close();        
    }
}