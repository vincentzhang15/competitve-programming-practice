/*
-----------------------------------------------------------------------------
---------------------------- BlueBook - Interest ----------------------------
Find the account value for every year from 0 to "Y".
Interest is paid annually at the end of each year.
Interest rate is "M"%.
Principal amount is "N".
Input contains one line:
N M Y
Round answer to two decimal places.

Sample Input 1
1000 8 3

Sample Output 1
0 1000.00
1 1080.00
2 1166.40
3 1259.71

Sample Input 2
20 8 0

Sample Output 2
0 20.00

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
y0 = principal
y1 = y0*(1+ r/100)
y2 = y1*(1+ r/100)
   = y0*(1+ r/100)^2
Thus, find:
    y0*(1+ r/100)^year
*/

import java.util.Scanner;

/**
 * Calculates account value for every year.
 * @author Vincent Zhang
 * @since 27 August 2021
 */
public class Interest
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return 0
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double y = sc.nextDouble();
        double r = sc.nextDouble();
        int years = sc.nextInt();
        sc.close();

        for(int i=0; i<= years; i++)
        {
            System.out.format("%d %.2f\n", i, y*Math.pow(1+r/100, i));
        }
    }
}