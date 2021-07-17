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
    Method 1: looping (following solution uses this method).
    Method 2: regular expression.
Step 2: print the matches.
*/

import java.util.Scanner;

/**
 * Output string literals and comments.
 * @author Vincent Zhang
 * @since 17 July 2021
 */
public class EssayInMyCodeLoop
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int t=0; t<5; t++)
        {
            String output = "";
            String line = sc.nextLine();
            for(int i=0; i<line.length(); i++)
            {
                char c = line.charAt(i);
                // Quotes.
                if(c == '"' || c == '\'')
                {
                    int end = line.indexOf(c, i+1);
                    output += line.substring(i+1, end) + " ";
                    i = end+1;
                }
                // Comments.
                else if(c == '/')
                {
                    char c2 = line.charAt(i+1);
                    // Multi-line comment.
                    if(c2 == '*')
                    {
                        int end = line.indexOf("*/");
                        output += line.substring(i+2, end) + " ";
                        i = end+2;
                    }
                    // Single-line comment.
                    else if(c == '/')
                    {
                        output += line.substring(i+2);
                        break;
                    }
                }
            }
            System.out.println(output.trim());
        }
        sc.close();
    }
}