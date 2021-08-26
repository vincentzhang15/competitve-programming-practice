/*
------------------------------------------------------------------------------
---------------------------- BlueBook - Leap Year ----------------------------
Identify if a year is leap year. Year 0 is leap year.
A year is a leap year if the number of divisible by 4 and not 100 or 400.

Sample Input
4
0
4
100
400

Sample Output
1
1
0
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
return y % 4 == 0 and y % 100 != 0 or y % 400 == 0
*/

import java.util.Scanner;

/**
 * Identifies whether a year is a leap year.
 * @author Vincent Zhang
 * @since 26 August 2021
 */
public class LeapYear
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
        for(int i=0; i<n; i++)
        {
            int x = sc.nextInt();
            System.out.println(x%4==0 && x%100!=0 || x%400 == 0 ? 1 : 0);
        }
        sc.close();
    }
}