/*
--------------------------------------------------------------------------------
---------------------------- BlueBook - Powers of 2 ----------------------------
Find smallest power of two >= input integer.

Sample Input
200

Sample Output

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
log_2(input) yields the exponent to raise 2 to, to get "input".
Because:
    log_2(input) = a <==> 2^a = input
Thus, the smallest power of 2 >= input is the ceiling of log_2().
*/

import java.util.Scanner;

/**
 * Program to find the smallest power of 2 >= input integer.
 * @author Vincent Zhang
 * @since 05 August 2021
 */
public class PowerOfTwo
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
        System.out.println((int)Math.ceil(Math.log(n)/Math.log(2)));
        sc.close();
    }
}