/*
-------------------------------------------------------------------------------
---------------------------- BlueBook - Lower Case ----------------------------
Convert given strings to lowercase.

Sample Input
2
abCDefg
WEEEIPWNNOOBS~~?~?~??@#!#$%?$^?$%*

Sample Output
abcdefg
weeeipwnnoobs~~?~?~??@#~#$%?$^?$%*

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in lower case functions or loop through characters and check if uppercase.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to convert strings to lowercase.
 * @author Vincent Zhang
 * @since 19 August 2021
 */
public class LowerCase
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Read next input line as string.
     * @return String value of the next input line
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
     * Read next input line as int.
     * @return Integer value of next input line
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
        return -1;
    }

    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        for(int i=0, n=nextInt(); i < n; i++)
            System.out.println(nextLine().toLowerCase());
    }
}