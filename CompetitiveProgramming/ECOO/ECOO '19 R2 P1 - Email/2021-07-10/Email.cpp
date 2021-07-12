/*
/////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// NEWLY LEARNT SYNTAX SUMMARY ////////////////////////////
1. size_t
    https://stackoverflow.com/questions/502856/whats-the-difference-between-size-t-and-int-in-c
    For understanding, think as unsigned 64 bit int used to represent size of object.
    "
    stdlib functions (e.g., malloc, sizeof, string operation functions) use size_t as a datatype.

    The actual type of size_t is platform-dependent;
    a common mistake is to assume size_t is the same as unsigned int,
    which can lead to programming errors, particularly as 64-bit architectures become more prevalent.
    "

2. tolower(char)

3. set
    set<string> emails;
    emails.insert(email);
    emails.size();
    emails.clear();

4. C++ Equivilent of Java string.indexOf()
    size_t idxPlus = rawEmail.find('+');
    if(idxPlus == string::npos)
        notFound();

////////////////////////////////////////////////////////////////////////////////
//////////////////////////// ECOO '19 R2 P1 - Email ////////////////////////////
In each of 10 sets of data, there will be emails. Find how many distinct emails there are based on the rules:
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
Line 1: n[0], number of emails for set 1.
Line 2 to n[0]+1: emails in set 1.
... etc.
Note: only 2 sets of data are shown here.

Sample Output:
2
1

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Find index of plus and at signs. Process accordingly.
Store processed email in set. Output the number of elements in the set.
*/

/**
 * Program to determine the number of distinct emails.
 * @author Vincent Zhang
 * @since 10 July 2021
 */
#include<bits/stdc++.h>
using namespace std;

/**
 * Function to turn a string to lowercase.
 * @param email The email to turn to lowercase
 * @return The email that has been converted to lowercase
 */
string toLower(string email)
{
    string copy = "";
    
    // Turn characters to lowercase one by one.
    for(size_t i=0; i<email.length(); i++)
        copy += tolower(email[i]);
    return copy;
}

/**
 * Function to remove periods in a string.
 * @param segment The segment to remove periods from
 * @return The segment without periods
 */
string removeDot(string segment)
{
    string copy = "";
    for(size_t i=0; i<segment.length(); i++)
        if(segment[i] != '.')
            copy += segment[i];
    return copy;
}

/**
 * Main function to run the distinct email identification program.
 * @return 0
 */
int main()
{
    // Speed up input.
    cin.sync_with_stdio(0);
    cin.tie(0);

    // Store emails in a set.
    set<string> emails;

    // Loop through the 10 sets of emails.
    for(int i=0; i<10; i++)
    {
        int n; cin >> n;
        // Loop through every email in each set.
        for(int j=0; j<n; j++)
        {
            string rawEmail; cin >> rawEmail;
            size_t idxAt = rawEmail.find('@');
            size_t idxPlus = rawEmail.find('+');

            // Segment 1 is everything before the at sign or the first plus sign depending on whether the plus sign exists.
            string segment1 = removeDot(rawEmail.substr(0, idxPlus == string::npos ? idxAt : idxPlus));
            // Segment 2 is everything at the "@" sign and after. 
            string segment2 = rawEmail.substr(idxAt, rawEmail.length() - idxAt);
            
            // Make email lowercase so set removes the repetitions due to case.
            string email = toLower(segment1 + segment2);
            emails.insert(email);
        }
        // Output result and prepare for next set of emails.
        cout << emails.size() << '\n';
        emails.clear();
    }

    return 0;
}