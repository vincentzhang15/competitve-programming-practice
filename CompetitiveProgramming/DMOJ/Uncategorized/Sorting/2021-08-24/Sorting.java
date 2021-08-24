/*
-----------------------------------------------------------------
---------------------------- Sorting ----------------------------
Sort a list <=100 of integers <= 32000 in ascending order.

Sample Input
4
4
3
2
1

Sample Output
1
2
3
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built in sorting method.
Or write own sorting method.
O(N^2) selection sort will work.
*/

import java.util.Scanner;
import java.util.Arrays;

/**
 * Sorts a list of integers.
 * @author Vincent Zhang
 * @since 24 August 2021
 */
public class Sorting
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
        for(int i=0; i<n; i++)
        {
            System.out.println(data[i]);
        }
    }
}