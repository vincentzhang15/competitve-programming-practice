/*
-----------------------------------------------------------------------------------------
---------------------------- CCC '17 J1 - Quadrant Selection ----------------------------
Determine the quadrant in which a pair of non-zero integral coordinates lie.

Sample Input 1
12
5

Sample Output 1
1

Sample Input 2
9
-13

Sample Output 2
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check half of coordinate plane, e.g., upper half, when y > 0: x > 0, x < 0.
Only 2 cases remain, both y < 0:
    Check x < 0
    Else
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to identify the quadrant of a pair of coordinates.
 * @author Vincent Zhang
 * @since 21 August 2021
 */
public class QuadrantSelection
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Take next input line as string.
     * @return String value of next input line
     */
    static String nextLine()
    {
        try
        {
            return br.readLine();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return null;
    }

    /**
     * Take int value of next input line.
     * @return Int value of next input line
     */
    static int nextInt()
    {
        try
        {
            return Integer.parseInt(nextLine());
        }
        catch(NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        return 0;
    }

    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        int x = nextInt();
        int y = nextInt();

        if(y > 0)
        {
            if(x > 0) System.out.println(1);
            else System.out.println(2);
        }
        else
        {
            if(x < 0) System.out.println(3);
            else System.out.println(4);
        }
    }
}