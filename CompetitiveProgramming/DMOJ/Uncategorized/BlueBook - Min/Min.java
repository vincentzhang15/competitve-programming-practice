/*
------------------------------------------------------------------------
---------------------------- BlueBook - Min ----------------------------
Find the min of a list of real numbers.
1 <= Size of list <= 10 000
-1000 < Size of numbers < 1000
Output answer to two decimal places.

Sample Input
2
10.1
12.3

Sample Output
10.10

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in min function or loop through list.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Finds the min of a list of real numbers.
 * @author Vincent Zhang
 * @since 11 August 2021
 */
public class Min
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Attempt to return next input line as integer.
     * @return next integer input line
     */
    static int nextInt()
    {
        try
        {
            return Integer.parseInt(br.readLine());
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Attempt to return next input line as float.
     * @return float input line
     */
    static float nextFloat()
    {
        try
        {
            return Float.parseFloat(br.readLine());

        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Close BufferedReader.
     * @return void
     */
    static void closeBr()
    {
        try
        {
            br.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        int n = nextInt();
        float min = 100000;
        for(int i=0; i<n; i++)
        {
            float f = nextFloat();
            if(min > f)
            {
                min = f;
            }
        }
        closeBr();
        System.out.printf("%.2f%n", min);

    }
}