/*
///////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// DWITE '07 R3 #2 - There's An Essay In My Code ////////////////////////////
Output the string literals and comments in each line of 5 lines.

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
Steps:
    1. match all valid string literals and comments.
        Method 1: loop. (The following solution implements this method).
        Method 2: match with regex.
    2. output
*/

/**
 * Program to output the string literal and comment content using regular expression.
 * @author Vincent Zhang
 * @since 17 July 2021
 */
#include <iostream>

/**
 * Main method to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 If successful program termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    for(int t=0; t<5; t++)
    {
        std::string output = "";
        std::string line; std::getline(std::cin, line); line += " "; // Adjust for missing character at end in "//".
        for(size_t i=0; i<line.length(); i++)
        {
            char c = line[i];
            // String literals.
            if(c == '"' || c == '\'')
            {
                std::size_t endIdx = line.find(c, i+1);
                output += line.substr(i+1, endIdx-i-1) + " ";
                i = endIdx + 1;
            }
            // Comments.
            else if(c == '/')
            {
                char c2 = line[i+1];
                if(c2 == '*')
                {
                    std::size_t endIdx = line.find("*/", i+2);
                    output += line.substr(i+2, endIdx-i-2) + " ";
                    i = endIdx + 2;
                }
                else if(c2 == '/')
                {
                    output += line.substr(i+2);
                    break;
                }
            }
        }
        std::cout << output.substr(0, output.length()-1) << '\n';
    }

    return 0;
}