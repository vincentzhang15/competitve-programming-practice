/*
------------------------------------------------------------------------------------------
---------------------------- CCC '21 J3 - Secret Instructions ----------------------------
Determine the direction of travel and number of steps given 5-digit numbers, e.g., 12345.

First two digits represent direction of turn.
    Sum odd: left
    Sum even: right
    Sum zero: previous direction
Last three digits is number of steps.
"99999": end program.

Sample Input
57234
00907
34100
99999

Sample Output
right 234
right 907
left 100

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Take input as string and extract first two digits.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to determine directions.
 * @author Vincent Zhang
 * @since 15 August 2021
 */
public class SecretInstructions
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Return input line as string.
     * @return String value of input line
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
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        String p = "";
        while(true)
        {
            String line = readLine();

            if(line.equals("99999"))
                break;

            int sum = (int)(line.charAt(0)-'0') + (int)(line.charAt(1)-'0');
            if(sum == 0)
                System.out.print(p);
            else if(sum % 2 == 0)
                System.out.print( (p="right") );
            else
                System.out.print( (p="left") );
            System.out.println(" " + line.substring(2, 5));

        }
    }
}