/*
------------------------------------------------------------------------------------------
-------------------------------- BlueBook - Pop Explosion --------------------------------
Population increases rate "r" percent each year.
Population in starting year "s" is "A".
Find year "e" in which population reaches "e".

Sample Input
5.5 24000000 1980 100000000

Sample Input Explanation
r A s B

Sample Output
2007

--------------------------------------------------------------------------------
-------------------------------- SOLUTION LOGIC --------------------------------
Rearrage population projection for ending year.
B = A * (r/100+1) ^ (e-s)
ln(B/A) = (e-s) ln(r/100+1)
e = ln(B/A)/ln(r/100+1) + s
e = log_(r/100+1)(B/A) + s (if language supports log base)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Program to find the year of a population projection.
 * @author Vincent Zhang
 * @since 07 August 2021
 */
public class PopExplosion
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /**
     * Return next token in string input.
     * @return Next input token
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
     * Next input token in double value.
     * @return Double value of input token
     */
    static double nextDouble()
    {
        try
        {
            return Double.parseDouble(nextToken());
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
        double r = nextDouble();
        double a = nextDouble();
        double s = nextDouble();
        double b = nextDouble();
        double e = Math.log(b/a)/Math.log(r/100+1) + s;
        System.out.println(Math.round(e));
    }
}