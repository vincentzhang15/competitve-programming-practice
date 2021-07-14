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

The following code implements Method 3: no prime check, loop from [2, n].
*/

import java.util.Scanner;

/**
 * Find the number of prime factors of a number. Note: a prime number itself is not a prime factor in the scope of this question.
 * @author Vincent Zhang
 * @since 14 July 2021
 */
public class FactorsNoPrimeCheck
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
            for(int j=2; j<=n; j++)
                // No need to check if prime because exhausive division ensures prime.
                while(n % j == 0)
                {
                    n /= j;
                    count++;
                }

            // The problem defines a prime itself with no prime factors.
            System.out.println(count == 1 ? 0 : count);
        }
        sc.close();
    }
}