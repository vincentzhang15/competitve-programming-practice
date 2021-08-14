/*
-------------------------------------------------------------------------------------------------
---------------------------- DWITE '09 R6 #2 - Round to power of two ----------------------------
Find the closest power of 2 for each of the 5 lines of input.
If a number is equally close to two powers of two, print the greater value.

Sample Input
0
1
2
3
5

Sample Output
1
1
2
4
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
2^x = y
x ln 2 = ln y
x = log_2(y)
lo = floor x
hi = lo + 1
Find closest.
Ensure to set log 0 to 0 as it is mathematically undefined.
*/

import java.util.Scanner;

/**
 * Finds the closest power of 2.
 * @author Vincent Zhang
 * @since 14 August 2021
 */
public class RoundToPowerOfTwo
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5; i++)
        {
            int x = sc.nextInt();
            
            int lo = x == 0 ? 0 : (int)(Math.log(x) / Math.log(2));
            int hi = lo + 1;

            double dLo = Math.abs(Math.pow(2, lo) - x);
            double dHi = Math.abs(Math.pow(2, hi) - x);

            if(dLo < dHi)
                System.out.println((int)Math.pow(2, lo));
            else
                System.out.println((int)Math.pow(2, hi));
        }
        sc.close();
    }
}