/*
-----------------------------------------------------------------------------------
---------------------------- BlueBook - Exact Divisors ----------------------------
Print all exact divisors of a number in any order. Includes 1 and N.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check every number from 1 to N. O(N) with loop.
*/

import java.util.Scanner;

/**
 * Program to find all exact divisors of a number.
 * @author Vincent Zhang
 * @since 17 August 2021
 */
public class ExactDivisors
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        for(int i=1; i<=n; i++)
        {
            if(n% i == 0)
                System.out.println(i);
        }
    }
}