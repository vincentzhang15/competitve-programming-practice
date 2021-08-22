/*
--------------------------------------------------------------------------------------------
---------------------------- CCC '07 J1 - Who is in the Middle? ----------------------------
Find the middle number of three numbers.

Sample Input
10
5
8

Sample Output
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
One way is to sort the list and output list[1].
Another way is to subtract max and min from the trio sum.
*/

import java.util.Scanner;

/**
 * Finds the middle number in three numbers.
 * @author Vincent Zhang
 * @since 22 August 2021
 */
public class WhoInMiddle
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        System.out.println(a+b+c-Math.min(a, Math.min(b, c))- Math.max(a, Math.max(b, c)));
    }
}