/*
-----------------------------------------------------------------------------
---------------------------- List Minimum (Easy) ----------------------------
"Given a permutation of the integers 1 , 2 , … , N, output the permutation after it has been sorted."
Output "The sorted permutation on a single line."

Sample Input
3
2 1 3

Sample Output
1 2 3

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Notice the permutation of integers forms an arithmetic sequence with a common difference of 1.
Thus, output 1, 2...N.
*/

import java.util.Scanner;

/**
 * Prints the sorted permutation of a list of integers.
 * @author Vincent Zhang
 * @since 28 August 2021
 */
public class ListMinimumEasy
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int i=1, n=sc.nextInt(); i<=n; i++)
            System.out.print(i + " ");
        sc.close();
    }
}