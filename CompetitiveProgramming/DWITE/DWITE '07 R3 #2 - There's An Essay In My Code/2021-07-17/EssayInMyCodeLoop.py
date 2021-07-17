"""
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
The following solution uses loops to find the matches instead of regular expression.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 17 July 2021
@context Python 3 Autodidacticism
"""

for _ in range(5):
    output = ""
    line = input()

    i = 0
    while i < len(line):
        c = line[i]
        # Quotes.
        if c == '"' or c == '\'':
            endIdx = line.index(c, i+1)
            output += line[i+1:endIdx] + " "
            i = endIdx+1
        # Comments.
        elif c == '/':
            c2 = line[i+1]
            # Multi-line comments.
            if c2 == '*':
                endIdx = line.index("*/", i+2)
                output += line[i+2:endIdx] + " "
                i = endIdx+1
            # Single-line comments.
            elif c == '/' and c2 == '/':
                output += line[i+2:]
                break
        i += 1
    # Remove extra space.
    print(output.strip())