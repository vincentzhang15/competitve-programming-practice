/*
///////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// DWITE '07 R3 #2 - There's An Essay In My Code ////////////////////////////
Output all string literals and comments for each of the 5 lines.

Sample Input
function my_badly_named_function(); //this is a comment
puts "some string content" //and comments
go_go("gadget" /* notice extra spaces #/); //"for inline comment"
"nested 'strings'"
/*just some //comments#/

Sample Input Explanation
NOTE: all * / (without the space) tokens have been replaced with #/ for this comment as * / will disable the commenting.
The actual input should be * / without the space.

Sample Output
this is a comment
some string content and comments
gadget  notice extra spaces  "for inline comment"
nested 'strings'
just some //comments

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Step 1: find all valid matches.
    Method 1: looping.
    Method 2: regular expression (following solution uses this method).
Step 2: print the matches.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Finds string literals and comments.
 * @author Vincent Zhang
 * @since 17 July 2021
 */
public class EssayInMyCodeRegex
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException BufferedReader exception
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=0; t<5; t++)
        {
            String line = br.readLine();
            Matcher m = Pattern.compile("\".*?\"|'.*?'|\\/\\*.*?\\*\\/|\\/\\/.*").matcher(line);

            // Loop through matches.
            String output = "";
            while(m.find())
            {
                String match = m.group();
                char c1 = match.charAt(0);
                char c2 = match.charAt(1);

                // Build output result.
                if(c1 == '"') output += match.substring(1, match.length()-1) + " ";
                else if(c1 == '\'') output += match.substring(1, match.length()-1) + " ";
                else if(c1 == '/' && c2 == '*') output += match.substring(2, match.length()-2) + " ";
                else if(c2 == '/' && c2 == '/') output += match.substring(2);
            }

            // Output result.
            System.out.println(output.trim());
        }
    }
}