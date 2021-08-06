/*
---------------------------------------------------------------------------------------
---------------------------- BlueBook - Find the Character ----------------------------
Count the number of occurances of a character in a string. Case insensitive.
String sentence will always terminate with a period.

Sample Input 1
o
Why so serious son.

Sample Input 1 Explanation
Line 1: character to find.
Line 2: string in which to find the character.

Sample Output 1
Why so serious son.
3

Sample Output 1 Explanation
Line 1: output the input string.
Line 2: number of canse insensitive occurances of input char in input string.

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Directly count. Make character lower case or upper case to count once.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to count occurances of a character in a string.
 * @author Vincent Zhang
 * @since 06 August 2021
 */
public class FindTheCharacter
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Read entire line of input.
     * @return Entire string line of input
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
        char c = readLine().charAt(0);
        String s; System.out.println(s = readLine());
        System.out.println(s.length() - (s.toLowerCase().replaceAll(c+"".toLowerCase(), "")).length());
    }
}