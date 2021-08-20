/*
-----------------------------------------------------------------------------------
---------------------------- CCC '13 J1 - Next in line ----------------------------
Three children's age form an arithemtic sequence.
Given the ages of the youngest and middle child, find the age of the oldest.

Sample Input
12
15

Sample Output
18

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Let "a", "b", "c" be ages of the youngest, middle, and oldest child respectively.
c - b = b - a
c = b - a + b
*/

import java.util.Scanner;

/**
 * Program to find the age of the oldest child given the ages of the youngest and middle child.
 * @author Vincent Zhang
 * @since 20 August 2021
 */
public class NextInLine
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
        sc.close();

        System.out.println(b - a + b);

    }
}