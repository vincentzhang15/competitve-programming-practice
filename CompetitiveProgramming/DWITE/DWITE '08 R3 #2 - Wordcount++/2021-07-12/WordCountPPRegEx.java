/*
////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// JAVA REGULAR EXPRESSION SYNTAX SUMMARY ////////////////////////////
1. Java 9+ Pattern Matcher: Count Matches
    import java.util.regex.Pattern;
    Pattern.compile("[A-Za-z]{4,}")
            // .compile(String regex) compiles the regex string into a pattern. In other words, convert regex string --> Pattern.
            .matcher(br.readLine())
            // Create a Matcher by comparing the parameter string with the Pattern instance.
            .results()
            // .results() returns a stream of match results. Java 9 constituent.
            .count()
            // Counts the number of elements in the stream.

2. Java 8+ Pattern Matcher: Count Matches
    import java.util.regex.Pattern;
    import java.util.regex.Matcher;

    Matcher matcher = Pattern.compile("[A-Za-z]{4,}")
                                .matcher(br.readLine());

    // Counting is the pre Java 9 alternative of "matcher.results().count()".
    int count = 0;
    while(matcher.find())
        // .find() attempts to find the next matching subsequence of the input sequence.
        count++;

///////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// DWITE '08 R3 #2 - Wordcount++ ////////////////////////////
Input consists of 5 lines. For every line, output the number of words that are at least 4 characters in length.
A word is anything made up of consecutive alpha characters (upper and lower case).

Sample Input
DWITE question number two: Wordcount++
Note how "two:" does not count.
For simplicity - "don't" is two words, split by apostrophe.

That was a blank line above.

Sample Output
4
3
4
0
4

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Match words with regular expression. Count the number of matches.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Program counts the number of words that are at least 4 characters in length.
 * @author Vincent Zhang
 * @since 12 July 2021
 */
public class WordCountPPRegEx
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException BufferedReader exception
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        // Instantiate BufferedReader.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Loop through the 5 lines of input.
        for(int i=0; i<5; i++)
        {
            // Java 9+.
            /*
            System.out.println
            (
                Pattern.compile("[A-Za-z]{4,}")
                       // .compile(String regex) compiles the regex string into a pattern. In other words, convert regex string --> Pattern.
                       .matcher(br.readLine())
                       // Create a Matcher by comparing the parameter string with the Pattern instance.
                       .results()
                       // .results() returns a stream of match results. Java 9 constituent.
                       .count()
                       // Counts the number of elements in the stream.
            );
            */

            // Java 8+.
            Matcher matcher = Pattern.compile("[A-Za-z]{4,}")
                                     .matcher(br.readLine());

            // Counting is the pre Java 9 alternative of "matcher.results().count()".
            int count = 0;
            while(matcher.find())
                // .find() attempts to find the next matching subsequence of the input sequence.
                count++;
            
            // Output results.
            System.out.println(count);
        }
    }
}