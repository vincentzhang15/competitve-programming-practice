/*
####################################################################################
############################ CCC '21 S1 - Crazy Fencing ############################
Find the area of a fence made of trapezoid wood pieces where adjacent wood edge heights are equal.

Sample Input 1
3
2 3 6 2
4 1 1

Sample Input 1 Explanation
L1: n, number of wood pieces.
L2: h1...hn+1, left and right heights of wood pieces.
L3: w1...wn, width of wood pieces.

Sample Output 1
18.5

Sample Input 2
4
6 4 9 7 3
5 2 4 1

Sample Output 2
75

########################################################################
############################ SOLUTION LOGIC ############################
Visualizing sample input 1:
              6
              |
              |
          3   |
2         |   |   2
|         |   |   |
| _ _ _ _ | _ | _ |
     4      1   1

Sum the trapezoid areas.
Sum = i=0 Σ n-1 ( w_i + w_i+1 ) * h_i / 2
Sum = 0.5 * ( i=0 Σ n-1 ( w_i + w_i+1 ) * h_i )

i.e., divide by two last since (with Input 1):
(2+3)*4/2 + (3+6)*1/2 + (6+2)*1/2
= (1/2) * [(2+3)*4 + (3+6)*1 + (6+2)*1]

In general this solution process involves 2 steps:
    Step 1: sum of (w_i + w_i+1) * h_i.
        Method 1: loop.
        Method 2:
            Step 1: Add all heights without first element with all heights without last element.
            Step 2: Multiply result by all widths.
            Step 3: Apply sum function.
            Useful for solving with Haskell.
    Step 2: divide sum by 2.
        Note: C++ will convert to scientific notation when a 7-digit number is divided by 2.0.
        Method 1: direct division.
        Method 2: int division/truncate/bitshift and check parity.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Program to find the area of a fence.
 * @author Vincent Zhang
 * @since 27 July 2021
 */
public class CrazyFencing
{
    // Global declarations.
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        // Get heights and widths.
        int n = nextTokenInt();
        int[] h = new int[n+1];
        int[] w = new int[n];
        for(int i=0; i<=n; i++)
        {
            h[i] = nextTokenInt();
        }
        for(int i=0; i<n; i++)
        {
            w[i] = nextTokenInt();
        }

        // Find area * 2 and output area.
        int areaTimes2 = 0;
        for(int i=0; i<n; i++)
        {
            areaTimes2 += (h[i] + h[i+1]) * w[i];
        }
        System.out.println(areaTimes2 / 2.0);
    }

    /**
     * Obtain the next string token.
     * @return The next token in type string
     */
    static String nextTokenStr()
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
     * Obtain the next integer token.
     * @return The next token in type integer
     */
    static int nextTokenInt()
    {
        int n = -1;
        try
        {
            n = Integer.parseInt(nextTokenStr());
        }
        catch(NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        return n;
    }

}