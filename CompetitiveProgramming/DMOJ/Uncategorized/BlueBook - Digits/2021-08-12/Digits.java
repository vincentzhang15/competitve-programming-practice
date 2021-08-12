/*
---------------------------------------------------------------------------
---------------------------- BlueBook - Digits ----------------------------
Find number of digits of each number. Negative sign is not a digit.

Sample Input
4
123
1
-12
0

Sample Input Explanation
Line 1: n, number of numbers.
Line 2 to n+1: numbers.

Sample Output
3
1
2
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find absolute value of every number then its string length.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Finds the number of digits in a list of numbers.
 * @author Vincent Zhang
 * @since 12 August 2021
 */
public class Digits
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = -1;
        try
        {
            n = Integer.parseInt(br.readLine());
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        for(int i=0; i<n; i++)
        {
            int x = -1;
            try
            {
                x = Integer.parseInt(br.readLine());
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
            System.out.println((Math.abs(x) + "").length());
        }
    }
}