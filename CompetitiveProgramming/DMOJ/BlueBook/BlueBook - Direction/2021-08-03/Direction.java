/*
------------------------------------------------------------------------------
---------------------------- BlueBook - Direction ----------------------------
Given a direction in integer degrees N. 0 ≤ N < 360.
Print the closest cardinal direction.
Ties are broken by smaller directions.
Direction in increasing size are N, E, S, W.
I.e., choose N over E when deg <= 45
             N over W when deg >= 315

Sample Input
2
45
180

Sample Input Explanation
Line 1: T, number of tasks.
Line 2 to T+1: degrees.

Sample Output
N
S

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process conditions.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Program to print the closest cardinal direction.
 * @author Vincent Zhang
 * @since 03 August 2021
 */
public class Direction
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /**
     * Main method to solve the problem.
     * @parma args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        int n = nextInt();
        for(int i=0; i<n; i++)
        {
            int d = nextInt();
            if(d <= 45 || d >= 315)
                System.out.println("N");
            else if(d <= 135)
                System.out.println("E");
            else if(d <= 225)
                System.out.println("S");
            else
                System.out.println("W");
        }
    }

    /**
     * Return the next input string token.
     * @return Input line token
     */
    static String nextToken()
    {
        while(st == null || !st.hasMoreTokens())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        return st.nextToken();
    }

    /**
     * Return next input string token as int
     * @return Next integer token
     */
    static Integer nextInt()
    {
        int n = -1;
        try
        {
            n = Integer.parseInt(nextToken());
        }
        catch(NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        return n;
    }

}