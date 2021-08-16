/*
----------------------------------------------------------------------------------
---------------------------- BlueBook - Cross Country ----------------------------
Given a two digit code, output one of the following corresponding results.
If a code does not exist output "invalid code".

Code 	Output
MG 	    midget girls
MB 	    midget boys
JG 	    junior girls
JB 	    junior boys
SG 	    senior girls
SB 	    senior boys

Sample Input
JG

Sample Output
junior girls

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Store codes in a map or check cases with if-else.
*/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * Program to output the matching result of a code if it exists.
 * @author Vincent Zhang
 * @since 01 August 2021
 */
public class CrossCountry
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Map<String, String> data = new HashMap<>();
        data.put("MG", "midget girls");
        data.put("MB", "midget boys");
        data.put("JG", "junior girls");
        data.put("JB", "junior boys");
        data.put("SG", "senior girls");
        data.put("SB", "senior boys");

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        if(data.containsKey(s))
            System.out.println(data.get(s));
        else
            System.out.println("invalid code");
    }
}