/*
-------------------------------------------------------------------------------
---------------------------- BlueBook - Power Base ----------------------------
Given x, p, find "x" raised to the power "p" rounded to 2 decimal places.

Sample Input
3
2.0 4
4.0 2
3.0 3

Sample Output
16.00
16.00
27.00

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop and find power.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Evaluates an exponentiation.
 * @author Vincent Zhang
 * @since 26 August 2021
 */
public class PowerBase
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /**
     * Obtain next input token as string.
     * @return String value of next input token
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
     * Obtain int value of next token.
     * @return Int value of next input token
     */
    static int nextInt()
    {
        try
        {
            return Integer.parseInt(nextToken());
        }
        catch(NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        return -1;
    }

    /**
     * Obtain float value of next token.
     * @return Float value of next token.
     */
    static float nextFloat()
    {
        try
        {
            return Float.parseFloat(nextToken());
        }
        catch(NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        return -1;
    }    

    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        for(int i=0, n=nextInt(); i<n; i++)
        {
            float x = nextFloat();
            float p = nextFloat();
            System.out.format("%.2f%n", Math.pow(x, p));
        }
    }
}