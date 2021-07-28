/*
#################################################################################################
############################ CPC '21 Contest 1 P0 - AQT and Alphabet ############################
Find the first letter of the lowercase alphabet not in the input string.
The only line of input string will always contain 5 characters.

Sample Input
zdeac

Sample Input Explanation
L1: 5 characters of the lowercase alphabet.

Sample Output
b

########################################################################
############################ SOLUTION LOGIC ############################
In general, compare input string against alphabet.
Optimization: only first 6 letters of alphabet need to be checked since there are always 5 letters in input string.

Method 1 - Implemented using Haskell in Alphabet.hs:
    Subtract the input string from the lowercase alphabet and output the first character of the result.
Method 2 - Implemented using Python 3 in Alphabet.py:
    Construct a list of lowercase alpha characters not in input string, then output first element in list.
Method 3 - Implemented using C++ in Alphabet.cpp:
    Record occurance of each input string character in an array of length 26, then output the first element without a record.
Method 4 - Implemented using Java in Alphabet.java:
    Loop through integer value of alphabet and check if integer value exists in an array of integer value of the input string (char[]).
Method 5 - Implemented using C in Alphabet.c:
    Loop through characters of alphabet and check if character exists in input string.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to find the first lowercase alpha character not in a given string.
 * @author Vincent Zhang
 * @since 28 July 2021
 */
public class Alphabet
{
    /**
     * Converts string to integer array.
     * @param s String to be converted to integer array
     * @return Integer array of string where int is DEC value of ASCII char
     */
    static int[] strToIntArr(String s)
    {
        int[] result = new int[s.length()];

        for(int i=0; i<s.length(); i++)
        {
            result[i] = (int)(s.charAt(i));
        }

        return result;
    }

    /**
     * Check if an integer array contains an integer.
     * @param arr Array to check
     * @param v Value to check for
     * @return Whether "arr" contains "v".
     */
    static boolean contains(int[] arr, int v)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == v)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Get line of input.
        String s = null;
        try
        {
            s = br.readLine();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        // Store integer value.
        int[] sInt = strToIntArr(s);

        // Find first non existing alpha.
        for(int i=97; i<103; i++)
        {
            if(!contains(sInt, i))
            {
                System.out.println((char)i);
                break;
            }
        }
    }
}