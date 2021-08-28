/*
----------------------------------------------------------------------
---------------------------- List Minimum ----------------------------
Given a list of numbers, remove the minimum from the list until the list is empty.

Sample Input
3
5
8
2

Sample Output
2
5
8

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Problem description is the definition of selection sort in ascending order.
Therefore, it sufices to sort with built-in function if avaiable.
*/

import java.util.Scanner;
import java.util.Arrays;

/**
 * Outputs a list of numbers in ascending order.
 * @author Vincent Zhang
 * @since 28 August 2021
 */
public class ListMinimum
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
        int[] data = new int[n];
        for(int i=0; i<n; i++)
        {
            data[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(data);
        for(int v : data)
        {
            System.out.println(v);
        }
    }
}