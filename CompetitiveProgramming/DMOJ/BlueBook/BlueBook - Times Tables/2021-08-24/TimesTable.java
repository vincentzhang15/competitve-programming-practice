/*
---------------------------------------------------------------------------------
---------------------------- BlueBook - Times Tables ----------------------------
Create a times table for "n" from 1 to n.

Sample Input
5

Sample Output
5 X 1 = 5
5 X 2 = 10
5 X 3 = 15
5 X 4 = 20
5 X 5 = 25

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop from 1 to n and multiply.
*/

import java.util.Scanner;

/**
 * Creates a column in a times table.
 * @author Vincent Zhang
 * @since 24 August 2021
 */
public class TimesTable
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
        for(int i=1; i<= n; i++)
        {
            System.out.println(n + " X " + i + " = " + n*i);
        }
    }
}