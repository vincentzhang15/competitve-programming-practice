"""
###########################################################################
############################ REGEX SUMMARY ################################
1. List All Matches
    import re; re.findall("regex", "string");

2. Regex Matches
    "\".*?\"|'.*?'|\/\*.*?\*\/|\/\/.*":
        |:
            Logical OR.
        \".*?\":
            \": start and end in double quotes
            .*?: match any character (excluding line terminators) 0 to unlimited times as few times as possible (non-greedy).
        '.*?':
            ': start and end in single quotes
            .*?: same as above
        \/\*.*?\*\/:
            \/: escape forward slash
            \*: escape asterisk
            .*?: same as above
        \/\/.*:
            \/: same as above
            .*: match any character 0 to unlimited times as many times as possible (greedy).

#######################################################################################################
############################ DWITE '07 R3 #2 - There's An Essay In My Code ############################
Output string literals and comments for each line in 5 lines.

Sample Input
function my_badly_named_function(); //this is a comment
puts "some string content" //and comments
go_go("gadget" /* notice extra spaces */); //"for inline comment"
"nested 'strings'"
/*just some //comments*/

Sample Output
this is a comment
some string content and comments
gadget  notice extra spaces  "for inline comment"
nested 'strings'
just some //comments

########################################################################
############################ SOLUTION LOGIC ############################
Find paring matches.
The following method uses regular expression to match quotes and comments.
Another way is to directly loop and search for characters.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 17 July 2021
@context Python 3 Autodidacticism
"""

# sys for fast input. re for regular expression.
import sys, re; input = sys.stdin.readline

for _ in range(5):
    output = ""
    # Store matches in list.
    matches = re.findall("\".*?\"|'.*?'|\/\*.*?\*\/|\/\/.*", input())
    
    for match in matches:
        if match[0] == '/' and match[1] == '*': output += match[2:-2] + " "
        if match[0] == '/' and match[1] == '/': output += match[2:]
        if match[0] == '\"': output += match[1:-1] + " "
        if match[0] == '\'': output += match[1:-1] + " "
    
    # Remove any extra space when concatenating.
    print(output.strip())