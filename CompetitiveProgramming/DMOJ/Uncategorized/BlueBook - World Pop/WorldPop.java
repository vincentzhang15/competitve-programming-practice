/*
------------------------------------------------------------------------------
---------------------------- BlueBook - World Pop ----------------------------
World population increases p% every year. Population was n in year y.
Estimate popluation in final year.

Sample Input
1.6
1987
5000000000
2087

Sample Input Explanation
Line 1: r, growth rate.
Line 2: y, start years.
Line 3: n, population at start year.
Line 4: e, end year.

Sample Output
24453487116

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find n * (r/100+1)^(e-y) rounded to nearest integer.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to estimate population.
 * @author Vincent Zhang
 * @since 04 August 2021
 */
public class WorldPop
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Attempt to convert next input line to integer.
     * @return Integer value of the next input line
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
     * Attempt to convert next input line to long.
     * @return Long value of the next input line
     */
    static long nextLong()
    {
        try
        {
            return Long.parseLong(br.readLine());
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Attempt to convert next input line to double.
     * @return Double value of the next input line
     */
    static double nextDouble()
    {
        try
        {
            return Double.parseDouble(br.readLine());
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Attempt to close BufferedReader instance.
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
        double r = nextDouble();
        int s = nextInt();
        long p = nextLong();
        int e = nextInt();
        closeBr();

        System.out.println(Math.round(p * Math.pow(r/100.0+1, e-s)));
    }
}