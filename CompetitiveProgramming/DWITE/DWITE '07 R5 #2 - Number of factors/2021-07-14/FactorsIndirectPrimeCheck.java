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

The following code implements Method 4: indirect prime check, loop from [2, sqrt(n)].
*/

import java.util.Scanner;

/**
 * Program finds the number of valid prime factors.
 * @author Vincent Zhang
 * @since 14 July 2021
 */
public class FactorsIndirectPrimeCheck
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

            // Create a copy to indirectly check for prime later.
            int copy, n;
            copy = n = sc.nextInt();

            // Check up to and including sqrt(n).
            for(int j=2; j<=Math.sqrt(n); j++)
                while(n % j == 0)
                {
                    n /= j;
                    count++;
                }
            
            // When "n" is not prime and not "1" at this point,
            // then there is one more prime factor > sqrt(n). Thus, add 1.
            if(n != copy && n != 1)
                count++;
            System.out.println(count);
        }
        sc.close();
    }
}