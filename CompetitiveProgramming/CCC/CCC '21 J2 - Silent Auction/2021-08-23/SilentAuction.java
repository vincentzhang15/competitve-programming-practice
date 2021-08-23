/*
-------------------------------------------------------------------------------------
---------------------------- CCC '21 J2 - Silent Auction ----------------------------
Find the name of the first bidder with the highest price.

Sample Input 1
3
Ahmed
300
Suzanne
500
Ivona
450

Sample Output 1
Suzanne

Sample Input 2
2
Ijeoma
20
Goor
20

Sample Output 2
Ijeoma

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find the max price.
Find the first name with the max price.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Finds the first highest bidder.
 * @author Vincent Zhang
 * @since 23 August 2021
 */
public class SilentAuction
{
    static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Get next line of string input.
     * @return Next input line as string
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
     * Next line of int input.
     * @return Next integer line of input
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
        String mn = "";
        int mp = -1;
        for(int i=0, n=nextInt(); i<n; i++)
        {
            String cn = nextLine();
            int cp = nextInt();
            if(cp > mp)
            {
                mp = cp;
                mn = cn;
            }
        }
        System.out.println(mn);
    }
}