/*
--------------------------------------------------------------------------------------
---------------------------- BlueBook - Column of Numbers ----------------------------
Prints a string of digits in reverse order, column-wise.

Sample Input
3467

Sample Output
7
6
4
3

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Reverse print.
*/

import java.util.Scanner;

/**
 * Reverses a list of digits.
 * @author Vincent Zhang
 * @since 25 August 2021
 */
public class ColumnOfNumbers
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        sc.close();

        for(int i=line.length()-1; i>=0; i--)
        {
            System.out.println(line.charAt(i));
        }
    }
}