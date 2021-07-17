/*
//////////////////////////////////////////////////////////////////////////////
//////////////////////////// REGEX SYNTAX SUMMARY ////////////////////////////
1. C++ Regex Parameters
    #include <regex>
    std::string line; std::getline(std::cin, line);
    std::regex r("REGEX STRING");
    std::smatch match;

2. Regex Matching
    while(std::regex_search(line, match, r))
    {
        std::string str = match.str(0);
        line = match.suffix().str();
    }

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
        Method 1: loop.
        Method 2: match with regex.
    2. output
*/

/**
 * Program to output the string literal and comment content using regular expression.
 * @author Vincent Zhang
 * @since 17 July 2021
 */
#include <iostream>
#include <regex>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name + command-line arguments
 * @return 0 Successful termination if 0
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    for(int t=0; t<5; t++)
    {
        // Regex parameters.
        std::string line; std::getline(std::cin, line);
        std::regex r("\".*?\"|'.*?'|/\\*.*?\\*/|//.*");
        std::smatch match;

        // Match with regex.
        std::string output = "";
        while(std::regex_search(line, match, r))
        {
            std::string str = match.str(0);
            char c1 = str[0];
            char c2 = str[1];

            // Concatenation.
            if(c1 == '"') output += str.substr(1, str.length()-2) + " ";
            else if(c1 == '\'') output += str.substr(1, str.length()-2) + " ";
            else if(c1 == '/' && c2 == '*') output += str.substr(2, str.length()-4) + " ";
            else if(c1 == '/' && c2 == '/') output += str.substr(2) + " ";

            // Continue search after find.
            line = match.suffix().str();
        }
        // Output.
        std::cout << output.substr(0, output.length()-1) << '\n';
    }

    return 0;
}