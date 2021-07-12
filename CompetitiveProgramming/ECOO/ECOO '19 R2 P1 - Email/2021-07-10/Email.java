/*
ECOO '19 R2 P1 - Email
Find the number of distinct emails for each of 10 set of emails.
Follow the rules:
"
    The entire address is case-insensitive.
    Dots (.) before the at-sign (@) sign are ignored.
    A plus (+) followed by any string can be added before the at-sign (@). The plus and following string are ignored.
"

Sample Input:
3
foo@bar.com
fO.o+baz123@bAR.com
foo@bar..com
3
c++@foo.com
c...@Foo.com
.c+c@FOO.COM

Sample Input Explanation:
Note: only two sets are shown.
Each set begins with "n", the number of emails in each set.
The "n" following lines contain the emails.

Sample Output:
2
1

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

/**
 * Program to find the number of distinct emails by following 3 rules.
 * The solution logic involves directly processing emails and storing them in a set.
 * The number of distinct emails is the size of the set.
 * 
 * @author Vincent Zhang
 * @since 10 July 2021
 */
public class Email
{
    /**
     * Main method to run the program.
     * @param args Command-line arguments.
     * @throws IOException
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        // Instantiations.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> emails = new HashSet<String>();

        // Loop through the 10 sets of data.
        for(int i=0; i<10; i++)
        {
            // Get the number of emails.
            int n = Integer.parseInt(br.readLine());

            // Process each email.
            for(int j=0; j<n; j++)
            {
                // Split the email into two segments by spliting at the "@" sign.
                String[] segment = br.readLine().split("@");
                
                // Process the strings. If a plus sign exists, go up to the plus sign only for the first segement.
                int idxPlus = segment[0].indexOf('+');
                String email = (segment[0].substring(0, idxPlus == -1 ? segment[0].length() : idxPlus)).replaceAll("\\.", "") + "@" + segment[1];
                // Recall: replaceAll() takes a regex string as its first parameter. Thus, escape "." with double backslash.

                // Add emails to set.
                emails.add(email.toLowerCase());
            }
            // Output.
            System.out.println(emails.size());

            // Clear set instead of re-instantiation for code clarity.
            emails.clear();
        }
    }
}