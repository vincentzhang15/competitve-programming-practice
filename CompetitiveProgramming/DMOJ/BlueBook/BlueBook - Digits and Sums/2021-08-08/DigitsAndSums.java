/*
------------------------------------------------------------------------------------
---------------------------- BlueBook - Digits and Sums ----------------------------
Output all three-digit numbers between "m" and "n" inclusive such that
the cube of the digits of the three digit-number is equal to the number itself.
Output on new lines.

100 <= m <= n <= 999, where m <= n.

Sample Input
100 200

Sample Input Explanation
m n

Sample Output
153

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Calculate each number individually.
Extract each digit and find their sum:
    ones digit = num % 10
    tens digit = num / 10 % 10
              OR num % 100 / 10
    hundreds digit = num / 100 % 10
                  OR num % 1000 / 100 (redundant version of the former)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to find all three digit numbers between a range whose sum of digits cubed is equal to itself.
 * @author Vincent Zhang
 * @since 08 August 2021
 */
public class DigitsAndSums
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n;
        m = n = -1;
        
        try
        {
            String[] line = br.readLine().split(" ");
            m = Integer.parseInt(line[0]);
            n = Integer.parseInt(line[1]);
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }

        for(int i=m; i<=n; i++)
        {
            if(Math.pow(i%10, 3) + Math.pow(i/10%10, 3) + Math.pow(i/100%10, 3) == i)
            {
                System.out.println(i);
            }
        }
    }
}