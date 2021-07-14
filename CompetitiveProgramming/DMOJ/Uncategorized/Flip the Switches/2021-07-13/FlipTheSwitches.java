/*
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////// NEW REGEX SYNTAX SUMMARY ////////////////////////////
1. Match ending 0s.
    "0+$": ending with one or more 0s.
        "0+": one or more 0s.
        "$": ending with.

///////////////////////////////////////////////////////////////////////////
//////////////////////////// Flip the Switches ////////////////////////////
A security system is composed of "n" switches, where "0" represents off and "1" represents on.
Goal: deactivate the security system by turning off all switches.
You are only allowed to flip the first "k" switches at once. You may choose your own "k".
Find the minimum number of times switches need to be flipped to turn off the security system.

Sample Input
4
1001

Sample Input Explanation
Line 1: n, number of switches, i.e., number of characters in the following string.
Line 2: string of switch states.

Sample Output
3

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Use regular expression to count the number of matches to groups of 0s and 1s.
Trailling 0 must be removed from input string since they do not need to be flipped and will cause an erraneous answer when matched by the regular expression.
Java does not have a built-in trim end method like Python's .rstrip().
    An alternative is to match the last group of 0s with regular expression and replace ith with an empty string.
*/

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Program determines the minimum number of flip switches to turn off a security system.
 * @author Vincent Zhang
 * @since 13 July 2021
 */
public class FlipTheSwitches
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        // Instantiate Scanner. Number of switches is unimportant for this approach.
        Scanner sc = new Scanner(System.in); sc.nextLine();

        // Remove trailling 0s by matching with regex.
        String s = sc.nextLine().replaceAll("0+$", "");
        
        // Close scanner to prevent wasted resources.
        sc.close();

        /*
        // Java 9+. ".results()" is the Java 9+ component where it turns the matches into a Stream.
        System.out.println
        (
            Pattern.compile("0+|1+").matcher(s).results().count()
        );
        */

        // Java 8+.
        Matcher matcher = Pattern.compile("0+|1+").matcher(s);
        int count = 0; while(matcher.find()) count++;
        System.out.println(count);
    }
}