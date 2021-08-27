/*
-----------------------------------------------------------------------------
---------------------------- BlueBook - Equation ----------------------------
Solve for x: ax + b = 0, given real coefficients "a" and "b".
Print answer to two decimal places.
0/0 is indeterminate. k/0 is undefined.

Sample Input 1
10
5

Sample Output 1
-0.50

Sample Input 2
13.5555
1.244685

Sample Output 2
-0.09

Sample Input 3
0
0

Sample Output 3
indeterminate

Sample Input 4
0
4

Sample Output 4
undefined

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find -b/a.

if a == 0 and b == 0:
    indeterminate
else if a == 0
    indeterminate
else
    -b/a
*/

import java.util.Scanner;

/**
 * Solves for x in ax+b=0 given "a" and "b".
 * @author Vincent Zhang
 * @since 27 August 2021
 */
public class Equation
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        sc.close();

        if(a == 0 && b == 0)
        {
            System.out.println("indeterminate");
        }
        else if(a == 0)
        {
            System.out.println("undefined");
        }
        else
        {
            System.out.format("%.2f%n", ((-1)*b/a));
        }
    }
}