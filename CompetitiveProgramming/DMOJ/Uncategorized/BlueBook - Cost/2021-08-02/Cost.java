/*
-------------------------------------------------------------------------
---------------------------- BlueBook - Cost ----------------------------
Determine the cost to mail a letter based on weight.

"
 0 ≤ N ≤ 30 costs 38 cents
30 < N ≤ 50 costs 55 cents
50 < N ≤ 100 costs 73 cents
if N > 100 then the base cost is 73 cents, plus 24 cents for every additional 50 grams or part thereof.
"

Sample Input
2
5
101

Sample Input Explanation
Line 1: number of tasks.
Line 2 to n+1: tasks.

Sample Output
38
97

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process each condition.
*/

import java.util.Scanner;

/**
 * Program to find mailling cost.
 * @author Vincent Zhang
 * @since 02 August 2021
 */
public class Cost
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++)
        {
            int c = sc.nextInt();
            if(c <= 30) System.out.println(38);
            else if(c <= 50) System.out.println(55);
            else if(c <= 100) System.out.println(73);
            else System.out.println(73 + 24*(int)Math.ceil((c-100) /50.0));
        }
        sc.close();
    }
}