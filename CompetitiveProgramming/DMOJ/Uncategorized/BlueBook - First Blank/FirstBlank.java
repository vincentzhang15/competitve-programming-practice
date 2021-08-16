/*
--------------------------------------------------------------------------------
---------------------------- BlueBook - First Blank ----------------------------
Find the position of the first occurance of a space. Output 0 if there are no spaces in a line.

Sample Input
2
 2
22

Sample Input Explanation
Line 1: n, number of strings.
Line 2 to n+1: strings to find the position of the first space.

Sample Output
1
0

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
For languages whose built index function returns -1, one can directly output the returned value + 1.
Extra processing required for languages that do not always return integers, e.g., Haskell.
Alternatively, use a for loop through the strings.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to find the first position of a space.
 * @author Vincent Zhang
 * @since 16 August 2021
 */
public class FirstBlank
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Read the next input line.
     * @return String value of the next input line
     */
    static String readLine()
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
     * Read the next input line as int.
     * @return Integer value of next input line
     */
    static int nextInt()
    {
        try
        {
            return Integer.parseInt(readLine());
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
            System.out.println(readLine().indexOf(' ')+1);
    }
}