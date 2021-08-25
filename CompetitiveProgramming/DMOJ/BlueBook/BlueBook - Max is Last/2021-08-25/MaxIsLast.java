/*
--------------------------------------------------------------------------------
---------------------------- BlueBook - Max is Last ----------------------------
Given a list of numbers, print the max value last.

Sample Input
4
3
2.7
5.12
-0.63

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: list of numbers.

Sample Output
3.00
2.70
-0.63
5.12

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find max, print the rest without max, print max.
E.g., by creating new list without max, iterating through list and not printing max.
*/

import java.util.Scanner;

/**
 * Prints a list with the maxiumum value last.
 * @author Vincent Zhang
 * @since 25 August 2021
 */
public class MaxIsLast
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
        float max = Integer.MIN_VALUE;
        float[] nums = new float[n];
        for(int i=0; i<n; i++)
        {
            nums[i] = sc.nextFloat();
            if(nums[i] > max)
                max = nums[i];
        }
        sc.close();

        for(int i=0; i<n; i++)
        {
            if(nums[i] != max)
                System.out.format("%.2f%n", nums[i]);
        }
        System.out.format("%.2f%n", max);
    }
}